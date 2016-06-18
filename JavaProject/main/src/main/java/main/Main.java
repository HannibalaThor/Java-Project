package main;

import java.io.IOException;
import java.sql.SQLException;

import contract.IModel;
import model.Model;



public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(final String[] args) throws IOException, SQLException {
		int lvl = 5;
		final IModel model = new Model(lvl);
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		controller.control();
	}
}