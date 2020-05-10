package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
    private Sale sale;
    private Payment payment;
    private LocalDateTime saleDate;
    private String beganTime;
    private String endTime;


    /**
     * Creates an instance of type receipt
     * @param sale    The receipt contains information about the sale
     */
    public Receipt(Sale sale, Payment payment){
        this.payment = payment;
        this.sale = sale;
        beganTime = sale.startTime();
        endTime = sale.endTime();

    }

    public String toString(){
        saleDate =LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("------------RECIEPT-----------" + "\n");
        sb.append("Sale began: " + beganTime + "\n");
        sb.append("Store name: Some store\n");
        sb.append("Adres: Store street\n");
        sb.append("*Phonenumber*\n");
        sb.append("www.thisstore.se\n");
        sb.append("Items:\n");
        sb.append(sale.toString());
        sb.append("Paid SEK: " +payment.getPaidAmount().getAmount()+ "\n");
        sb.append("Change SEK: " +payment.getChange().toString()+ "\n");
        sb.append("Sale ended: " +endTime+"\n");
        sb.append("---THANK YOU FOR SHOPPING----");
        return sb.toString();
    }
}