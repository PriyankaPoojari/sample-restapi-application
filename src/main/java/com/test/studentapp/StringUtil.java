package com.test.studentapp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	private static Pattern NUMBERONLY = Pattern.compile("\\d+"); // ONLY positive number 
	private static Pattern ALPHABETSONLY = Pattern.compile("^[a-zA-Z]*$"); // ONLY Alphabets
	private static Pattern NUMBERALPHA = Pattern.compile("^\\d+[a-zA-Z]{1}"); // starts with number- followed by 1alhapbet 
	
	public static boolean isNumeric(String value) {
	    if (value == null) {
	        return false; 
	    }
		return NUMBERONLY.matcher(value).matches();
	}
	
	public static boolean isAlphabet(String value) {
		if(isEmpty(value)) return false; 
		return ALPHABETSONLY.matcher(value).matches();
	}
	
	public static boolean isClass(String value) {
	    if (value == null) {
	        return false; 
	    }
		return NUMBERALPHA.matcher(value).matches();
	}
	
	// Checks null or isEmpty
	public static boolean isEmpty(String value) {
	   boolean ret = (StringUtils.isEmpty(value))? true: false;
	   return ret;
	}
	
	public static List<String> getMatches(String value, String ptn) {
		  List<String> returnValue = new ArrayList();
		  if (isEmpty(value)) return returnValue;
		  
		  Pattern pattern = Pattern.compile(ptn);
		  Matcher matcher = pattern.matcher(value);
		  while(matcher.find()) {
			  IntStream.rangeClosed(1, matcher.groupCount()).forEach(n->{
				  returnValue.add(matcher.group(n));
			  
			  });
		  }
		  return returnValue;
	}
	
	

}
