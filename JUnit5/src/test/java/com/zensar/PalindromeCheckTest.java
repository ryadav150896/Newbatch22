package com.zensar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class PalindromeCheckTest {
	
	
@ParameterizedTest
@ValueSource(strings= {"MADAM","232","123"})
public void testPalindrome(String str) {
	PalindromeCheck pm=new PalindromeCheck();
	boolean actual=pm.isPalindrome(str);
	boolean expected=true;
	assertEquals(expected,actual);
	
}
}
