package se.kth.iv1350.amazingpos.integration;

public class AddItemException extends Exception{
    String itemIdentifier;

    /**
     * Creates a new instance specifying which item identifier that didn't exist.
     *
     * @param itemIdentifier The item identifier that wasn't found.
     */
    public AddItemException(String itemIdentifier){
        super("Given item identifier: " + itemIdentifier + ", was not found.");
        this.itemIdentifier = itemIdentifier;
    }
    /**
     * Gets the item identifier that doesn't exist.
     *
     * @return The item identifier that doesn't exists.
     */
    public String getInvalidItemIdentifier(){
        return itemIdentifier;
    }
}
