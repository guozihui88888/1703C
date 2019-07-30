/**
 * 
 */
package com.guozihui.cms.service.impl;

import java.util.Date;
import java.util.HashMap;
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
import com.guozihui.cms.domain.Special;
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
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleMapper.update(article);
	}

	@Override
	public void save(Article article) {
		// TODO Auto-generated method stub
		articleMapper.save(article);
	}

	@Override
	public Article selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void increaseHit(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.increaseHit(id);
	}

	

	
	
}
