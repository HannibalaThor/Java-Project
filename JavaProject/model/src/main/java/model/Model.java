package model;

import java.util.Observable;

import contract.IModel;


public class Model extends Observable implements IModel{

	/** The message. */
	private String message;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public void loadMessage(String key) {
		// TODO Auto-generated method stub
		
	}
}
