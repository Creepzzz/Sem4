package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.model.Item;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.*;


class ItemTest {
    private Item itemWithAprikos;

    @BeforeEach
    public void setUp() {
        String identifier = "1";
        itemWithAprikos = new Item(new ItemDTO(new Amount(20), new Amount(10), "Aprikos"), identifier, new Amount(10));
    }

    @AfterEach
    void tearDown() {
        itemWithAprikos = null;
    }

    @Test
    void testIncreaseQuantity() {
        Amount summand1 = new Amount(10);
        Amount summand2 = new Amount(2);
        Amount expectedAmount = summand1.add(summand2);
        itemWithAprikos.increaseQuantity(summand2);
        Amount resultAmount = itemWithAprikos.getQuantity();
        assertEquals(expectedAmount.getAmount(), resultAmount.getAmount());
    }

    @Test
    void testIncreaseQuantityWithNegativeSummand() {
        Amount summand1 = new Amount(10);
        Amount summand2 = new Amount(-1);
        Amount expectedAmount = summand1.add(summand2);
        itemWithAprikos.increaseQuantity(summand2);
        Amount resultAmount = itemWithAprikos.getQuantity();
        assertEquals(expectedAmount.getAmount(), resultAmount.getAmount());
    }

    @Test
    void testIncreaseQuantityWithMaxValue() {
        Amount summand1 = new Amount(10);
        Amount summand2 = new Amount(Integer.MAX_VALUE);
        Amount expectedAmount = summand1.add(summand2);
        itemWithAprikos.increaseQuantity(summand2);
        Amount resultAmount = itemWithAprikos.getQuantity();
        assertEquals(expectedAmount.getAmount(), resultAmount.getAmount());
    }


    @Test
    void testToString() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "clementin";
        ItemDTO itemDTO = new ItemDTO(price,tax, itemName);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(itemDTO, itemName, quantity);
        String expectedString = "item identifier: " + itemName + "quantity: " + quantity + "item description: " + itemDTO.toString();
        String resultString = itemToTest.toString();
        assertEquals( expectedString, resultString);
    }

    @Test
    void testToStringNotTheSameString() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "clementin";
        ItemDTO itemDTO = new ItemDTO(price,tax, itemName);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(itemDTO, itemName, quantity);
        String expectedString = "im ideifer: " + itemName + "quanty: " + quantity + "it descrion: " + itemDTO.toString();
        String resultString = itemToTest.toString();
        assertNotEquals( expectedString, resultString);
    }

    @Test
    void testToStringWithEmptyStrings() {
        Amount price = new Amount(0);
        Amount tax = new Amount(0);
        String itemName = "";
        ItemDTO itemDTO = new ItemDTO(price,tax, itemName);
        Amount quantity = new Amount(0);
        Item itemToTest = new Item(itemDTO, itemName, quantity);
        String expectedString = "";
        String resultString = itemToTest.toString();
        assertNotEquals(expectedString, resultString);
    }

    @Test
    void testEquals() {
        Amount price = new Amount(20);
        Amount tax = new Amount(10);
        String itemName = "clementin";
        String itemIdentifier = "1";
        ItemDTO otherItemDTO = new ItemDTO(price,tax, itemName);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(otherItemDTO, itemIdentifier, quantity);
        System.out.println(itemToTest);
        boolean actualResult = itemWithAprikos.getClass().equals(itemToTest.getClass());
        assertTrue(actualResult);
    }

    @Test
    void testEqualsNotEqual() {
        Amount price = new Amount(9);
        Amount tax = new Amount(1);
        String itemName = "clementin";
        String itemIdentifier = "5";
        ItemDTO otherItemDTO = new ItemDTO(price,tax, itemName);
        Amount quantity = new Amount(0);
        Item itemToTest = new Item(otherItemDTO, itemIdentifier, quantity);
        boolean actualResult = itemWithAprikos.equals(itemToTest);
        assertFalse(actualResult);
    }

    @Test
    void testEqualsNull() {
        Item itemToTest = null;
        boolean actualResult = itemWithAprikos.equals(itemToTest);
        assertFalse(actualResult);
    }

    @Test
    void testEqualsJavaObject() {
        Object object = new Object();
        boolean actualResult = itemWithAprikos.equals(object);
        assertFalse(actualResult);
    }

    @Test
    void testEqualsNotTheSameIdentifier() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "Paprika";
        ItemDTO otherItemDTO = new ItemDTO(price,tax, itemName);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(otherItemDTO,"test",quantity);
        boolean actualResult = itemWithAprikos.equals(itemToTest);
        assertFalse(actualResult);
    }
}
