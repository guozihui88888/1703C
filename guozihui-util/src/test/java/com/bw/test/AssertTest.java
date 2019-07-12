package com.bw.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.bw.myExecption.MyExecption;
import com.bw.utils.AssertUtils;

public class AssertTest {
	
	/*
	 * 断言为真（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	@Test
	public void Test1(){
		try {
		//	AssertUtils.istrue(true, "这不是一个true");
			AssertUtils.istrue(false, "这不是一个true");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 断言为假（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	@Test
	public void Test2(){
		try {
			AssertUtils.isfalse(true, "这不是一个false");
		//	AssertUtils.isfalse(false, "这不是一个false");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	断言对象不为空；（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	@Test
	public void Test3(){
		try {
		//	AssertUtils.isnull("", "这不是一个对象");
			AssertUtils.isnull(null, "这不是一个对象");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	断言对象必须为空；（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	@Test
	public void Test4(){
		try {
			//AssertUtils.isnotnull(1, "这个对象必须为空");
			AssertUtils.isnotnull(null, "这个对象必须为空");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	断言 List 或 Set 集合不为空，没有元素也算空
	 * */
	@Test
	public void Test5(){
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			//list.add(1);
			AssertUtils.islist(list, "这个集合不能为空");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	断言 map 集合不为空，没有元素也算空
	 * */
	@Test
	public void Test6(){
		try {
			HashMap<String, Integer> map = new HashMap<String,Integer>();
			map.put("1", 1);
			AssertUtils.ismap(map, "这个集合不能为空");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	断言字符串必须有值，去掉空格后，长度必须大于 0；
	 * */
	@Test
	public void Test7(){
		try {
		//	AssertUtils.isstr(" ", "这个字符串必须有至");
			AssertUtils.isstr("qwqw qwq", "这个字符串必须有至");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	断言值必须是正数(值大于 0)；
	 * */
	@Test
	public void Test8(){
		try {
		//	AssertUtils.isint(0, "这个数字必须是正数");
		//		AssertUtils.isint(-1, "这个数字必须是正数");
			AssertUtils.isint(11, "这个数字必须是正数");
			
		} catch (MyExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
