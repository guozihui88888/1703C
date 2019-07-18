package com.bw.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {
		
	public static  Object intutils(double i,BigDecimal j) {
		
		
		BigDecimal valueOf = BigDecimal.valueOf(i);
		BigDecimal add = valueOf.add(j);
		return add;
		
	}
	
	public static  Object jiantutils(double i,BigDecimal j) {
		
		
		BigDecimal valueOf = BigDecimal.valueOf(i);
		BigDecimal subtract = valueOf.subtract(valueOf);
		return subtract;
		
	}
	
	public static  Object tostrig(double i,BigDecimal j) {
		
		
		BigDecimal valueOf = BigDecimal.valueOf(i);
		String subtract = valueOf.toString();
		return subtract;
		
	}
	
	public static BigDecimal GoldenMean(int i) {
		BigDecimal big1 = new BigDecimal(1);
		BigDecimal big2 = new BigDecimal(2);
		BigDecimal tmp;
		while(i!=0) {
		tmp = big2;
		big2 = big2.add(big1);
		big1 = tmp;
		i--;
		}
		return big1.divide(big2,1000,BigDecimal.ROUND_HALF_EVEN);

	}
}
