package lektion9designpatterns.SimpleFactory.opgave06.models;

import lektion9designpatterns.SimpleFactory.opgave06.models.pizza.*;

// Konkret Creator: implementerer factory method for NY-stil pizzaer
public class NYPizzaStore extends Pizzaria {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        }
        return null;
    }
}
