package com.exercise.controller;

import java.util.List;
import java.util.Map;

import com.exercise.dao.BuildingDao;
import com.exercise.dao.initial.BuildingInitial;
import com.exercise.dto.request.BuildingReq;
import com.exercise.dto.response.BuildingRes;
import com.exercise.service.BuildingService;

public class BuildingController {
	private BuildingService buildingService = new BuildingService();
//	public List<BuildingRes> getBuildings(BuildingReq buildingReq) {
//		List<BuildingRes> r = buildingService.getBuilding(buildingReq);
//		return r;
//	}
	
	public List<BuildingRes> getBuildings(Map<String, Object> data) {
		List<BuildingRes> r = buildingService.getBuilding(data);
		return r;
	}
}
