package lektion9designpatterns;

import lektion9designpatterns.Singleton.Counter;
import lektion9designpatterns.Singleton.CounterEnum;

public class test {
    public static void main(String[] args) {
        Counter counter = Counter.getInstance();
        CounterEnum counterEnum = CounterEnum.UNIQUE_INSTANCE;

        System.out.println("Regular counter singleton test area: \n" + counter.getValue());

        System.out.println("count + 2");
        counter.count();
        counter.count();
        System.out.println("count should be 2: " + counter.getValue());
        System.out.println("count times two");
        counter.timesTwo();
        System.out.println("count should be 4 now: " + counter.getValue());
        System.out.println("reset counter to zero");
        counter.zero();
        System.out.println("reset counter to zero: " + counter.getValue());

        System.out.println("Testing Enum");
        System.out.println("current count: " + counterEnum.getValue());

        counterEnum.count();
        counterEnum.count();
        System.out.println("current count: " + counterEnum.getValue());
        counterEnum.timesTwo();
        System.out.println("times two: " + counterEnum.getValue());
        System.out.println("reset counter to zero");
        counterEnum.zero();
        System.out.println("reset counter to zero: " + counterEnum.getValue());
    }
}
