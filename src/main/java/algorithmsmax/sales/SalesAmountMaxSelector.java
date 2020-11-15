package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersonList) {
        Salesperson salespersonWithMaxSalesAmount = null;

        for (Salesperson salesperson : salespersonList) {
            if (salespersonWithMaxSalesAmount == null || salesperson.getAmount() > salespersonWithMaxSalesAmount.getAmount()) {
                salespersonWithMaxSalesAmount = salesperson;
            }
        }

        return salespersonWithMaxSalesAmount;
    }


}
