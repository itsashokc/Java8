package com.test;

import java.util.function.Function;
import java.util.function.Predicate;

public class BricksConsturction {

	private int FIVE_INCH_BRICKS = 3;
	private int THREE_INCH_BRICKS = 5;
	private int Two_INCH_BRICKS = 2;
	
	private String isPossibleToConstruct(int length) {
		int sum = 0;
		boolean result = false;;
		for(int i=0;i<FIVE_INCH_BRICKS;i++) {
			if(length > 5) {
				sum = sum + 5;
//				length = length - 5;
				if(sum == length) result = true;
				else if(length - sum < 3) sum = sum - 5;
				else if(sum < length) {
					continue;
				} 
			
			}
		}
		length = length - sum;
		
		if(!result)
		for(int i=0;i<THREE_INCH_BRICKS;i++) {
			if( length > 3) {
				sum = sum + 3;
				if(sum == length) result = true;
				else if(length - sum < 2) sum = sum - 3;
				if(sum < length) {
					continue;
				}
			}
		}
		
		length = length - sum;
		if(!result)
		for(int i=0;i<Two_INCH_BRICKS;i++) {
			sum = sum + 2;
			if(sum == length) result = true;
			if(sum < length) {
				continue;
			} else break;
		}
		
		return "true";
	}
	
	public static void main(String arg[]) {
		BricksConsturction bc = new BricksConsturction();
		Function<Integer, String> fn = bc::isPossibleToConstruct;
		System.out.println(fn.apply(20));	
		System.out.println(fn.apply(16));	
	}
}
