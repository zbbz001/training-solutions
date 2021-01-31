package lambdacollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {
    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void add(CoffeeOrder order) {
        orders.add(order);
    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {
        return orders.stream()
                .flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .collect(Collectors.groupingBy((Coffee coffee) -> coffee.getType(), Collectors.counting()));
    }

    public double getAverageOrder() {
        return orders.stream()
                .collect(Collectors.averagingDouble(coffee -> coffee.getCoffeeList().size()));
    }
}
