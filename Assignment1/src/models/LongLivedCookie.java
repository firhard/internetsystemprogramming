package models;

import javax.servlet.http.*;

public class LongLivedCookie {
	public static final int SECONDS_PER_YEAR = 60*60*24*365;
	public LongLivedCookie(String name, String value) { 
		super(name, value);
		setMaxAge(SECONDS_PER_YEAR);
	}
}
