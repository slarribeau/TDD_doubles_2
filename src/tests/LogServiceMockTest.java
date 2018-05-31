package tests;

import main.LogServiceMock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogServiceMockTest {
    LogServiceMock logServiceMock;

    @Before
    public void setup() {
        logServiceMock = new LogServiceMock();
        logServiceMock.enable();
    }

    @Test
    public void testValidLogParameters() {
        logServiceMock.expect("user", "register", "bob");
        logServiceMock.log("user", "register", "bob");
    }

    @Test(expected = AssertionError.class)
    public void testInValidLogParameter() {
        logServiceMock.expect("user", "register", "bob");
        logServiceMock.log("user", "register", "bobby");
    }

    @Test
    public void testVerifyPass() {
        logServiceMock.expect("user", "register", "bob");
        logServiceMock.log("user", "register", "bob");
        logServiceMock.verify();
    }
    @Test(expected = AssertionError.class)
    public void testVerifyFail() {
        logServiceMock.expect("user", "register", "bob");
        //logServiceMock.log("user", "register", "bob");
        logServiceMock.verify();
    }
}
