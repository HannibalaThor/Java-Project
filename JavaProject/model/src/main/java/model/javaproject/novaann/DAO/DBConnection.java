package model.javaproject.novaann.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE	= null;

	/** The connection. */
	private Connection					connection;

	/**
	 * Instantiates a new DB connection.
	 */
	public DBConnection() {
		this.open();
	}

	public static DBConnection getInstance(){
		return INSTANCE;

	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
