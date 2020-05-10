package se.kth.iv1350.amazingpos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalTest {
    private Total totalWithZero;

    @BeforeEach
    void setUp() {
        totalWithZero = new Total();
    }

    @AfterEach
    void tearDown() {
        totalWithZero = null;
    }

    @Test
    void getTotalWithTax() {
        String itemIdentifier = "1";
        Amount price = new Amount(20);
        Amount VAT = new Amount(5);
        Amount quantity = new Amount(1);
        ItemDTO itemDescription = new ItemDTO(price,VAT, itemIdentifier);
        Item item = new Item(itemDescription, itemIdentifier, quantity);

        Amount expectedTotalWithTax = price.add(VAT);

        totalWithZero.updateTotal(item);
        Amount resultTotalWithTax = totalWithZero.getTotalPriceWithVAT();

        assertEquals(expectedTotalWithTax.getAmount(), resultTotalWithTax.getAmount());

    }

    @Test
    void updateTotal() {
        String itemIdentifier = "1";
        Amount price = new Amount(20);
        Amount VAT = new Amount(5);
        Amount quantity = new Amount(4);
        ItemDTO itemDescription = new ItemDTO(price,VAT, itemIdentifier);
        Item item = new Item(itemDescription, itemIdentifier, quantity);

        Amount expectedTotal = price.multiply(quantity);
        Amount expectedTax = VAT.multiply(quantity);

        totalWithZero.updateTotal(item);
        Amount resultTotal = totalWithZero.getTotalPrice();
        Amount resultTax = totalWithZero.getTotalVAT();

        assertEquals(expectedTotal.getAmount(), resultTotal.getAmount());
    }

    @Test
    void updateTotalWithNullItem() {
        String itemIdentifier = "1";
        Amount price = new Amount(20);
        Amount VAT = new Amount(5);
        Amount quantity = new Amount(4);
        ItemDTO itemDescription = new ItemDTO(price,VAT, itemIdentifier);
        Item item = null;

        Amount expectedTotal = price.multiply(quantity);
        Amount expectedTax = VAT.multiply(quantity);

        totalWithZero.updateTotal(item);
        Amount resultTotal = totalWithZero.getTotalPrice();
        Amount resultTax = totalWithZero.getTotalVAT();
    }
}