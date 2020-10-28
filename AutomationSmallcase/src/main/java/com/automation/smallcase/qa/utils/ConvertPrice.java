package com.automation.smallcase.qa.utils;

public class ConvertPrice {

	public static void main(String args[]) {
		//System.out.println("hello");
		String str1= "11499"	;
		int num=0;
		for(int i=0; i<str1.length(); i++) {

			char c= str1.charAt(i);
			if(c==num) {
				StringBuilder sb= new StringBuilder();
				sb.append(c);
				System.out.println(sb);
			}
		}
	}
}
