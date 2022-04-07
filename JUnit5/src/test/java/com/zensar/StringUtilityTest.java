package com.zensar;


import static org.junit.Assert.assertThrows;

public class StringUtilityTest {
	
	
	 public void convertToIntNullParameter() {
		 String str=null;
		assertThrows(IllegalArgumentException.class,()->{
			 StringUtility.convertToInt(str);
		 });
	 }

}
