package com.exercise.service.interfaces;

import java.util.List;
import java.util.Map;

import com.exercise.dto.request.BuildingReq;
import com.exercise.dto.response.BuildingRes;

public interface IBuildingService {
	List<BuildingRes> getBuilding(Map<String, String> data);
}
