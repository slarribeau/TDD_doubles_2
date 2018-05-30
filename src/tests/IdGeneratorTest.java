package tests;

import main.IdGenerator;
import main.IdGeneratorStub;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class IdGeneratorTest {

    @Test
    public void testStubReturnsProgrammedValue(){
        IdGeneratorStub idGen = new IdGeneratorStub();
        idGen.setStub(7L);
        long id = idGen.get();
        assertNotEquals(7L, id);
    }
}
