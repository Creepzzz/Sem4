package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.util.*;

/**
 * Represents an Item.
 */
public class Item {
    private ItemDTO itemDescription;
    private String itemIdentifier;
    private Amount quantity;

    /**
     * Creates a new instance, represented as an item.
     *
     * @param itemDescription The description of an item.
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount if items.
     */
    public Item(ItemDTO itemDescription, String itemIdentifier, Amount quantity) {
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
    }

    /**
     * Will increase the quantity of items with the specified {@link Amount}
     *
     * @param otherQuantity The {@link Amount} that will be added to the quantity.
     */
    public void increaseQuantity(Amount otherQuantity){

        this.quantity = this.quantity.add(otherQuantity);
    }
    /**
     * Will decrease the quantity of items with the specified {@link Amount}
     *
     * @param otherQuantity The {@link Amount} that will be subtracted to the quantity.
     */
    public void decreaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.decrease(otherQuantity);
    }

    /**
     * Get the value of quantity.
     *
     * @return The value of quantity.
     */
    public Amount getQuantity() {

        return quantity;
    }

    /**
     * Get the value of itemDescription.
     *
     * @return The value of itemDescription
     */
    public ItemDTO getItemDescription() {

        return itemDescription;
    }

    /**
     * Get the value of itemIdentifier.
     *
     * @return The value of itemIdentifier.
     */
    public String getItemIdentifier() {

        return itemIdentifier;
    }

    /**
     * Turns instance into a <code>String</code>
     *
     * @return The instance as a <code>String</code>
     */
    @Override
    public String toString() {
        return ("item identifier: " + itemIdentifier) +
                "quantity: " + quantity +
                "item description: " + itemDescription.toString();
    }
}
