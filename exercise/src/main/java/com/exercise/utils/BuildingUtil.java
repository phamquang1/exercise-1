package com.exercise.utils;

import java.util.HashMap;
import java.util.Map;

import com.exercise.constant.SystemConstant;

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
	public static String convertT(String code) {
		Map<String, String> buildingType = new HashMap<String, String>();
		buildingType.put(SystemConstant.NGUYEN_CAN, "nguyên căn");
		buildingType.put(SystemConstant.NOI_THAT, "nội thất");
		buildingType.put(SystemConstant.TANG_TRET, "tầng trệt");
		
		
		
		return buildingType.containsKey(code) ? buildingType.get(code) : "" ;
	}
}
