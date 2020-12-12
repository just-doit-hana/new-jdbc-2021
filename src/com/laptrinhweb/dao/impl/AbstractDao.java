package com.laptrinhweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.dao.GenericDao;
import com.laptrinhweb.mapper.Rowmapper;

public class AbstractDao<T> implements GenericDao<T> {

	public Connection myConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspservletjdbc", "root", "Quynh@822000");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;

	}

	@Override
	public <T> ArrayList<T> query(String sql, Rowmapper<T> rowmapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			connection = myConnection();
			statement = connection.prepareStatement(sql);
			// set parameter
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowmapper.mapRow(resultSet));
			}
			return (ArrayList<T>) results;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				return null;
			}
		}

	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		// TODO Auto-generated method stub

		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameterss = parameters[i];
				int index = i + 1;
				if (parameterss instanceof Long) {
					statement.setLong(index, (Long) parameterss);
				}
				//neu co cac kieu khac  thi lieu ke  het nos  ra 
				// bat buoc phai ep kieu nos 
				else if (parameterss instanceof String ) {
					 statement.setString(index, (String) parameterss);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}