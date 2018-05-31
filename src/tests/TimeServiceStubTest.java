package tests;

import main.TimeService;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static tests.TimeServiceStub.LEAP_YEAR;

public class TimeServiceStubTest {

    @Test
    public void testHardCodedLeapYearDateValue() {
        TimeService d = new TimeServiceStub();
        String time = d.currentTime().toString();
        assertEquals(time, LEAP_YEAR);

        System.out.println(time);
    }
}
