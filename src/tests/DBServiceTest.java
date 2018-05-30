package tests;

import main.DBService;
import main.IdGeneratorStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DBServiceTest {
    private static final long STUB_ID_A = 5;
    private static final long STUB_ID_B = 6;

    IdGeneratorStub idGen;
    DBService dbServ;

    @Before
    public void setup() {
        idGen = new IdGeneratorStub();
        idGen.setStub(STUB_ID_A);
        dbServ = new DBService(idGen);
    }
    @Test
    public void firstTest(){
        long id = dbServ.store("scott");
        assertNotEquals(STUB_ID_A, id);
        String result = dbServ.find(id);
        assertEquals("scott", result);
    }

    @Test
    public void storeTwoItemsInDb(){
        long id = dbServ.store("peter");
        assertNotEquals(STUB_ID_A, id);
        String result = dbServ.find(id);
        assertEquals("peter", result);

        idGen.setStub(STUB_ID_B);
        long id2 = dbServ.store("lisa");
        assertNotEquals(STUB_ID_B, id2);
        String result2 = dbServ.find(id2);
        assertEquals("lisa", result);
    }
}
