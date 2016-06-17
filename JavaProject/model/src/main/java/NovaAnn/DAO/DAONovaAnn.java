package NovaAnn.DAO;

import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import NovaAnn.NovaAnnWorld;



public class DAONovaAnn extends DAOEntity<NovaAnnWorld> {

	private Point position;

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAONovaAnn (final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final NovaAnn.NovaAnnWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final NovaAnn.NovaAnnWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public  char findMotionLess(final int x, final int y,final int lvl) {

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
	
	@Override
	public Point findMobile(final int lvl, final String mobile) {

		position.setLocation(0, 0);
		try {
			final String sql = "{call WhereIsMobileSpawning(?,?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, lvl);
			call.setString(2, mobile);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				position.setLocation(resultSet.getInt("x"), resultSet.getInt("y"));
				return position;
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}