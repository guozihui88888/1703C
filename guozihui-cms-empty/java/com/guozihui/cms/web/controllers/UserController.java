
package com.guozihui.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guozihui.cms.core.Page;
import com.guozihui.cms.domain.Article;
import com.guozihui.cms.domain.Category;
import com.guozihui.cms.domain.Channel;
import com.guozihui.cms.domain.Picture;
import com.guozihui.cms.domain.User;
import com.guozihui.cms.service.ArticleService;
import com.guozihui.cms.service.UserService;
import com.guozihui.cms.utils.FileUploadUtil;
import com.guozihui.cms.utils.PageHelpUtil;
import com.guozihui.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	@Resource
	UserService userService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	
	@RequestMapping("/")
	public <T> String blogs(ModelMap map,@RequestParam(defaultValue="1",required=false)Integer page,HttpSession session){
	Article article = new Article();
	
	User user =(User) session.getAttribute(Constant.LOGIN_USER);
	article.setAuthor(user);
	PageHelper.startPage(page,3);
	List<Article> blogs =articleService.queryAll(article);
	System.out.println(blogs);
	PageInfo<Article> pageInfo = new PageInfo<Article>(blogs);
	String pageList = PageHelpUtil.page("blogs", pageInfo);
	map.put("pageList", pageList);
	map.put("blogs", blogs);
		return "user-space/blog_list";
		
	}
	@RequestMapping("/blog/")
	public String edit(Integer id,ModelMap map){
		if(id!=null){
			Article article = articleService.selectByPrimaryKey(id);
			map.put("blog",article);
		}
		
		return "user-space/blog_edit";
		
	}
	

}
