package models;


public class Utility {


	
	public static boolean is_blank(String input){
		return (input == null || input.equals(""));
	}
	
	public static String filter(String input){
		
		if(Utility.is_blank(input))
			return input;
		
		StringBuffer filtered = 
				new StringBuffer(input.length());
		char c;
		for(int i=0; i<input.length(); i++) {
			c = input.charAt(i);
			switch(c) {
			case '<': filtered.append("&lt;"); break;
			case '>': filtered.append("&gt;"); break;
			case '"': filtered.append("&quot;"); break;
			case '&': filtered.append("&amp;"); break;
			default: filtered.append(c);
			}
		}
		return(filtered.toString());
	}
}
