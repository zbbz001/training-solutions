package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersonList) {
        Salesperson personWithFurthestBelowTarget = null;

        for (Salesperson salesperson : salespersonList) {
            if (personWithFurthestBelowTarget == null || salesperson.getDifferenceFromTarget() < personWithFurthestBelowTarget.getDifferenceFromTarget()) {
                personWithFurthestBelowTarget = salesperson;
            }
        }

        return personWithFurthestBelowTarget;
    }
}
