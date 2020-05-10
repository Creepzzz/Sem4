package se.kth.iv1350.amazingpos.integration;

/**
 * A object that initiates the systems needed for the application,
 * accounting system and inventory system.
 */
public class SystemCreator {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * Creates the system creator.
     */
    public SystemCreator(){
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();
    }

    /**
     * Gets the value of accountingSystem.
     *
     * @return The value of accountingSystem.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Gets the value of inventorySystem.
     *
     * @return The value of inventorySystem.
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
}