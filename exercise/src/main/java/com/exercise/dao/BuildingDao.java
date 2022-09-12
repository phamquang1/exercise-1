package com.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exercise.constant.SystemConstant;
import com.exercise.dao.initial.BuildingInitial;
import com.exercise.dao.interfaces.IBuildingDao;
import com.exercise.dto.request.BuildingReq;
import com.exercise.utils.ConnectionUtil;
import com.exercise.utils.StringUtil;

public class BuildingDao implements IBuildingDao {
	@Override
	public List<BuildingInitial> getBuildings(Map<String, String> data) {
		// TODO Auto-generated method stub
		List<BuildingInitial> buildings = new ArrayList<BuildingInitial>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder(
					"SELECT * from building " + SystemConstant.WHERE_ONE_EQUAL_ONE + "");

			if (!StringUtil.isNullOrEmpty(data.get("name"))) {
				query.append(" and name like '%" + data.get("name") + "%'");
			}
			if (!StringUtil.isNullOrEmpty(data.get("street"))) {
				query.append(" and street like '%" + data.get("street") + "%'");
			}
			if (!StringUtil.isNullOrEmpty(data.get("district"))) {
				query.append(" and district like '%" + data.get("district") + "%'");
			}
			if (!StringUtil.isNullOrEmpty(data.get("ward"))) {
				query.append(" and ward like '%" + data.get("ward") + "%'");
			}
			if (!StringUtil.isNullOrEmpty(data.get("floorarea"))) {
				query.append(" and floorarea = " + Integer.parseInt(data.get("floorarea")));
			}
			if (!StringUtil.isNullOrEmpty(data.get("type"))) {
				query.append(" and type like '%" + data.get("type") + "%'");
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
