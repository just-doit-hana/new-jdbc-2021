package com.laptrinhweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhweb.dao.GenericDao;
import com.laptrinhweb.mapper.Rowmapper;

public class AbstractDao<T> implements GenericDao<T> {

	private ResultSet rs;

	public Connection myConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspservletjdbc", "root", "Quynh@822000");
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return con;

	}

//	ResourceBundle resourceBundle = ResourceBundle.getBundle("dba");
//	
//	public Connection myConnection() {
//		try {
//			Class.forName(resourceBundle.getString("driverName"));
//			String url = resourceBundle.getString("url");
//			String user = resourceBundle.getString("user");
//			String password = resourceBundle.getString("password");
//			return DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			return null;
//		}
//	}
//		

	@Override
	public <T> ArrayList<T> query(String sql, Rowmapper<T> rowmapper, Object... parameters) throws ClassNotFoundException {
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
				else if (parameterss instanceof Integer) {
					statement.setInt(index, (Integer)parameterss);
				}
				else if (parameterss instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp)parameterss);
				}
				else if (parameterss ==null) {
					
					statement.setNull(index, java.sql.Types.NULL);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sqlString, Object... parameters) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = myConnection();
			connection.setAutoCommit(false);
			statement= connection.prepareStatement(sqlString);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public Long insert(String sqlString, Object... parameters) throws ClassNotFoundException {
		
		// TODO Auto-generated method stub
				Connection connection = null;
				PreparedStatement statement = null;
			    ResultSet rs = null ;
				Long idLong =null;
				try {
					connection = myConnection();
					connection.setAutoCommit(false);
					statement= connection.prepareStatement(sqlString,statement.RETURN_GENERATED_KEYS);
					setParameter(statement, parameters);
					statement.executeUpdate();
					rs=statement.getGeneratedKeys();
					if (rs.next()) {
				      idLong= rs.getLong(1);
					}
					connection.commit();
					return idLong;
				} catch (SQLException e) {
					// TODO: handle exception
					if (connection != null) {
						try {
							connection.rollback();
						} catch (SQLException e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				}finally {
					try {
						if (statement != null) {
							statement.close();
						}
						if (connection != null) {
							connection.close();
						}
						if (rs != null) {
							rs.close();
						}
					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				return null;
	}

	@Override
	public void delete(String sqlString, Object... parameters) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = myConnection();
			connection.setAutoCommit(false);
			statement= connection.prepareStatement(sqlString);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	}
	}

	@Override
	public int count(String sqlString, Object... parameters) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
	    ResultSet rs = null ;
		int   count =0;
		try {
			connection = myConnection();
//			connection.setAutoCommit(false);
			statement= connection.prepareStatement(sqlString,statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			rs=statement.getGeneratedKeys();
	      while (rs.next()) {
		// khong de 1 thi co the de count 
//		  count = rs.getInt("count(*)");
		     count = rs.getInt(1);
			}
//			connection.commit();
			return count;
		} catch (SQLException e) {
			// TODO: handle exception
			if (connection != null) {
				try {
//					connection.rollback();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return 0;
	}

	
}
	

