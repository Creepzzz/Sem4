package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.util.Amount;
import java.util.List;
import java.util.ArrayList;

public class Payment{

    private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();
    private Amount paidAmount;
    private Total total;
    private Item item;

    /**
     * Creates a instance of payment
     * @param paidAmount     The amount customer has paid
     * @param total          The total price that is to be paid
     */
    public Payment(Amount paidAmount, Total total){
        this.paidAmount = paidAmount;
        this.total = total;
    }

    private void notifyObserver(){
        for(TotalRevenueObserver obs : totalRevenueObservers){
            obs.updateTotalRevenue(total);
        }
    }

    /**
     * The right observer is notified when total is paid
     * @param observers   The right observer
     */
    public void addObservers(List<TotalRevenueObserver> observers){
        totalRevenueObservers.addAll(observers);
    }
    /**
     * Will give you the total cost that is to be paid
     * @return      Returns total cost
     */
    Total getTotal() {
        return total;
    }

    /**
     *  Will give you the amount paid
     * @return
     */
    public Amount getPaidAmount(){
        return paidAmount;
    }

    /**
     * Getter of the amount of change the customer is to be given
     * @return      Returns the amount of change the customer is to be given
     */
    public Amount getChange(){
        notifyObserver();
        return paidAmount.decrease(total.getTotalPriceWithVAT());
    }
}
