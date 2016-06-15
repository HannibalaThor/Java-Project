package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


class DAONovaAnn extends DAOEntity<NovaAnnWorld> {

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAONovaAnn(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final NovaAnnWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final NovaAnnWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public <NovaAnnWorld> NovaAnnWorld findMotionLess(final int x, final int y,final int lvl) {
		NovaAnnWorld novaAnnWorld = new NovaAnnWorld();

		try {
			final String sql = "{call WhatIsHere(?,?,?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, x);
			call.setInt(2, y);
			call.setInt(3, lvl);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				novaAnnWorld = new NovaAnnWorld(resultSet.getInt("MotionLessSymbol"), x, y);
			}
			return novaAnnWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	@Override
	public NovaAnnWorld findMobile(final int lvl) {
		NovaAnnWorld novaAnnWorld = new NovaAnnWorld();

		try {
			final String sql = "{call WhatIsHere(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, lvl);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				novaAnnWorld = new NovaAnnWorld(resultSet.getInt("MotionLessSymbol"), resultSet.getInt("x"), resultSet.getInt("y"));
			}
			return novaAnnWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}