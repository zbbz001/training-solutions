package week15d02;

import java.time.LocalDate;

public class DayOrders {
    LocalDate date;
    int ordersNum = Integer.MAX_VALUE;

    public DayOrders(LocalDate date, int ordersNum) {
        this.date = date;
        this.ordersNum = ordersNum;
    }

    public DayOrders() {
    }

    public LocalDate getDate() {
        return date;
    }

    public int getOrdersNum() {
        return ordersNum;
    }

    @Override
    public String toString() {
        return "DayOrders{" +
                "date=" + date +
                ", ordersNum=" + ordersNum +
                '}';
    }
}
