package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.Item;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.Amount;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class InventorySystem {
    private HashMap<String, Item> inventory = new HashMap<>();

    /**
     * Dummy instance of inventory
     */
    public InventorySystem(){
        addItems();
    }

    /**
     * Updated the inventory for each item
     * @param sale      Sale contains all the items
     */
    public void updateInventory(Sale sale){
        HashMap<String, Item> items = sale.getItems();
        Set entries = items.entrySet();

        for(Object entry : entries){
            Item item = getCurrentItem(entry);
            if(itemExistsInInventory(item)){
                decreaseQuantityOfItem(item);
            }
        }
    }

    /**
     * Checks if item exists in inventory
     * @param item      The item in question
     * @return          True if item exists, false if it doesn't
     */
    private boolean itemExistsInInventory(Item item){
        return inventory.containsKey(item.getItemIdentifier());
    }

    /**
     * Removes item from inventory
     * @param item     Item in question
     */
    private void decreaseQuantityOfItem(Item item){
        Item previousItem = inventory.get(item.getItemIdentifier());
        previousItem.decreaseQuantity(item.getQuantity());
        inventory.put(previousItem.getItemIdentifier(), previousItem);
    }

    /**
     * Fetches the current item
     * @param entry    The item requested
     * @return         Item requested
     */
    private Item getCurrentItem(Object entry){
        Map.Entry mapping = (Map.Entry) entry;
        return (Item) mapping.getValue();
    }

    /**
     * Dummy inventory system
     */
    private void addItems(){
        inventory.put("1", new Item(new ItemDTO(new Amount(40),  new Amount(10),"Apelsin"), "1", new Amount(Integer.MAX_VALUE)));
        inventory.put("2", new Item(new ItemDTO(new Amount(10),  new Amount(2),"Clementin"), "2", new Amount(Integer.MAX_VALUE)));
        inventory.put("3", new Item(new ItemDTO(new Amount(20),  new Amount(5),"Persika"), "3", new Amount(Integer.MAX_VALUE)));
    }

}