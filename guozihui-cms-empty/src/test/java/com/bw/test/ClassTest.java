package com.bw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guozihui.cms.domain.Article;
import com.guozihui.cms.domain.User;
import com.guozihui.cms.service.ArticleService;
import com.guozihui.cms.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class ClassTest {

	@Autowired
	ArticleService service;
	
	@Test
	public void Test1(){
		
	}
}
