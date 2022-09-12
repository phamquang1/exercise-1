package com.exercise.controller;

import java.util.List;

import com.exercise.dao.BuildingDao;
import com.exercise.dao.initial.BuildingInitial;
import com.exercise.dto.request.BuildingReq;
import com.exercise.dto.response.BuildingRes;
import com.exercise.service.BuildingService;

public class BuildingController {
	private BuildingService buildingService = new BuildingService();
	public List<BuildingRes> getBuildings(BuildingReq buildingReq) {
		List<BuildingRes> r = buildingService.getBuilding(buildingReq);
		return r;
	}
}
