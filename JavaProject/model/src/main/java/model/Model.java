package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import NovaAnn.NovaAnn;
import contract.IModel;

public class Model extends Observable implements IModel {



	/**
	 * Instantiates a new model.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public Model(int lvl) throws IOException, SQLException {
		new NovaAnn(lvl);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadMessage(String key) {
		// TODO Auto-generated method stub
		
	}
}
