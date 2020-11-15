package algorithmssum.sales;

import java.util.List;

public class SalesAmountSumCalculator {

    public int sumSalesAmount(List<Salesperson> salespersons) {
        int sumAmount = 0;
        for (Salesperson salesperson : salespersons) {
            sumAmount += salesperson.getAmount();
        }

        return sumAmount;
    }

}
