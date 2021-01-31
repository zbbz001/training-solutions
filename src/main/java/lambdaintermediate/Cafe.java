package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders = new ArrayList<>();

    public void add(CoffeeOrder order) {
        orders.add(order);
    }

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public BigDecimal getTotalIncome() {
        return orders.stream()
                .flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(new BigDecimal(0), BigDecimal::add, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(date))
                .flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(new BigDecimal(0), BigDecimal::add, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .map(coffee -> coffee.getType())
                .filter(coffeeType -> coffeeType.equals(type))
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(date))
                .sorted((co1, co2) -> (co1.getDateTime().compareTo(co2.getDateTime())))
                .limit(5)
                .collect(Collectors.toList());
    }


}
