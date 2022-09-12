package com.exercise.utils;

public class BuildingUtil {
	public static String convertCodeToStringBuildingType(String code) {
		switch (code) {
		case "tang-tret": {
			return "tầng trệt";
		}
		case "noi-that": {
			return "nội thất";
		}
		case "nguyen-can": {
			return "nguyên căn";
		}

		default:
			return null;
		}

	}
}
