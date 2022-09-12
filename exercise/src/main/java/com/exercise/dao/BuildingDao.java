package com.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exercise.constant.SystemConstant;
import com.exercise.dao.initial.BuildingInitial;
import com.exercise.dao.interfaces.IBuildingDao;
import com.exercise.dto.request.BuildingReq;
import com.exercise.utils.ConnectionUtil;
import com.exercise.utils.StringUtil;

public class BuildingDao implements IBuildingDao {
	@Override
	public List<BuildingInitial> getBuildings(BuildingReq buildingRes) {
		// TODO Auto-generated method stub
		List<BuildingInitial> buildings = new ArrayList<BuildingInitial>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder(
					"SELECT * from building " + SystemConstant.WHERE_ONE_EQUAL_ONE + "");

			if (!StringUtil.isNullOrEmpty(buildingRes.getName())) {
				query.append(" and name like '%" + buildingRes.getName() + "%'");
			}
			if (!StringUtil.isNullOrEmpty(buildingRes.getStreet())) {
				query.append(" and street like '%" + buildingRes.getStreet() + "%'");
			}
			if (!StringUtil.isNullOrEmpty(buildingRes.getDistrict())) {
				query.append(" and district like '%" + buildingRes.getDistrict() + "%'");
			}
			if (!StringUtil.isNullOrEmpty(buildingRes.getWard())) {
				query.append(" and ward like '%" + buildingRes.getWard() + "%'");
			}
			if (buildingRes.getFlorrArea() != null) {
				query.append(" and floorarea = " + buildingRes.getFlorrArea());
			}
			if (!StringUtil.isNullOrEmpty(buildingRes.getType())) {
				query.append(" and type like '%" + buildingRes.getType() + "%'");
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			while (rs.next()) {
				BuildingInitial building = new BuildingInitial();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setDistrict(rs.getString("district"));
				building.setWard(rs.getString("ward"));
				building.setFloorArea(rs.getInt("floorarea"));
				building.setType(rs.getString("type"));

				buildings.add(building);
			}
			return buildings;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
		return new ArrayList<BuildingInitial>();
	}
}
