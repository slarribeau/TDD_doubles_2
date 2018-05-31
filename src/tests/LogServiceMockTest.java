package tests;

import main.LogServiceMock;
import org.junit.Before;
import org.junit.Test;

public class LogServiceMockTest {
    LogServiceMock logServiceMock;

    @Before
    public void setup() {
        logServiceMock = new LogServiceMock();
    }

    @Test
    public void first() {
        logServiceMock.expect("user", "register", "bob");
           logServiceMock.log("user", "register", "bob");
        logServiceMock.verify();

    }
}
