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
	public List<BuildingRes> getBuilding(Map<String, Object> data) {
		// TODO Auto-generated method stub
		List<BuildingInitial> buildings = buildingDao.getBuildings(data);
		List<BuildingRes> result = new ArrayList<BuildingRes>();
		for (BuildingInitial buildingInitial : buildings) {

			BuildingRes buildingRes = new BuildingRes();
			Long id = buildingInitial.getId();
			String name = buildingInitial.getName();
			String street = buildingInitial.getStreet();
			String district = buildingInitial.getDistrict();
			String ward = buildingInitial.getWard();
			String type = buildingInitial.getType();

			if (type != null && type != "") {

				String typeString = this.convertTypeBuilding(type);
				buildingRes.setType(typeString.toString());
			} else {
				buildingRes.setType("");
			}
			buildingRes.setId(id);
			buildingRes.setName(name);
			buildingRes.setAddress(street + ", " + district + ", " + ward + ", ");
			result.add(buildingRes);
		}

		return result;
	}
	private String convertTypeBuilding(String type) {
		Map<String, String> defaultType = BuildingUtil.defaultType();
		StringBuilder typeString = new StringBuilder();
		String[] lstType = type.split(",");
		for (String string : lstType) {
			typeString.append(defaultType.getOrDefault(string, ""));
		}
		return typeString.toString();
	}
}
