package com.exercise.view;

import java.util.List;

import com.exercise.controller.BuildingController;
import com.exercise.dto.request.BuildingReq;
import com.exercise.dto.response.BuildingRes;

public class BuildingListView {
	public static void main(String[] args) {
		String name = " ";
		String street = " ";
		String district = " ";
		String ward = " ";
		Integer floorArea = 500;
		String type = "	";
		BuildingReq buildingReq = new BuildingReq(name, street, district, ward, floorArea, type);
		
		BuildingController buildingController = new BuildingController();
		
		List<BuildingRes> buildings = buildingController.getBuildings(buildingReq);
		int i = 1;
		for (BuildingRes buildingRes : buildings) {
			System.out.println("thông tin building " + i + " :");
			System.out.println("Name : " + buildingRes.getId() + "-" + buildingRes.getName());
			System.out.println("Địa chỉ : " + buildingRes.getAddress());
			System.out.println(buildingRes.getType() != "" ? "Loại : " +  buildingRes.getType() : "Loại: Không có");
			System.out.println("-------------------------------------------------");
			i++;
		}

	}
}
