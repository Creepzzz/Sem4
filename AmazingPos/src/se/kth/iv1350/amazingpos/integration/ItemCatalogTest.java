package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ItemCatalogTest {


	@Test
	void testItemCatalog() {
		String a = "1";
        boolean expectedResult = true;
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean result = itemCatalog.validItem(a);
        assertTrue(result);
	}
	@Test
	public void testItemNotExists() {
		String a = "6";
        boolean expectedResult = false;
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean result = itemCatalog.validItem(a);
        assertFalse(result);
    }
	@Test
    public void testItemExistsWithNullString() {
		String a = null;
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean result = itemCatalog.validItem(a);
        assertFalse(result);
    }
}
