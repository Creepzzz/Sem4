package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.OperationFailedException;
import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.view.*;

import java.io.IOException;

/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main {
	/**
	 * The main method used to start the entire application.
	 * 
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) throws AddItemException, ItemCatalogException, OperationFailedException, IOException {
		SystemCreator systemCreator = new SystemCreator();
		CatalogCreator catalogCreator = new CatalogCreator();
		Printer printer = new Printer();
		Controller controller = new Controller(systemCreator, catalogCreator, printer);
		View view = new View(controller);
		view.sampleExecution();
	}

}
