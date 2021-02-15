package week15d02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Courier {
    private String name;
    private Map<LocalDate, List<Order>> orders = new TreeMap<>();

    public Courier(String name) {
        this.name = name;
    }

    public int sumDelivery() {
        return getOrderNumByDay()
                .values()
                .stream()
                .reduce(0, Integer::sum);
    }

    public Map<LocalDate, Integer> getOrderNumByDay() {
        return orders.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().size()));
    }

    public List<String> getAllAddress() {
        List<String> addressOrders = new ArrayList<>();

        orders.forEach((key, value) -> value.stream()
                .forEach(v -> addressOrders.add(v.getAddress())));

        return addressOrders;
    }

    public Order getOrderByDateTime(LocalDate date, LocalTime time) {
        if (orders.containsKey(date)) {
            for (Order order : orders.get(date)) {
                if (time.equals(order.getTime())) {
                    return order;
                }
            }
        }

        return null;
    }

    public void add(LocalDate date, Order order) {
        if (!orders.containsKey(date)) {
            orders.put(date, new ArrayList<>());
        }

        orders.get(date).add(order);
    }

    public Map<LocalDate, List<Order>> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
