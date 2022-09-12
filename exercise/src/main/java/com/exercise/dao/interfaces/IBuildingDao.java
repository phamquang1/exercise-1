package com.exercise.dao.interfaces;

import java.util.List;

import com.exercise.dao.initial.BuildingInitial;
import com.exercise.dto.request.BuildingReq;

public interface IBuildingDao {
	List<BuildingInitial> getBuildings(BuildingReq buildingRes);
}
