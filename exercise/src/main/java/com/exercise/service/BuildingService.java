package com.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exercise.dao.BuildingDao;
import com.exercise.dao.initial.BuildingInitial;
import com.exercise.dto.request.BuildingReq;
import com.exercise.dto.response.BuildingRes;
import com.exercise.service.interfaces.IBuildingService;
import com.exercise.utils.BuildingUtil;
import com.exercise.utils.StringUtil;

public class BuildingService implements IBuildingService {
	private BuildingDao buildingDao = new BuildingDao();

	@Override
	public List<BuildingRes> getBuilding(Map<String, String> data) {
		// TODO Auto-generated method stub
		List<BuildingInitial> buildings = buildingDao.getBuildings(data);
		List<BuildingRes> result = new ArrayList<BuildingRes>();
		
		for (BuildingInitial buildingInitial : buildings) {
			
			BuildingRes buildingRes = new BuildingRes();

			if (buildingInitial.getType() != null && buildingInitial.getType() != "") {
				
				String type = buildingInitial.getType();
				
				String[] lstType = type.split(",");
				
				String typeString = "";
				
				for (String s : lstType) {
					typeString =  typeString + BuildingUtil.convertT(s) + ",";
				}
				buildingRes.setType(typeString);
			} else {
				buildingRes.setType("");
			}
			buildingRes.setId(buildingInitial.getId());
			buildingRes.setName(buildingInitial.getName());
			buildingRes.setAddress(buildingInitial.getStreet() + ", " + buildingInitial.getDistrict() + ", " + buildingInitial.getWard() + ", ");
			result.add(buildingRes);
		}
		
		return result;
	}
}
