package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.*;
public class ItemDTO {
	private String itemName;
	private Amount VAT;
	private Amount price;
	
	/**
	 * Creates a new instance that will represent item.
	 * 
	 * @param price the price of the item
	 * @param VAT the VAT amount for the item
	 * @param itemName The Name of the item
	 */
	public ItemDTO(Amount price, Amount VAT,  String itemName) {
		this.itemName = itemName;
		this.price = price;
		this.VAT = VAT;
	}
	/**
	 * will return the price of the item
	 * 
	 * @return the price of the item.
	 */
	public Amount getPrice()
	{
		return price;
	}
	/**
	 * Will return the value VAT of the item
	 * 
	 * @return the value VAT of the item
	 */
	public Amount getVAT() {

		return VAT;
	}
	/**
	 * Will return a String with info about the item
	 * 
	 * @return String with info about the item. 
	 */
	public String getItemName() {

		return itemName;
	}
	/**
	 * Turns the instance into a <code>String</code>.
	 *
	 * @return The instance as a <code>String</code>.
	 */
	@Override
	public String toString() {
		String builder = "Item name: " + itemName + "\t" +
				"| Price: " + price + "\t" +
				"| Tax amount: " + VAT + " | ";
		return builder;
	}
}
