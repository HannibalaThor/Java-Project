package model.javaproject.novaann.DAO;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;





public class DAONovaAnn {
	private final Connection connection;


	private int x;
	private int y;

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAONovaAnn (final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	/* (non-Javadoc)
	 * @see model.javaproject.novaann.DAO.IDAONovaAnn#findMotionLess(int, int, int)
	 */
	public  char findMotionLess(final int x,final int y,final int lvl) {

		try {
			final String sql = "{call WhatIsHere(?,?,?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, x);
			call.setInt(2, y);
			call.setInt(3, lvl);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				return resultSet.getString("MotionLessSymbol").charAt(0);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return ' ';
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.DAO.IDAONovaAnn#findMobile(int, int)
	 */
	public void findMobile(final int lvl, final int mobile) {
		try {
			final String sql = "{call WhereIsMobileSpawning(?,?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, lvl);
			call.setInt(2, mobile);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first() != false) {
				this.x = resultSet.getInt("x");
				this.y = resultSet.getInt("y");
			}
			else{
				this.x = -1;
				this.y = -1;
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.DAO.IDAONovaAnn#getX()
	 */
	public int getX() {
		return this.x;
	}


	/* (non-Javadoc)
	 * @see model.javaproject.novaann.DAO.IDAONovaAnn#getY()
	 */
	public int getY() {
		return this.y;
	}


	protected Connection getConnection() {
		return this.connection;
	}



}