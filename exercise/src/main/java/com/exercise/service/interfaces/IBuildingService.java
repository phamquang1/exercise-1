package com.exercise.service.interfaces;

import java.util.List;

import com.exercise.dto.request.BuildingReq;
import com.exercise.dto.response.BuildingRes;

public interface IBuildingService {
	List<BuildingRes> getBuilding(BuildingReq buildingReq);
}
