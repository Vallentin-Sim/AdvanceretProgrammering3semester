package lektion9designpatterns.SimpleFactory.opgave06.models;

import lektion9designpatterns.SimpleFactory.opgave06.models.pizza.*;

// Konkret Creator: implementerer factory method for Chicago-stil pizzaer
public class ChicagoPizzaStore extends Pizzaria {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        }
        return null;
    }
}
