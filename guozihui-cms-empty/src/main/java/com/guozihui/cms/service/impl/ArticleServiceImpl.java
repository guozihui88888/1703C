/**
 * 
 */
package com.guozihui.cms.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guozihui.cms.core.Page;
import com.guozihui.cms.dao.ArticleMapper;
import com.guozihui.cms.domain.Article;
import com.guozihui.cms.domain.User;
import com.guozihui.cms.service.ArticleService;
import com.guozihui.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午9:06:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}

	@Override
	public List<Article> queryAll(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.queryAll(article);
	}

	@Override
	public Article selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void bolgSaveOrUpdate(Article article, HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(article.getId()!=null){
			Date date = new Date();
			article.setUpdated(date);
			articleMapper.update(article);
		}else{
			Date date = new Date();
			article.setUpdated(date);
			article.setCreated(date);
			article.setHits(0);
			article.setDeleted(false);
			article.setStatus(1);
			article.setHot(true);
			article.setAuthor((User) request.getSession().getAttribute(Constant.LOGIN_USER));
			articleMapper.save(article);
		}
		
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void increaseHit(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.increaseHit(id);
	}

	@Override
	public List<Article> queryHotAll(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.queryHotAll(article);
	}
	
	
}
