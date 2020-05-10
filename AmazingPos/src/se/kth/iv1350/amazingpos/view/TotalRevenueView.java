package se.kth.iv1350.amazingpos.view;
import se.kth.iv1350.amazingpos.model.*;

public class TotalRevenueView implements TotalRevenueObserver{
    private Total totalRevenue;

    public TotalRevenueView(){
        totalRevenue = new Total();
    }

    /**
     * Updates the total revenue
     * @param total    The total amount
     */
    public void updateTotalRevenue(Total total){
        totalRevenue.updateTotalRevenue(total);
        printCurrentTotalRevenue();
    }

    private void printCurrentTotalRevenue(){
        System.out.println("---------TOTAL REVENUE--------");
        System.out.println("Amount: " +totalRevenue.getTotalPriceWithVAT().toString());
    }
}
