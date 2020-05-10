package se.kth.iv1350.amazingpos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    private Controller ctrl;

    @BeforeEach
    public void setUp() {
        ctrl = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
    }

    @AfterEach
    public void tearDown() {
        ctrl = null;
    }

    @Test
    public void registerItem() throws AddItemException, ItemCatalogException, OperationFailedException {
        ctrl.startSale();
        String itemName = "Paprika";
        String itemID = "1";
        Amount price = new Amount(40);
        Amount taxAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + price + "\t" +
                    "| Tax amount: " + taxAmount +
                    " |  Quantity: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);
            assertEquals(expectedResult, actualResult);
        } catch (OperationFailedException exc) {

        } catch (AddItemException exc) {

        }
    }

    @Test
    public void registerNullItem() throws AddItemException, ItemCatalogException, OperationFailedException {

        String itemName = "Kidneybönor";
        String itemID = "1";
        Amount price = new Amount(40);
        Amount taxAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + price + "\t" +
                    "| Tax amount: " + taxAmount +
                    " |  Quantity: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);
            assertEquals(expectedResult, actualResult);
        } catch (OperationFailedException exc) {

        } catch (AddItemException exc) {

        } catch (IllegalStateException exc) {
            assertTrue(exc.getMessage().equals("Call to registerItem was made before initiating a new sale."));
        }
    }

    @Test
    public void registerEmptyIdItem() throws AddItemException, ItemCatalogException, OperationFailedException {
        ctrl.startSale();
        String itemName = "Kidneybönor";
        String itemID = "";
        Amount price = new Amount(40);
        Amount taxAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + price + "\t" +
                    "| Tax amount: " + taxAmount +
                    " |  Quantity: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);

        } catch (OperationFailedException exc) {

        } catch (AddItemException exc) {
            assertTrue(exc.getMessage().equals("Given item identifier: , was not found."));

        }
    }
    @Test
    public void registerUnkownItem() throws AddItemException, ItemCatalogException, OperationFailedException {
        ctrl.startSale();
        String itemName = "Kidneybönor";
        String itemID = "6";
        Amount price = new Amount(40);
        Amount taxAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + price + "\t" +
                    "| Tax amount: " + taxAmount +
                    " |  Quantity: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);

        } catch (AddItemException exc) {
            assertTrue(exc.getMessage().equals("Given item identifier: 6, was not found."));
        }
    }
    @Test
    public void registerItemWithoutConnection() throws AddItemException, ItemCatalogException, OperationFailedException {
        ctrl.startSale();
        String itemName = "Kidneybönor";
        String itemID = "5";
        Amount price = new Amount(40);
        Amount taxAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + price + "\t" +
                    "| Tax amount: " + taxAmount +
                    " |  Quantity: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);

        } catch (OperationFailedException exc) {
            assertTrue(exc.getMessage().equals("Could not retrieve the item."));
        }
    }

}
