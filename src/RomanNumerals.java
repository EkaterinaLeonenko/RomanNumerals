
public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		

		// BIG refactoring upon completion here - all multiple validity checks now moved into checkValidity method
        int res = checkValidity(romanNum);
        if (res < 0) return res; // 0 is ok - go forward
        
        // NOTE: All this TDD implemented checks, probably can be replaced by the following code, something like:
        // if (!(romanNum.length()!=0 && romanNum.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")))
        //		return -1;
        // Here we check for empty input and check for valid Roman numbers using standard regular expression available for them
        // It will work, but here is nothing to learn with regard of TDD 
		
		// - 8 - Input is valid - calculations
//      Tested ok and then refactored - see -9 -
//		return convertSingleNum(romanNum);
	
		// - 9 - Refactoring to any number without suntractions
		
		int sum = 0;
		String c;
		
		for (int i = 0; i < romanNum.length(); i++) {
			c = romanNum.substring(i,i+1);
			sum += convertSingleNum(c);
		}
		// Refactoring - 10 - Correct sum with necessary subtractions - which implemented in private method
		// return sum; 
		return sum - getSubtractions(romanNum);
		
	}
	
	private boolean hasWrongRepetition (String romanNum) {
		if (romanNum.contains("IIII") || romanNum.contains("XXXX") || romanNum.contains("CCCC") || romanNum.contains("MMMM")) 
			return true;
		// Refactoring - new check added
		else 	if (romanNum.contains("VV") || romanNum.contains("LL") || romanNum.contains("DD") ) 
					return true;
		 		else
		 			return false;
	}
	
	private boolean hasWrongSubtraction (String romanNum) {
		if (romanNum.contains("IL") || romanNum.contains("IC") || romanNum.contains("ID") || 
			romanNum.contains("IM") || romanNum.contains("XD") || romanNum.contains("XM"))
			return true;
		// Refactoring - new check added
		else 	if (romanNum.contains("IIV") || romanNum.contains("IIX") || romanNum.contains("XXL") ||
				    romanNum.contains("XXC") || romanNum.contains("CCD") || romanNum.contains("CCM")) 
					return true;
				// Refactoring - new check added
				else 	if (romanNum.contains("VX") || romanNum.contains("VC") || romanNum.contains("VM") ||
							romanNum.contains("LC") || romanNum.contains("LM") || romanNum.contains("DM")) 
							return true;
		 				else
		 					return false;
	}
	
	private int convertSingleNum (String str) {
		switch(str) {
		case "I": 
			return 1;
		case "V": 
			return 5;
		case "X": 
			return 10;
		case "L": 
			return 50;
		case "C": 
			return 100;
		case "D": 
			return 500;
		case "M": 
			return 1000;
		default:
			return -8;
		}
	}
	
	private int getSubtractions(String str) {
		int toSubtract = 0;
		if (str.contains("IV") || str.contains("IX")) {
			toSubtract += 1;
		}
		if (str.contains("XL") || str.contains("XC")) {
			toSubtract += 10;
		}
		if (str.contains("CD") || str.contains("CM")) {
			toSubtract += 100;
		}
		return toSubtract * 2; // * 2 - because we have already added them, so need to subtract them twice
	}

	
	// BIG Refactoring upon completion - all validations went here from public method
    private int checkValidity(String romanNum) {
    	// -1- Checking if input is empty
    	if (romanNum.isEmpty()) 
    		return -1;          // Yes - return -1
	
    	// -2- Check for not valid symbols
    	if (!romanNum.matches("[IVXLCDM]*")) // * means zero or more times
    		return -2;                                            
	
    	// -3- Check for not valid repetitions IXCM
    	//	if (romanNum.contains("IIII") || romanNum.contains("XXXX") || romanNum.contains("CCCC") || romanNum.contains("MMMM")) // check it!! 
    	//Refactoring!		
    	if (hasWrongRepetition (romanNum))
    		return -3;                                              
    	// -4- Check for not valid repetitions VLD
    	//		if (romanNum.contains("VV") || romanNum.contains("LL") || romanNum.contains("DD") ) // check it!! 
    	//Refactoring! Both 3 and 4 in one method now		
    	//	    return -4;
	
    	//	- 5 - 6 - 7 - Subtraction Rules implemented as a method from the beginning. Refactoring is in the method  
    	if (hasWrongSubtraction (romanNum))
    		return -4;  
    	
    	return 0; // all validations ok
    }
}
 