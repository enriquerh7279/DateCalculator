package adder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class DateCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void requiredTests() {
        DateCalculator dc = new DateCalculator(0);
        Date d = dc.testDateCalculator(8,9,2010,5);
        assertEquals(d.toString(), "8/14/2010");

        d = dc.testDateCalculator(12,15,2013,20);
        assertEquals(d.toString(), "1/4/2014");

        d = dc.testDateCalculator(6,24,2014,10);
        assertEquals(d.toString(), "7/4/2014");

        d = dc.testDateCalculator(2,14,2012,20);
        assertEquals(d.toString(), "3/5/2012");

        d = dc.testDateCalculator(1,7,2020,60);
        assertEquals(d.toString(), "3/7/2020");
    }

    void myTests() {
        DateCalculator dc = new DateCalculator(0);

        //Test if the new date is on a leap day in a leap year
        Date d = dc.testDateCalculator(12,31,2011,60);
        assertEquals(d.toString(), "2/29/2012");

        //Test with new date in new year
        d = dc.testDateCalculator(12,31,2009,1);
        assertEquals(d.toString(), "1/1/2010");

        //Test when new date is beyond a valid "to be entered" date
        d = dc.testDateCalculator(12,31,2025,1);
        assertEquals(d.toString(), "1/1/2026");

        //Test With new date in the same month
        d = dc.testDateCalculator(2,14,2000,14);
        assertEquals(d.toString(), "2/28/2000");

        //Test with new date in a new month, since April only has 30 days
        d = dc.testDateCalculator(4,1,2025,30);
        assertEquals(d.toString(), "5/1/2025");
    }
}