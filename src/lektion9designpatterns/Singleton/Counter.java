package lektion9designpatterns.Singleton;

public class Counter {
    private int value;
    private Counter() {
        value = 0;
    }
    private static Counter instance;
    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
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
