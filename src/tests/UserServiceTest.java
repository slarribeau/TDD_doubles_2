package tests;

import main.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class UserServiceTest {
    TimeServiceStub timeServiceStub;
    UserService userService;

    @Before
    public void setup() {
        timeServiceStub = new TimeServiceStub();
        userService = new UserService(timeServiceStub);
    }

    @Test
    public void firstTest(){
        userService.store("scott", "11 Maple Street");
        String result = userService.getAddress("scott");
        assertEquals("11 Maple Street", result);
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
