package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{
    @Test
	public void calculateProper() {
		try {
			int expectedValue = -76396;
			String num = "12435 + 34569 - 12345 * 10 + 50";
			char[] expressionArray = num.toCharArray();
			;
			Calculator calculator = new Calculator();
			int actualValue = Calculator.calculate(expressionArray);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}
}
