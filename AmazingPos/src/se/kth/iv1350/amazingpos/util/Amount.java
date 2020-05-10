package se.kth.iv1350.amazingpos.util;
import java.util.Objects;
/**
 * Represent the amount of money and items
 */
public class Amount {
	private final int amount;
	
	/**
	 * Creates an instance that will represent the Specific amount.
	 * 
	 * @param amount represent the newly created instance amount.
	 */
	public Amount(int amount) {
		this.amount = amount;
	}
	/**
	 * Will return the amount.
	 * 
	 * @return will return the amount
	 */
	public int getAmount(){

		return amount;
	}
	/**
	 *  Transform the <code>Amount</code> into a <code>String</code> object.
	 *  
	 *  @return <code>Amount</code> as a <code>String</code>.
	 */
	public String toString() {
		return Integer.toString(amount);
	}
	/**
	 * Will increase the quantity of item with the specified <code>Amount</code>.
	 * 
	 * @param other The specified <code>Amount</code>
	 * @return The sum of this <code>Amount</code> with other <code>Amount</code>
	 */
	public Amount add(Amount other) {

		return new Amount(this.amount + other.amount);
	}
	/**
	 * Will subtract with the specified <code>Amount</code>
	 *
	 * @param other The specified <code>Amount</code>
	 * @return The difference of this <code>Amount</code>
	 * with the other <code>Amount</code>
	 */
	public Amount decrease(Amount other){

		return new Amount(this.amount - other.amount);
	}

	/**
	 * Add amounts
	 * @param other  The specified other <code>Amount</code>
	 * @return       The sum
	 */
	public Amount plus(Amount other){
		return new Amount(this.amount + other.amount);
	}
	/**
	 * Will multiply price or VAT with the specified <code>Amount</code>
	 *
	 * @param other The specified <code>Amount</code>
	 * @return The product of this price or VAT with the other <code>Amount</code>
	 */
	public Amount multiply(Amount other){
		return new Amount(this.amount * other.amount);}

}
