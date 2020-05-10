package se.kth.iv1350.amazingpos.model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaleTest {

        @Test
        void testUpdateSale() {
            Amount price = new Amount(20);
            Amount VAT = new Amount(5);
            String itemName = "Paprika";
            String itemID = "1";
            ItemDTO itemDescription = new ItemDTO(price, VAT,  itemName);
            Amount quantity = new Amount(1);
            Item item = new Item(itemDescription, itemID, quantity);
            Sale sale = new Sale();
            String actualResult = sale.updateSale(item);
            String expectedResult = "item name: " + itemName + "\t" +
                    "price: " + price + "\t" +
                    "tax amount: " + VAT + "\t" + " quantity: " + quantity ;
            assertEquals(expectedResult, actualResult);
        }


        @Test
        void tesToString() {
            Amount price = new Amount(20);
            Amount VAT = new Amount(5);
            String itemNameAndIdentifier = "paprika";
            ItemDTO itemDescription = new ItemDTO(price, VAT,  itemNameAndIdentifier);
            Amount quantity = new Amount(1);
            Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
            Sale sale = new Sale();
            sale.updateSale(item);
            String expectedResult = "item name: " + itemNameAndIdentifier + "\t" +
                    "price: " + price + "\t" +
                    "tax amount: " + VAT + "\t" +
                    " quantity: " + quantity + "\nTotal: " + price + "\nVAT: " + VAT + "\n";
            String actualResult = sale.toString();
            assertEquals( expectedResult, actualResult);
        }
}