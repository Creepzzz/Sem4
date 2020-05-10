package se.kth.iv1350.amazingpos.integration;

public class CatalogCreator {
    private ItemCatalog itemCatalog;

    /**
     * Creates instance of item catalog
     */
    public CatalogCreator(){
        itemCatalog = new ItemCatalog();
    }

    /**
     * Getter of item catalog
     * @return      Item catalog
     */
    public ItemCatalog getItemCatalog(){
        return itemCatalog;
    }
}