package se.kth.iv1350.amazingpos.model;

public interface TotalRevenueObserver {
    /**
     * Updates the payment whenever it's made
     * @param total   The total amount
     */
    void updateTotalRevenue(Total total);
}
