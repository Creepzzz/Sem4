package se.kth.iv1350.amazingpos.model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentTest {

    @Test
    public void getChangeTest(){
        Amount price = new Amount(30);
        Amount VAT = new Amount(10);
        Amount quantity = new Amount(1);
        String itemID = "Appelsin";
        ItemDTO itemDTO = new ItemDTO(price, VAT, itemID);
        Item item = new Item(itemDTO, itemID, quantity);
        Total total = new Total();
        total.updateTotal(item);
        Amount paidAmount = new Amount(100);
        Payment payment = new Payment(paidAmount, total);
        Amount expectedResult = paidAmount.decrease(price.multiply(quantity).add(VAT.multiply(quantity)));
        Amount actualResult = payment.getChange();
        assertEquals(expectedResult.getAmount(), actualResult.getAmount());
    }

}