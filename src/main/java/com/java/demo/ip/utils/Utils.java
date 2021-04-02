package com.java.demo.ip.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static boolean validateFormatIp(String ip) {
		Pattern pat = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
		Matcher mat = pat.matcher(ip);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
}
