/**
 * 
 */
package com.guozihui.cms.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.guozihui.cms.core.Page;
import com.guozihui.cms.domain.Article;
import com.guozihui.cms.domain.Category;
import com.guozihui.cms.domain.Channel;
import com.guozihui.cms.domain.Picture;
import com.guozihui.cms.domain.Slide;
import com.guozihui.cms.domain.Special;
import com.guozihui.cms.service.ArticleService;
import com.guozihui.cms.service.SlideService;

/**
 * 说明:首页
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午8:19:15
 */
@Controller
public class HomeController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	public static List<Article> articles = null;
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		Page _page = new Page(page, 30);
		
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);
		
		
		// TODO Auto-generated method stub		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//默认首页显示热门文章
				if(category == null && channel == null){
					conditions.setHot(true);					
					//热门文章时显示幻灯片
					List<Slide> slides = slideService.getTops(5);
					model.addAttribute("slides", slides);
				}
				
			}
		});
		t1.start();
		
		
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				//如果频道或分类不为空，则显示分类或频道数据
				if(category != null){
					conditions.setCategory(new Category(category));
				}else if(channel != null){
					conditions.setChannel(new Channel(channel));
				}
				
				articles = articleService.gets(conditions, _page, null);
				model.addAttribute("articles", articles);
			}
		});
		t2.start();
		
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				
				Page lastArticlesPage = new Page(1, 10);
				lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("lastArticles", lastArticles);
			}
		});
		
		t3.start();
		//---------------右侧放10条最新文章---------------------
		
		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(channel != null){
					model.addAttribute("channel", new Channel(channel));
				}
				model.addAttribute("category", category);
				
				
			}
		});
		t4.start();
		
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Article newpicture = new Article();
				newpicture.setDeleted(false);
				newpicture.setStatus(1);
				newpicture.setArticletype(1);
				Page lastArticlesPage = new Page(1, 5);
				lastArticlesPage.setTotalCount(50);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> picAriticleList = articleService.gets(newpicture, lastArticlesPage, null);
				System.out.println(picAriticleList);
				model.addAttribute("picAriticleList", picAriticleList);
			}
		});
		
		t5.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	
	@RequestMapping("article")
	public String article(ModelMap map,Integer id){
		
		articleService.increaseHit(id);
		Article article =articleService.selectByPrimaryKey(id);
		if(article.getContent()!=null && article.getContent().length()>0){
			List<Picture> pictures = JSONArray.parseArray(article.getContent(),Picture.class);
			System.out.println(pictures);
			map.put("pictures", pictures);
		}
		
		
		map.put("article", article);
		return "blog";
		
	}
	
}
