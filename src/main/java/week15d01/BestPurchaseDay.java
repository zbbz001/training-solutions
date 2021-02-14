package week15d01;

public class BestPurchaseDay {
    int purchaseDay;
    int sellDay;
    int profit;

    public BestPurchaseDay(int purchaseDay, int sellDay, int profit) {
        this.purchaseDay = purchaseDay;
        this.sellDay = sellDay;
        this.profit = profit;
    }

    public int getPurchaseDay() {
        return purchaseDay;
    }

    public int getSellDay() {
        return sellDay;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "BestPurchaseDay{" +
                "purchaseDay=" + purchaseDay +
                ", sellDay=" + sellDay +
                ", profit=" + profit +
                '}';
    }
}
