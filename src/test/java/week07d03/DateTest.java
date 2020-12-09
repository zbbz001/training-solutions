package week07d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    Date date;

    @BeforeEach
    void init() {
        date = Date.of(2000, 01, 01);
    }

    @Test
    public void dateTest() {
        assertEquals(new Date(2000, 1, 1) , date);
    }

    @Test
    public void dateWithYearTest() {
        Date newDateWithYear = date.withYear(2002);
        assertEquals(new Date(2002, 1, 1) , newDateWithYear);
    }

    @Test
    public void dateWithMonthTest() {
        Date newDateWithMonth = date.withMonth(10);
        assertEquals(new Date(2000, 10, 1) , newDateWithMonth);
    }

    @Test
    public void dateWithDayTest() {
        Date newDateWithDay = date.withDay(10);
        assertEquals(new Date(2000, 1, 10) , newDateWithDay);
    }
}