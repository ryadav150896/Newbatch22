package com.zensar;

public class Addition {
	
	public Integer add(Integer a,Integer b) {
		System.out.println("this is add method");
		return a+b;
	}
	public Integer sub(Integer a,Integer b) {
		System.out.println("this is sub");
		return a-b; 

}
	public Integer mul(Integer a,Integer b) {
		return a*b;
	}
		
		public Integer division(Integer a,Integer b) {
			return a/b;
		}
		public int[] myArr() {
			return new int[] {1,2,3,4};
		}
		public String getName(String name) {
			if(name.length()!=0) {
				return name.toUpperCase();
				
			}throw new IllegalArgumentException("arg not found");
		}
	}
