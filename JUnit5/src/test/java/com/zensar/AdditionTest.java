package com.zensar;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdditionTest {
	Addition a = null;
	/*@Test
    @DisplayName("Custom test name")
   public void testWithDisplayName() {
    }*/
	
	@BeforeAll
	public static void beforeClassTestMethod() {
		System.out.println("hello");
	}

	@BeforeEach
	public  void  beforeEveryTestCase() {

		 a = new Addition();
		System.out.println("hello");
		
	}

	@Test
	public void test_add() {

		int actualResult = a.add(4, 5);
		int expectedResult = 9;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void test_sub() {
		Addition a = new Addition();
		int actualResult =a.sub(5, 3);
		int expectedResult = 2;
		Assertions.assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testMultiply() {
		int actualResult = a.mul(6, 5);
		int expectedResult = 30;
		Assertions.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testDivision() {
		int actualResult = a.division(6, 3);
		int expectedResult = 2;
		Assertions.assertEquals(expectedResult, actualResult);
		
	}

	@Test
	public void testString() {
		String actual = a.getName("ravi");
		String expected = "RAVI";
		Assertions.assertEquals(expected, actual);

	}

	@Test()
	public void testStringForException() {
		assertThrows(IllegalArgumentException.class,()->{
			a.getName("");
		});
		
	}
	@AfterEach
	public void AfterEveryTestCase() {
		System.out.println("after");
	}
	@AfterAll
	public static void AfterAllTestCase() {
		System.out.println("Afterall");
	}
}
