
package com.guozihui.cms.web.controllers;

import java.io.File;
import java.io.IOException;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guozihui.cms.core.Page;
import com.guozihui.cms.domain.Article;
import com.guozihui.cms.domain.Category;
import com.guozihui.cms.domain.Channel;
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
	
	@RequestMapping("/blogs")
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
	
	
	@RequestMapping("/blog/edit")
	public String edit(Integer id,ModelMap map){
		if(id!=null){
			Article article = articleService.selectByPrimaryKey(id);
			map.put("blog",article);
		}
		
		return "user-space/blog_edit";
		
	}
	
	//发布博客的内容
	@RequestMapping("/blog/save")
	public String blog_save(Article article ,MultipartFile file,HttpServletRequest request){
		
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")){
			article.setPicture(upload);
		}
		articleService.bolgSaveOrUpdate(article,request);
		return "redirect:/my/blogs";
			
	}
	
	@RequestMapping("/blog/remove")
	public Boolean delete(Integer id){
		articleService.updatearticle(id);
		return true;
	}
	
	//用户信息的完事和修改
	@RequestMapping("/user/save")
	public String usersave(User user,ModelMap map){
		userService.updatebyId(user);
		return "redirect:/my/userInfo";
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request,ModelMap map){
		User loginUser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		
		User user =userService.selectById(loginUser.getId());
		map.addAttribute("user", user);
		return "user-space/useredit";
		
	}
	
	@RequestMapping("/hots")
	public String hots(HttpServletRequest request,ModelMap map){
		User loginUser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		
		Article article = new Article();
		article.setAuthor(loginUser);
		article.setHot(true);
		List<Article> blogs =articleService.queryHotAll(article);
		PageInfo<Article> pageInfo = new PageInfo<Article>(blogs);
		String pageList = PageHelpUtil.page("blogs", pageInfo);
		map.put("pageList", pageList);
		map.put("blogs", blogs);
		return "user-space/blog_list";
			
			
	}
	
	@RequestMapping("/review")
	public String review(HttpServletRequest request,ModelMap map){
		User loginUser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		
		Article article = new Article();
		article.setAuthor(loginUser);
		article.setStatus(1);
		List<Article> blogs =articleService.queryAll(article);
		PageInfo<Article> pageInfo = new PageInfo<Article>(blogs);
		String pageList = PageHelpUtil.page("blogs", pageInfo);
		map.put("pageList", pageList);
		map.put("blogs", blogs);
		return "user-space/blog_list";
			
			
	}
	
	@RequestMapping("/deleted")
	public String deleted(HttpServletRequest request,ModelMap map){
		User loginUser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		
		Article article = new Article();
		article.setAuthor(loginUser);
		article.setDeleted(true);
		List<Article> blogs =articleService.queryAll(article);
		PageInfo<Article> pageInfo = new PageInfo<Article>(blogs);
		String pageList = PageHelpUtil.page("blogs", pageInfo);
		map.put("pageList", pageList);
		map.put("blogs", blogs);
		return "user-space/blog_list";
			
			
	}
	@RequestMapping("/profile/avatar")
	public String avatar(HttpServletRequest request,ModelMap map){
		User u =(User) request.getSession().getAttribute(Constant.LOGIN_USER);
		map.addAttribute("user", u);
		return "user-space/avatar";
		
	}
	
	@RequestMapping("/avatar/edit")
	public String edit(HttpServletRequest request,ModelMap map,User user,MultipartFile file){
		User u =(User) request.getSession().getAttribute(Constant.LOGIN_USER);
		
		String upload = FileUploadUtil.upload(request, file);
		if(upload.equals("")){
			map.put("msg", "您还没有选择头像");
			return "redirect:/my/profile/avatar";
		}
		user.setAvatar(upload);
		userService.UpdateAvatar(user);
		User user2 = userService.get(user.getId());
		request.getSession().setAttribute(Constant.LOGIN_USER,user2);
		map.put("msg", "头像上传成功");
		return "redirect:/my/profile/avatar";
		
	}
}
