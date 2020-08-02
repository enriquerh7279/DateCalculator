package adder;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @org.junit.jupiter.api.Test
    void isValidMonth() {
        Date d = new Date();
        assertTrue(d.isValidMonth(1));
        assertTrue(d.isValidMonth(6));
        assertTrue(d.isValidMonth(12));
        assertFalse(d.isValidMonth(13));
        assertFalse(d.isValidMonth(16));
        assertFalse(d.isValidMonth(-1));
        assertFalse(d.isValidMonth(0));
    }

    @org.junit.jupiter.api.Test
    void isValidYear() {
        Date d = new Date();
        assertTrue(d.isValidYear(2000));
        assertTrue(d.isValidYear(2011));
        assertTrue(d.isValidYear(2025));
        assertFalse(d.isValidYear(13));
        assertFalse(d.isValidYear(1999));
        assertFalse(d.isValidYear(2026));
    }

    @org.junit.jupiter.api.Test
    void isValidDay() {
        Date d = new Date();
        assertTrue(d.isValidDay(1,31,2000));
        assertTrue(d.isValidDay(2,29,2000));
        assertTrue(d.isValidDay(11,15,2000));
        assertTrue(d.isValidDay(4,18,2080));
        assertTrue(d.isValidDay(1,1,2026));
        assertFalse(d.isValidDay(2,29,2001));
        assertFalse(d.isValidDay(13,1,2001));
        assertFalse(d.isValidDay(6,50,2017));
    }

    @org.junit.jupiter.api.Test
    void isLeapYear() {
        Date d = new Date();
        assertTrue(d.isLeapYear(2012));
        assertTrue(d.isLeapYear(2000));
        assertTrue(d.isLeapYear(1600));
        assertFalse(d.isLeapYear(1800));
        assertFalse(d.isLeapYear(2011));
        assertFalse(d.isLeapYear(2017));
    }

    @org.junit.jupiter.api.Test
    void getMaxDaysInMonth() {
        Date d = new Date();
        assertEquals(29, d.getMaxDaysInMonth(2,2012));
        assertEquals(28, d.getMaxDaysInMonth(2,2013));
        assertEquals(30, d.getMaxDaysInMonth(11,2012));
        assertEquals(31, d.getMaxDaysInMonth(12,2012));
        assertEquals(31, d.getMaxDaysInMonth(7,2012));
        assertEquals(31, d.getMaxDaysInMonth(8,2012));
    }
}