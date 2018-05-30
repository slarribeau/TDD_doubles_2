package tests;

import main.DBService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class DBServiceTest {

    TimeSourceStub tsServ;
    DBService dbServ;

    @Before
    public void setup() {
        tsServ = new TimeSourceStub();
        dbServ = new DBService(tsServ);
    }

    @Test
    public void firstTest(){
        dbServ.store("scott", "11 Maple Street");
        String result = dbServ.getAddress("scott");
        assertEquals("11 Maple Street", result);
    }

    @Test
    public void storeTwoItemsInDb(){
        dbServ.store("peter", "1 Cisco Way");
        String result = dbServ.getAddress("peter");
        assertEquals("1 Cisco Way", result);

        dbServ.store("lisa", "99 Pine Street");
        String result2 = dbServ.getAddress("lisa");
        assertEquals("99 Pine Street", result2);
    }
}
