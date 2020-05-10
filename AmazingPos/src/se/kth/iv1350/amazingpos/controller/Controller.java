package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.*;
import se.kth.iv1350.amazingpos.model.Item;
import se.kth.iv1350.amazingpos.util.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This is the application's only controller. All calls to the model pass through this class.
 *
 */

public class Controller {
	private Sale sale;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private ItemCatalog itemCatalog;
	private Printer printer;
	private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();
	/**
	 * Starts a new sale. This method must be called first before the process of a sale.
	 */
	public void startSale() {

		this.sale = new Sale();
	}
  /**
   * Creator of controller
   *
   * @param systemCreator     Getter of classes of external system calls
   * @param catalogCreator    Getter of classes of external catalog calls
   * @param printer           Interface to the printer
   */
	public Controller(SystemCreator systemCreator, CatalogCreator catalogCreator, Printer printer){
		this.accountingSystem = systemCreator.getAccountingSystem();
		this.inventorySystem = systemCreator.getInventorySystem();
		this.itemCatalog = catalogCreator.getItemCatalog();
		this.printer = printer;
	}

	/**
	 * The validity of the item is checked
	 * Gets item from the catalog and adds it to the sale
	 * Updates the catalog
	 *
	 * @param itemIdentifier    Specify the item
	 * @param quantity          Specify the number of items
	 */
	public Sale registerItem(String itemIdentifier, Amount quantity) throws AddItemException, ItemCatalogException, OperationFailedException {
		checkIfNewSaleStarted("registerItem");
		try {
			Item item = itemCatalog.getItem(itemIdentifier, quantity);
			sale.updateSale(item);
			return sale;
		}catch (ItemCatalogException exc){
			throw new OperationFailedException("Could not retrieve the item.", exc);
		}
	}

	/**
	 * Creates a payment, adds the amount paid and nullifies the sale
	 * @param paidAmount Specifies the amount customer has paid
	 */
	public void paid(Amount paidAmount){
		Payment payment = new Payment(paidAmount, sale.getTotal());
		payment.addObservers(totalRevenueObservers);
		accountingSystem.updateAccount(sale);
		inventorySystem.updateInventory(sale);
		Receipt receipt = new Receipt(sale, payment);
		printer.printReciept(receipt);
		sale = null;
	}

	/**
	 * Adds observer that notifies when payment occurs
	 * @param totalRevenueObserver    The observer
	 */
	public void addObserver(TotalRevenueObserver totalRevenueObserver){
		totalRevenueObservers.add(totalRevenueObserver);
	}

	private void checkIfNewSaleStarted(String method) {
		if (sale == null) {
			throw new IllegalStateException("Call to " + method + " was made before initiating a new sale.");
		}
	}
}
