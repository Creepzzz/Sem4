package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.*;


class ItemCatalogTest {


	@Test
	void testItemCatalog() {
		String a = "1";
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean result = itemCatalog.validItem(a);
        assertTrue(result);
	}
	@Test
	public void testItemNotExists() throws AddItemException, ItemCatalogException {
		String a = "6";
        ItemCatalog itemCatalog = new ItemCatalog();
        try {
            itemCatalog.getItem(a, new Amount(1));
        } catch (AddItemException exc) {
            assertTrue(exc.getMessage().equals("Given item identifier: 6, was not found."));
        } catch (ItemCatalogException e) {
            e.printStackTrace();
        }
    }
	@Test
    public void testItemExistsWithNullString() {
		String a = null;
        ItemCatalog itemCatalog = new ItemCatalog();
        try {
            itemCatalog.getItem(a, new Amount(1));
        } catch (AddItemException | ItemCatalogException exc) {
            assertTrue(exc.getMessage().equals("Given item identifier: null, was not found."));
        }
    }
    @Test
    public void testItemExistsWhileConnectionIsDown() {
        String a = null;
        ItemCatalog itemCatalog = new ItemCatalog();
        try {
            itemCatalog.getItem(a, new Amount(1));
        } catch (ItemCatalogException exc) {
            assertTrue(exc.getMessage().equals("No connection to server."));
        } catch (AddItemException exc) {

        }
    }
}
