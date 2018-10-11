import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRomanNumerals {

	private RomanNumerals rn; // Define an object
	
	@Before
	public void init() {
		rn = new RomanNumerals(); // and create it
	}
	
	
	// Set of test cases below
	@Test
	// The very first step - check for empty input
	public void test_empty_string() throws Exception {
		assertEquals("Input is empty!",-1, rn.convertToInteger(""));
	}

	
	// NOTE! Valid tests 2 - to 4 refactored after implementing code - 9 -. 0 replaced by valid number
	// NOTE! Valid tests 5 - to 7 refactored after implementing code - 10 -. 0 replaced by valid number
	
	@Test
	// 2  - check for input contains only valid symbols
	public void test_not_valid_symbols() throws Exception {
		assertEquals("Input contains Not valid symbols!",-2, rn.convertToInteger("ZI"));
		assertEquals("Input contains only valid symbols!",11, rn.convertToInteger("XI"));
	}

//	@Test
//	// 3  - symbols I, X, C, and M can be repeated at most 3 times in a row
//	public void test_not_valid_repeatingsIXCM() throws Exception {
//		assertEquals("Input contains Not valid repeatings!",-3, rn.convertToInteger("XXXXI"));
//		assertEquals("Input contains only valid repeatings!",0, rn.convertToInteger("XXXI"));
//	}
//
//	@Test
//	// 4  - symbols V, L, and D can never be repeated
//	public void test_not_valid_repeatingsVLD() throws Exception {
//		assertEquals("Input contains Not valid repeatings!",-4, rn.convertToInteger("XXXIVV"));
//		assertEquals("Input contains only valid repeatings!",0, rn.convertToInteger("XXXIV"));
//	}
	 
	// Test refactoring as well - 3 and 4 in one now
	@Test
	// 3  - symbols I, X, C, and M can be repeated at most 3 times in a row
  	// 4  - symbols V, L, and D can never be repeated
	public void test_not_valid_repetitions() throws Exception {
		assertEquals("Input contains Not valid repeatings!",-3, rn.convertToInteger("XXXXI"));
		assertEquals("Input contains only valid repeatings!",31, rn.convertToInteger("XXXI"));
		assertEquals("Input contains Not valid repeatings!",-3, rn.convertToInteger("XXXVV"));
		assertEquals("Input contains only valid repeatings!",35, rn.convertToInteger("XXXV"));
	}
	
	// Test refactoring as follow - adding new asserts for each new condition
	@Test
	public void test_not_valid_subtractions() throws Exception {
		// 5  - The '1' symbols (I, X, and C) can only be subtracted from the 2 next highest values
	  	assertEquals("Input contains Not valid subtractions!",-4, rn.convertToInteger("IM"));
		assertEquals("Input contains only valid subtractions!",4, rn.convertToInteger("IV"));
		// 6  - Only one subtraction can be made per numeral (XC is allowed, XXC is	not)
		assertEquals("Input contains Not valid subtractions!",-4, rn.convertToInteger("XXC"));
		assertEquals("Input contains only valid subtractions!",90, rn.convertToInteger("XC"));
		// 7  - The '5' symbols (V, L, and D) can never be subtracted
		assertEquals("Input contains Not valid subtractions!",-4, rn.convertToInteger("VX"));
	}

	@Test
	// 8  - check every single number
	public void test_valid_single_number() throws Exception {
		assertEquals("Not valid single number!",1, rn.convertToInteger("I"));
		assertEquals("Not valid single number!",5, rn.convertToInteger("V"));
		assertEquals("Not valid single number!",10, rn.convertToInteger("X"));
		assertEquals("Not valid single number!",50, rn.convertToInteger("L"));
		assertEquals("Not valid single number!",100, rn.convertToInteger("C"));
		assertEquals("Not valid single number!",500, rn.convertToInteger("D"));
		assertEquals("Not valid single number!",1000, rn.convertToInteger("M"));
	}

	@Test
	// 9  - check valid numbers without subtraction
	public void test_valid_without_subtractions() throws Exception {
		assertEquals("Not valid number!",2, rn.convertToInteger("II"));
		assertEquals("Not valid number!",6, rn.convertToInteger("VI"));
		assertEquals("Not valid number!",12, rn.convertToInteger("XII"));
		assertEquals("Not valid number!",60, rn.convertToInteger("LX"));
	}

	@Test
	// 10  - check any valid numbers 
	public void test_valid_any_number() throws Exception {
		assertEquals("Not valid number!",45, rn.convertToInteger("XLV"));
		assertEquals("Not valid number!",4, rn.convertToInteger("IV"));
		assertEquals("Not valid number!",1984, rn.convertToInteger("MCMLXXXIV"));
		assertEquals("Not valid number!",2014, rn.convertToInteger("MMXIV"));
		assertEquals("Not valid number!",3999, rn.convertToInteger("MMMCMXCIX"));
	}

} 
