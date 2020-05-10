package se.kth.iv1350.amazingpos.view;


import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.OperationFailedException;
import se.kth.iv1350.amazingpos.integration.AddItemException;
import se.kth.iv1350.amazingpos.integration.ItemCatalogException;
import se.kth.iv1350.amazingpos.util.Amount;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.LogHandler;

import java.io.IOException;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all system operations
 * in the controller.
 */
public class View {
	private Controller ctrl;
	private ErrorMessageHandler errorMessageHandler = ErrorMessageHandler.getErrorMessageHandler();
	private LogHandler logHandler = new LogHandler();
	/**
	 * Creates a new instance, that uses the specified controller for calls to other layers.
	 * 
	 * @param ctrl The controller to use for all calls to other layers.
	 */
	public View(Controller ctrl) throws IOException {
		this.ctrl = ctrl;
		ctrl.addObserver(new TotalRevenueView());
	}
	/**
	 * Performs a fake sale, by calling all system operations in the controller.
	 */
	public void runFakeExecution() {
		ctrl.startSale();
		System.out.println("A new sale has been started.");
	}
	/**
	 *  Makes a sample execution of the application.
	 *  AKA, simulating someone making inputs to the application.
	 */
	public void sampleExecution() throws AddItemException, ItemCatalogException, OperationFailedException {
		System.out.println("Cashier starts new sale.\n");
		ctrl.startSale();
		Sale out;
		Sale right = null;
		System.out.println("Cashier enter items. \n");
		out = registerItem("4", new Amount(1));
		if(false == checkNull(out))
			right = out;
		out = registerItem("", new Amount(1));
		if(false == checkNull(out))
			right = out;
		out = registerItem("3", new Amount(1));
		if(false == checkNull(out))
			right = out;
		out = registerItem("5", new Amount(1));
		if(false == checkNull(out))
			right = out;
		try{
		System.out.println("Cashier displays the total with taxes. \n");
			System.out.println(right.getTotal().getTotalPriceWithVAT().toString() + "kr \n");
		}catch (IllegalStateException exc){
			handleException("Have to start new sale first.", exc);
		}

		try {
		System.out.println("Cashier enters the paid amount. \n");
		Amount amount = new Amount(300);
		System.out.println(amount.getAmount() + "kr");
		ctrl.paid(amount);
		}catch (IllegalStateException exc){
			handleException("Have to start new sale first.", exc);
		}
	}
	private boolean checkNull(Sale out){
		if(out == null)
			return true;
		return false;
	}

	/**
	 *
	 * @param itemIdentifier
	 * @param amount
	 * @return
	 */
	private Sale registerItem(String itemIdentifier, Amount amount) throws OperationFailedException {
		Sale out = null;
		try {
			out = ctrl.registerItem(itemIdentifier, amount);
			System.out.println(out.toString());
		}catch (OperationFailedException exc) {
			handleException("The system failed to register item, please try again.", exc);
		}catch (IllegalStateException exc){
			handleException("Have to start new sale.", exc);
		} catch (AddItemException exc) {
			handleException("Item identifier " + itemIdentifier +  " doesn't exist, please try again.", exc);
		} catch (ItemCatalogException exc) {
			handleException("Could not retrieve the item.", exc);
		}
		return out;
	}

	private void handleException(String message, Exception exception){
		errorMessageHandler.showErrorMsg(message);
		logHandler.logException(exception);
	}
}
