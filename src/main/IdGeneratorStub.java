package main;

public class IdGeneratorStub extends IdGenerator {
    long stubValue;

    public long get() {
        return System.currentTimeMillis();
    }

    public void setStub(long i) {
        stubValue = i;
    }
}
