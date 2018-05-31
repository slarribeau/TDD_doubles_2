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
        assertEquals(d.currentTime().toString(), LEAP_YEAR);

        System.out.println(d.currentTime());
    }
}
