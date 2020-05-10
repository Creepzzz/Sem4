package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.*;

public class Printer {
    /**
     * New instans of type printer
     */
    public Printer(){
    }

    /**
     * Prints the reciept
     * @param receipt     The reciept of the purchase
     */
    public static void printReciept(Receipt receipt){
        System.out.println(receipt.toString());
    }
}