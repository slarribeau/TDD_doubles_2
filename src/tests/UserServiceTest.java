package tests;

import main.UserService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static tests.TimeServiceStub.LEAP_YEAR;


public class UserServiceTest {
    TimeServiceStub timeServiceStub;
    UserService userService;
    LogServiceMock logServiceMock;
    @Before
    public void setup() {
        timeServiceStub = new TimeServiceStub();
        logServiceMock = new LogServiceMock();
        userService = new UserService(timeServiceStub, logServiceMock);
    }

    @Test
    public void StoreOneItemInDb(){
        userService.store("scott", "11 Maple Street");
        String result = userService.getAddress("scott");
        assertEquals("11 Maple Street", result);
    }

    @Test
    public void StoreOneItemInDbAndValidateLogging(){
        logServiceMock.enable();
        logServiceMock.expect("user", "PUT", "scott");
        userService.store("scott", "11 Maple Street");
        logServiceMock.verify();
    }

    @Test (expected = AssertionError.class)
    public void StoreOneItemInDbAndValidateErrorWithLogging(){
        logServiceMock.enable();
        logServiceMock.expect("user", "PUT", "Scotty");
        userService.store("scott", "11 Maple Street");
        logServiceMock.verify();
    }

    @Test
    public void StoreOneItemInDbAndValidateTimeStamp(){
        userService.store("scott", "11 Maple Street");
        DateTime result = userService.getCreationDate("scott");
        assertEquals(LEAP_YEAR, result.toString());
    }

    @Test
    public void storeTwoItemsInDb(){
        userService.store("peter", "1 Cisco Way");
        String result = userService.getAddress("peter");
        assertEquals("1 Cisco Way", result);

        userService.store("lisa", "99 Pine Street");
        String result2 = userService.getAddress("lisa");
        assertEquals("99 Pine Street", result2);
    }
}
