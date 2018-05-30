package tests;

import main.TimeService;
import org.joda.time.DateTime;

public class TimeServiceStub implements TimeService {

    public static final String LEAP_YEAR = "2020-02-29T08:00:01.001-08:00";

    @Override
    public DateTime currentTime() {
        return new DateTime(LEAP_YEAR);
    }
}