package com.farm.utility;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean isValid(String s) 
	{ 
	      
	    // The given argument to compile() method  
	    // is regular expression. With the help of  
	    // regular expression we can validate mobile 
	    // number.  
	    // 1) Begins with 0 or 91 
	    // 2) Then contains 7 or 8 or 9. 
	    // 3) Then contains 9 digits 
	    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	  
	    // Pattern class contains matcher() method 
	    // to find matching between given number  
	    // and regular expression 
	    Matcher m = p.matcher(s); 
	    return (m.find() && m.group().equals(s)); 
	} 
	public static boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
	public static boolean isValidUsername(String s) 
	{ 
	      System.out.println("inside uername validator");
	   
	    Pattern p = Pattern.compile("^[A-Za-z ]*$"); 
	  
	    
	    Matcher m = p.matcher(s); 
	    return (m.find() && m.group().equals(s)); 
	}
	public static boolean isValidMobile(String s) 
	{ 
	      
	   
	    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	  
	  
	    Matcher m = p.matcher(s); 
	    return (m.find() && m.group().equals(s)); 
	}
	
	public static String getPath(){
		return ResourceBundle.getBundle("system").getString("getPath");
	}
}
