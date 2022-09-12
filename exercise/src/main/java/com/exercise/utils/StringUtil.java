package com.exercise.utils;

public class StringUtil {
	public static boolean isNullOrEmpty(String value) {
		if (value != null && value != "" && value.trim() == "" ) {
			return false;
		}
		return true;
	}
}
