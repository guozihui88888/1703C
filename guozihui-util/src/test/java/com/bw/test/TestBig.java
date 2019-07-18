package com.bw.test;

import java.math.BigDecimal;

import org.junit.Test;




public class TestBig{
	// Test 1 2 3 4为加减乘除
	@Test
	public void test1(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal add = bigDecimal.add(new BigDecimal(2));
		
		System.out.println(add);
	}
	
	@Test
	public void test2(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal jian = bigDecimal.subtract(new BigDecimal(2));
		
		System.out.println(jian);
	}
	
	@Test
	public void test3(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal cheng = bigDecimal.multiply(new BigDecimal(2));
		
		System.out.println(cheng);
	}
	
	@Test
	public void test4(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal chu = bigDecimal.divide(new BigDecimal(2),5,BigDecimal.ROUND_HALF_DOWN);
		
		System.out.println(chu);
	}
	//取小数点后二位  并且向上取整
	@Test
	public void test5(){
		BigDecimal bigDecimal = new BigDecimal(5.66666);
		BigDecimal scale = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_DOWN);
		System.out.println(scale);
		
	}
	
	//取小数点后二位  并且向上取整
	/*
	 * setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3 
	setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4 
	setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
	setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
	 * */
		@Test
		public void test6(){
			BigDecimal bigDecimal = new BigDecimal(5.111111);
			BigDecimal scale = bigDecimal.setScale(2,BigDecimal.ROUND_CEILING);
			System.out.println(scale);
			
		}
}
