package com.bw.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.bw.Exception.MyException;
import com.bw.utils.AssertUtils;

public class AssertTest {
	
	
	/*
	 *1. 断言为真（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	@Test
	public void test1(){
		try {
			AssertUtils.isTrue(false,"这不是一个true");
/*			AssertUtils.isTrue(true,"这不是一个true");
*/		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 *2. 断言为假（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	@Test
	public void test2(){
		try {
			//AssertUtils.isfalse(false,"这不是一个false");
			AssertUtils.isfalse(true,"这不是一个false");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *3. 断言对象不为空（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	@Test
	public void test3(){
		try {
			AssertUtils.isnotnull("","这不是一个字符串");
			//AssertUtils.isnotnull("fafd","这不是一个字符串");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *4. 断言对象为空（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	@Test
	public void test4(){
		try {
			//AssertUtils.isnull("","这不是一个字符串");
			AssertUtils.isnull("fafd","这不是一个字符串");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	/*
	 *5.断言 List 或 Set 集合不为空，没有元素也算空； 
	 * */
	@Test
	public void test5(){
		try {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(100);
			AssertUtils.islist(list, "这个集合不是空的");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	/*
	/*
	 *6.断言 map 集合不为空，没有元素也算空； 
	 * */
	@Test
	public void test6(){
		try {
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.putIfAbsent("hahah", null);
			AssertUtils.ismap(map, "这个集合不是空的");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/*
	/*
	 *7.断言字符串必须有值，去掉空格后，长度必须大于 0；
	 * */
	@Test
	public void test7(){
		try {
			AssertUtils.isstr(" ", "这不是个字符串");
		//	AssertUtils.isstr("aaas", "这是个字符串");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	/*
	/*
	 8. 断言值必须是正数(值大于 0)；
	 * */
	@Test
	public void test8(){
		try {
		//	AssertUtils.isint(0, "这不是个正整数");
		//	AssertUtils.isint(-1, "这不是个正整数");
				AssertUtils.isint(1, "这不是个正整数");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
