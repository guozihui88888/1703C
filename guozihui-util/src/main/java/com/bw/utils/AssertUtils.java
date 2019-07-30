package com.bw.utils;

import java.util.Collection;
import java.util.HashMap;

import com.bw.myExecption.MyExecption;

public class AssertUtils {
	
	/*
	 * 断言为真（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	
	public static void istrue(boolean exp,String message) {
		if(!exp){
			throw new MyExecption(message);
		}
	}
	
	/*
	 * 断言为假（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	
	public static void isfalse(boolean exp,String message) {
		if(exp){
			throw new MyExecption(message);
		}
	}
	

	/*
	 断言对象不为空；（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	
	public static void isnull(Object exp,String message) {
		if(exp==null ){
			throw new MyExecption(message);
		}
	}
	
	/*
	 断言对象必须为空；（就是表达结果或参数必须为真，否则抛出自己的自定义
		异常）；
	 * */
	
	public static void isnotnull(Object exp,String message) {
		if(!(exp==null) ){
			throw new MyExecption(message);
		}
	}
	
	/*
	断言 List 或 Set 集合不为空，没有元素也算空
	 * */
	
	public static void islist(Collection<?> exp,String message) {
		if(!(exp==null || exp.size()>0 )){
			throw new MyExecption(message);
		}
	}
	
	/*
	断言 List 或 Set 集合不为空，没有元素也算空
	 * */
	
	public static void ismap(HashMap<?, ?> exp,String message) {
		if(!(exp==null || exp.size()>0 )){
			throw new MyExecption(message);
		}
	}
	
	/*
	断言字符串必须有值，去掉空格后，长度必须大于 0；
	 * */
	
	public static void isstr(String exp,String message) {
		if(exp==null ||exp.trim().length()==0){
			throw new MyExecption(message);
		}
	}
	
	
	/*
	断言值必须是正数(值大于 0)；
	 * */
	
	public static void isint(int exp,String message) {
		if(exp<=0){
			throw new MyExecption(message);
		}
	}
}
