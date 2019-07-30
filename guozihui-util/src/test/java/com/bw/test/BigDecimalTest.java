package com.bw.test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.Test;

import com.bw.utils.BigDecimalUtils;

public class BigDecimalTest {
	@Test
	public void test1(){
		BigDecimal big =new BigDecimal("5.5");
		Object intutils = BigDecimalUtils.intutils(5.5, big);
		System.out.println(intutils);
	}
	
	@Test
	public void test2(){
		BigDecimal bigs =new BigDecimal(3);
		Object jianuitl = BigDecimalUtils.jiantutils(5.5, bigs);
		System.out.println(jianuitl);
	}
	
	@Test
	public void test3(){
		  NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用 
		    NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用 
		    percent.setMaximumFractionDigits(3); //百分比小数点最多3位 

		    BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
		    BigDecimal interestRate = new BigDecimal("0.008"); //利率   
		    BigDecimal interest = loanAmount.multiply(interestRate); //相乘

		    System.out.println("贷款金额:\t" + currency.format(loanAmount)); 
		    System.out.println("利率:\t" + percent.format(interestRate)); 
		    System.out.println("利息:\t" + currency.format(interest)); 
	}
	
	@Test
	public void test4(){	
		  BigDecimal a = new BigDecimal("1");
		    BigDecimal b = new BigDecimal("2");
		    BigDecimal c = new BigDecimal("1");
		    int result1 = a.compareTo(b);
		    int result2 = a.compareTo(c);
		    int result3 = b.compareTo(a);
		    System.out.println(result1);
		    System.out.println(result2);
		    System.out.println(result3);

	}
	
	@Test
	public void test5(){
		
	}
}

