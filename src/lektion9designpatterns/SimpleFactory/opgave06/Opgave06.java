package lektion9designpatterns.SimpleFactory.opgave06;

import lektion9designpatterns.SimpleFactory.opgave06.models.ChicagoPizzaStore;
import lektion9designpatterns.SimpleFactory.opgave06.models.NYPizzaStore;
import lektion9designpatterns.SimpleFactory.opgave06.models.Pizzaria;

public class Opgave06 {
    public static void main(String[] args) {
        // Stilvalget sker her — ved at vælge hvilken subklasse vi instantierer.
        // Vi sender IKKE "NY" eller "Chicago" som parameter til orderPizza() længere.
        Pizzaria nyStore = new NYPizzaStore();
        nyStore.orderPizza("cheese");

        System.out.println();

        Pizzaria chicagoStore = new ChicagoPizzaStore();
        chicagoStore.orderPizza("pepperoni");
    }
}
