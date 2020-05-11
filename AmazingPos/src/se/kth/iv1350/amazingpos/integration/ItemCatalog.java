package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Item;
import se.kth.iv1350.amazingpos.util.*;
import java.util.HashMap;

/**
 * This is a dummy item catalog
 */
public class ItemCatalog {
    private HashMap<String, ItemDTO > itemList = new HashMap<>();

    /**
     *  Creates a instance of a dummy item database.
     */
    ItemCatalog(){
        itemsInCatalog();
    }

    /**
     *  Checks if the searched itemIdentifier exists in the database.
     *
     * @param itemIdentifier The looked item.
     * @return If item exists <code>true</code> else <code>false</code>
     */
    public boolean validItem(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * Gets the item description of the specified itemIdentifier.
     * Returns an item with the specified quantity.
     *
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount of items.
     * @return An item with it's itemDescription and quantity or null if the identifier didn't exist..
     * @throws AddItemException If the itemIdentifier doesn't exist
     * @throws ItemCatalogException If the database call failed.
     */
    public Item getItem(String itemIdentifier, Amount quantity) throws AddItemException, ItemCatalogException {
        if (!validItem(itemIdentifier)){
            throw new AddItemException(itemIdentifier);
        }
        Item newItem = new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        if (newItem.getItemIdentifier() != itemIdentifier){
            throw new ItemCatalogException("ItemId does not match");
        }
        if(newItem.getItemIdentifier() == "5"){
            throw new ItemCatalogException("No connection to server.");
        }
        return newItem;
    }

    private void itemsInCatalog(){
        itemList.put("1", new ItemDTO(new Amount(40), new Amount(15), "Paprika"));
        itemList.put("2", new ItemDTO(new Amount(30), new Amount(10), "Apelsin" ));
        itemList.put("3", new ItemDTO(new Amount(10), new Amount(5), "Gurka"));
        itemList.put("4", new ItemDTO(new Amount(35), new Amount(20), "Mandarin"));
        itemList.put("5", new ItemDTO(new Amount(100000), new Amount(200000), "Bike"));
    }
}
