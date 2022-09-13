package com.exercise.utils;

import java.util.HashMap;
import java.util.Map;

import com.exercise.constant.SystemConstant;

public class BuildingUtil {

	public static Map<String, String> defaultType() {
		Map<String, String> buildingType = new HashMap<String, String>();
		buildingType.put(SystemConstant.NGUYEN_CAN, SystemConstant.NGUYEN_CAN_NAME);
		buildingType.put(SystemConstant.NOI_THAT, SystemConstant.NOI_THAT_NAME);
		buildingType.put(SystemConstant.TANG_TRET, SystemConstant.TANG_TRET_NAME);
		return buildingType;
	}

}
