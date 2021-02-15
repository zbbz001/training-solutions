package week15d02;

import collectionsmap.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OrderManager {
    private Map<String, Courier> courierMap = new HashMap<>();

    public void read(BufferedReader reader) throws IOException {
        Pattern patternDate = Pattern.compile("([0-9]+)\\.([0-9]+)\\.([0-9]+)", Pattern.CASE_INSENSITIVE);

        String line;
        String actualCourierName = null;
        LocalDate date = null;

        while ((line = reader.readLine()) != null) {
            Matcher matcher = patternDate.matcher(line);
            boolean matchFound = matcher.find();
            if (matchFound) {
                date = LocalDate.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
            } else if (line.startsWith("FUT")) {
                actualCourierName = line;
                if (!courierMap.containsKey(actualCourierName)) {
                    courierMap.put(actualCourierName, new Courier(actualCourierName));
                }
            } else {
                courierMap.get(actualCourierName).add(date, new Order().orderFromString(line));
            }
        }
    }

    public LocalDate getDaysOfLessOrders() {
        HashMap<LocalDate, Integer> ordersByName = new HashMap<>();

        courierMap.forEach((key, value) -> value
                .getOrderNumByDay()
                .forEach((k, v) -> ordersByName.merge(k, v, Integer::sum)));

        return ordersByName.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
    }

    public Order getOrder(LocalDate date, LocalTime time) {
        for (Map.Entry<String, Courier> entry : courierMap.entrySet()) {
            Order order = entry.getValue().getOrderByDateTime(date, time);
            if (order != null) {
                return order;
            }
        }

        throw new IllegalStateException("order not found");
    }

    public Map<String, Integer> getStatisticByCourier() {
        return courierMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().sumDelivery())
                );
    }

    public String getMostOrdersAddress() {
        return courierMap.entrySet()
                .stream()
                .map(e -> e.getValue().getAllAddress())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(OrderManager.class.getResourceAsStream("/orders.txt")))) {
            OrderManager orderManager = new OrderManager();
            orderManager.read(reader);

            System.out.println(orderManager.getDaysOfLessOrders());
            System.out.println(orderManager.getOrder(LocalDate.of(2020, 12, 03), LocalTime.of(12, 30)));
            System.out.println(orderManager.getStatisticByCourier());
            System.out.println(orderManager.getMostOrdersAddress());

        } catch (IOException e) {
            throw new IllegalStateException("File cannot read!", e);
        }
    }
}
