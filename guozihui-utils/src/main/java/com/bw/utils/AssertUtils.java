package com.bw.utils;

import java.util.Collection;
import java.util.HashMap;

import com.bw.Exception.MyException;

public class AssertUtils {
	
	
	/*
	 *1. 断言为真（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	public static void isTrue(boolean exp,String message) {
		if(!exp){
			throw new MyException(message);
		}
		
	}
	
	/*
	 *2. 断言为假（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	public static void isfalse(boolean exp,String message) {
		if(exp){
			throw new MyException(message);
		}
		
	}
	/*
	 *3. 断言对象不为空（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	public static void isnotnull(String exp,String message) {
		if(exp ==null || exp.length()>0){
			throw new MyException(message);
		}
		
	}
	
	/*
	 *4. 断言对象不为空（就是表达结果或参数必须为真，否则抛出自己的自定义异常）
	 * 
	 * */
	public static void isnull(String exp,String message) {
		if(!(exp ==null || exp.length()>0)){
			throw new MyException(message);
		}
		
	}
	
	/*
	   5.断言 List 或 Set 集合不为空，没有元素也算空；
	 * 
	 * */
	public static void islist(Collection<?> list,String message) {
		if(list==null || list.size()==0){
			throw new MyException(message);
		}
		
	}
	
	/*
	   6.断言 Map 集合不为空，没有元素也算空
	 * 
	 * */
	public static void ismap(HashMap<?, ?> map,String message) {
		if(map==null || map.size()==0){
			throw new MyException(message);
		}
		
	}
	
	

	/*
	 7. 断言字符串必须有值，去掉空格后，长度必须大于 0；
	
	 * */
	public static void isstr(String exp,String message) {
		if(exp==null || exp.trim().length()==0){
			throw new MyException(message);
		}
		
	}
	
	/*
	 8. 断言值必须是正数(值大于 0)；
	
	 * */
	public static void isint(int exp,String message) {
		if(exp<=0){
			throw new MyException(message);
		}
		
	}
}
