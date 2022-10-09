package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.Calculator;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void calculateProper() {
		try {
			int expectedValue = -76396;
			String num = "12435 + 34569 - 12345 * 10 + 50";
			char[] expressionArray = num.toCharArray();
			;
			Calculator calculator = new Calculator();
			int actualValue = calculator.calculate(expressionArray);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

	@Test
	public void checkInvalid1() {
		try {
			boolean expectedValue = true;
			String num = "12435 + 34569 - 12345 * 10 + test";
			Calculator calculator = new Calculator();
			boolean actualValue = calculator.checkInvalid(num);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

	@Test
	public void checkInvalid2() {
		try {
			boolean expectedValue = true;
			String num = "12435 + 34569 - 12345 * 10 ++ 50";
			Calculator calculator = new Calculator();
			boolean actualValue = calculator.checkInvalid(num);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

	@Test
	public void checkInvalid3() {
		try {
			boolean expectedValue = false;
			String num = "12435 + 34569 - 12345 * 10 + 50";
			Calculator calculator = new Calculator();
			boolean actualValue = calculator.checkInvalid(num);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

	@Test
	public void applyOperation() {
		try {
			int expectedValue = 11;
			char oper = '+';
			int var2 = 2;
			int var1 = 9;
			Calculator calculator = new Calculator();
			int actualValue = calculator.applyOperation(oper, var2, var1);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			assertEquals(expectedValue, actualValue);

		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}
}