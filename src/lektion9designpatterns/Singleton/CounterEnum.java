package lektion9designpatterns.Singleton;

public enum CounterEnum {
    UNIQUE_INSTANCE;
    private int value;
    CounterEnum() {
        value = 0;
    }

    public void count(){
        value++;
    }
    public void timesTwo(){
        value = value*2;
    }

    public void zero(){
        value = 0;
    }

    public int getValue() {
        return value;
    }
}
