package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.util.Amount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
	private LocalTime SaleTime;
	private Receipt receipt;
	private Total total;
	private HashMap<String, Item> items = new HashMap<>();
	private LocalTime saleTime;
	private Date saleEnded;
	private Date time;
	private String startTime;
	/**
	 *
	 * Creates a new instance and saves the time of this sale.
	 */
	public Sale(){

		this.total = new Total();
		time = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startTime = dateFormat.format(time);

	}

	/**
	 * Getter of start time
	 * @return
	 */
	public String startTime(){
		return startTime;
	}

	/**
	 * Getter of end time
	 * @return
	 */
	public String endTime(){

		saleEnded = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endTime = dateFormat.format(time);

		return endTime;
	}
	/**
	 * Gets the value of total.
	 *
	 * @return The value of total.
	 */
	public Total getTotal() {

		return total;
	}

	/**
	 * Gets the HashMap items.
	 *
	 * @return The HashMap items.
	 */
	public HashMap<String, Item> getItems(){

		return items;
	}

	/**
	 * Updates the current sale. Updates how many items and the running total.
	 * Can't take null items.
	 *
	 * @param item The item that will be added to the sale.
	 * @return  The itemDescription as a string.
	 */
	public String updateSale(Item item){
		if (itemListContains(item)) {
			updateItemQuantityAndTotal(item);
			Item oldItem = items.get(item.getItemIdentifier());
			return oldItem.getItemDescription().toString() + " Quantity: " +oldItem.getQuantity().getAmount();
		} else {
			addValidItem(item);
			return item.getItemDescription().toString() + " Quantity: " +item.getQuantity().getAmount();
		}
	}

	private boolean itemListContains(Item item){

		return items.containsKey(item.getItemIdentifier());
	}

	private void updateItemQuantityAndTotal(Item item){
		Item oldItem = items.get(item.getItemIdentifier());
		oldItem.increaseQuantity(new Amount(1));
		items.put(oldItem.getItemIdentifier(), oldItem);
		total.updateTotal(item);
	}

	private void addValidItem(Item item){
		items.put(item.getItemIdentifier(), item);
		total.updateTotal(item);
	}

	/**
	 * Makes the instance into to a <code>String</code>
	 *
	 * @return The instance as a <code>String</code>
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Iterator entriesIterator = getEntries();

		while(entriesIterator.hasNext()) {
			Item item = getCurrentItem(entriesIterator);
			builder.append(item.getItemDescription().toString());
			addNewLine(builder, " Quantity: " + item.getQuantity().toString());
		}

		addNewLine(builder, "Total: " + total.getTotalPrice().toString());
		addNewLine(builder, "VAT: " + total.getTotalVAT().toString());
		return builder.toString();
	}

	private Iterator getEntries(){
		Set entries = items.entrySet();
		return entries.iterator();
	}

	private Item getCurrentItem(Iterator entriesIterator){
		Map.Entry mapping = (Map.Entry) entriesIterator.next();
		return (Item) mapping.getValue();
	}

	private void addNewLine(StringBuilder builder, String line){
		builder.append(line);
		builder.append("\n");
	}
}
