package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersonList) {
        Salesperson personWithFurthestAboveTarget = null;

        for (Salesperson salesperson : salespersonList) {
            if (personWithFurthestAboveTarget == null || salesperson.getDifferenceFromTarget() > personWithFurthestAboveTarget.getDifferenceFromTarget()) {
                personWithFurthestAboveTarget = salesperson;
            }
        }

        return personWithFurthestAboveTarget;
    }
}
