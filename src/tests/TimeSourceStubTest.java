package tests;

import main.TimeSource;
import org.junit.Test;

public class TimeSourceStubTest {

    @Test
    public void foo() {
        TimeSource d = new TimeSourceStub();
        System.out.println(d.currentTime());
    }
}
