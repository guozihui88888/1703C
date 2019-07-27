/**
 * 
 */
package com.guozihui.cms.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.guozihui.cms.core.Page;
import com.guozihui.cms.domain.Article;
import com.guozihui.cms.domain.Category;
import com.guozihui.cms.domain.Channel;
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
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		Page _page = new Page(page, 30);
		List<Article> articles = null;
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);

		//默认首页显示热门文章
		if(category == null && channel == null){
			conditions.setHot(true);
			
			//热门文章时显示幻灯片
			List<Slide> slides = slideService.getTops(5);
			model.addAttribute("slides", slides);
		}
		
		//如果频道或分类不为空，则显示分类或频道数据
		if(category != null){
			conditions.setCategory(new Category(category));
		}else if(channel != null){
			conditions.setChannel(new Channel(channel));
		}
		
		articles = articleService.gets(conditions, _page, null);
		model.addAttribute("articles", articles);
		

		//---------------右侧放10条最新文章---------------------
		Article lastArticlesConditions = new Article();
		lastArticlesConditions.setDeleted(false);
		lastArticlesConditions.setStatus(1);
		
		Page lastArticlesPage = new Page(1, 10);
		lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
		
		List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
		model.addAttribute("lastArticles", lastArticles);

		if(channel != null){
			model.addAttribute("channel", new Channel(channel));
		}
		
		List<Special> list =articleService.findspecial();
		model.addAttribute("list", list);
		model.addAttribute("category", category);
		
		return "home";
	}
	
	
	@RequestMapping("article")
	public String article (Integer id,ModelMap map){
		
		articleService.increaseHit(id);
		Article article = articleService.selectByPrimaryKey(id);
		
		map.addAttribute("blog", article);
		return "blog";
		
	}
	
	
	@RequestMapping("/admin/findbyspecial")
	public String findbyspecial(ModelMap map){
		
		List<Special> listsp =articleService.findbyspecial();
		map.addAttribute("listsp", listsp);
		return "/admin/homespecial";
		
	}
	@RequestMapping("/admin/addspecial")
	public String addspecial(ModelMap map){
		return "/admin/addspecial";
		
	}
	@RequestMapping("/admin/addspp")
	public String addspp(ModelMap map,Special special){
		int i =articleService.addspp(special);
		return "/admin/homespecial";
		
	}
	@RequestMapping("/admin/findarticle")
	public String findarticle(ModelMap map,Integer id){
		System.out.println(id);
		List<Article> listart =articleService.findarticle(id);
		System.out.println(listart);
		map.addAttribute("listart", listart);
		map.addAttribute("sid",id);
		return "/admin/homelist";
		
	}
	@RequestMapping("/admin/removespec")
	public String removespec(ModelMap map,Integer id){
		int i =articleService.removespec(id);
		if(i>0){
			map.addAttribute("移除成功", "delmsg");
			return "/admin/homelist";
		}
		return null;
		
	}
	@RequestMapping("/admin/jiaspecial")
	public String addspecial(ModelMap map,Integer aid,Integer sid){
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		System.out.println(sid);
		hashMap.put("aid", aid);
		hashMap.put("sid", sid);
		
		int i = articleService.addspecial(hashMap);
		
		
		return "redirect:/admin/findbyspecial";
		
	}
	@RequestMapping("/admin/updatespe")
	@ResponseBody
	public Special updatespe(ModelMap map,Integer id) throws ParseException{
		Special special = articleService.updatespe(id);
		String string = special.getCreated();
		String[] split = string.split(" ");
		special.setCreated(split[0]);
		return special;
		
	}
	
	@RequestMapping("/admin/update")
	public String update(ModelMap map,Integer id){
		map.addAttribute("id",id);
		return "/admin/updatespe";
		
	}
	
	@RequestMapping("/admin/updateAll")
	public String updateAll(ModelMap map,Special special){
		int i =articleService.updateAll(special);
		
		return "redirect:/admin/findbyspecial";
		
	}
}
