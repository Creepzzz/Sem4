package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.*;
import java.time.LocalDateTime;
import java.util.HashMap;

public class AccountingSystem {
    private HashMap<LocalDateTime, Sale> account = new HashMap<>();

    /**
     * Creates dummy accounting system
     */
    public AccountingSystem(){
    }

    /**
     * Adds sale to the book keep system
     * @param sale    The sale that is to be written to the book keep
     */
    public void updateAccount(Sale sale){
        LocalDateTime saleTime = LocalDateTime.now();
        account.put(saleTime, sale);
    }
}