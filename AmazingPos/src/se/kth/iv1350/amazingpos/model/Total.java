package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.util.*;


/**
 * Represent the total with VAT included.
 */

public class Total {
	private Amount totalPrice;
	private Amount totalVAT;

	/**
	 * Creating an instance that represent the total.
	 */
	public Total() {
		this.totalPrice = new Amount(0);
		this.totalVAT = new Amount(0);
	}

	/**
	 * Will get you the total
	 *
	 * @return will return the value of total
	 */

	public Amount getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Will get you the totalVAT
	 *
	 * @return the totalVAT
	 */

	public Amount getTotalVAT() {
		return totalVAT;
	}

	/**
	 * Will return the total price with the VAT included
	 *
	 * @return the total price with the VAT included
	 */

	public Amount getTotalPriceWithVAT() {

		return totalPrice.add(totalVAT);
	}

	/**
	 * Updates the total price and the total VAT. By adding the items price to the total price, and the items VAT to the total VAT.
	 *
	 * @param item The item that will be added to the total, have information about how many items there are and the price and tax.
	 */
	public void updateTotal(Item item) {
		if (item == null) {
			return;
		}

		Amount amountOfItems = item.getQuantity();
		Amount itemPrice = item.getItemDescription().getPrice();
		Amount itemVAT = item.getItemDescription().getVAT();
		this.totalVAT = this.totalVAT.add(amountOfItems.multiply(itemVAT));
		this.totalPrice = this.totalPrice.add(amountOfItems.multiply(itemPrice));

	}


	/**
	 * Updates the total revenue with total and totalVAT
	 * @param totalPrice  The total to be added
	 */
	public void updateTotalRevenue(Total totalPrice){
		this.totalPrice = this.totalPrice.plus(totalPrice.getTotalPrice());
		this.totalVAT = this.totalVAT.plus(totalPrice.getTotalVAT());
	}
}
