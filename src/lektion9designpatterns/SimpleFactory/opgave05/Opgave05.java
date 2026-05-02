package lektion9designpatterns.SimpleFactory.opgave05;

import lektion9designpatterns.SimpleFactory.opgave05.models.PizzaStore;

public class Opgave05 {
    public static void main(String[] args) {
        PizzaStore pizzaria = new PizzaStore();
        pizzaria.orderPizza("pepperoni");
    }

}
