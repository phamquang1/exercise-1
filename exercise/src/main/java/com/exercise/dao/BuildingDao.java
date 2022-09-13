package com.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
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
	public List<BuildingInitial> getBuildings(Map<String, Object> data) {
		// TODO Auto-generated method stub
		String name = (String) data.get("name");
		String street = (String) data.get("street");
		String district = (String) data.get("district");
		String ward = (String) data.get("ward");
		Integer floorArea = (Integer) data.get("floorarea");
		String type = (String) data.get("type");
		List<BuildingInitial> buildings = new ArrayList<BuildingInitial>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder("SELECT * from building " + SystemConstant.WHERE_ONE_EQUAL_ONE + "" );
			if (!StringUtil.isNullOrEmpty(name)) {
				query.append(" and name like '%" + name + "%'");
			}
			if (!StringUtil.isNullOrEmpty(street)) {
				query.append(" and street like '%" + street + "%'");
			}
			if (!StringUtil.isNullOrEmpty(district)) {
				query.append(" and district like '%" + district + "%'");
			}
			if (!StringUtil.isNullOrEmpty(ward)) {
				query.append(" and ward like '%" + ward + "%'");
			}
			if ((floorArea != null)) {
				query.append(" and floorarea = " + floorArea);
			}
			if (!StringUtil.isNullOrEmpty(type)) {
				query.append(" and type like '%" + type + "%'");
			}
			
			System.out.println(query.toString());
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
			System.out.println(e);
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
