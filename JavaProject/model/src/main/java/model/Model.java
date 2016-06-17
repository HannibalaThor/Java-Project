package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import NovaAnn.NovaAnn;

public class Model extends Observable {



	/**
	 * Instantiates a new model.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public Model() throws IOException, SQLException {
		new NovaAnn();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
