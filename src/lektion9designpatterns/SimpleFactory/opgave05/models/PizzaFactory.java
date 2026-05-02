package lektion9designpatterns.SimpleFactory.opgave05.models;

import lektion9designpatterns.SimpleFactory.opgave05.models.pizzas.*;

// Singleton Factory: kombinerer Singleton (én instans) med Factory (opretter objekter).
// private constructor forhindrer at nogen kan lave 'new PizzaFactory()' udefra.
// getInstance() er det eneste indgangspunkt — returnerer altid den samme instans.
public class PizzaFactory {

    private static PizzaFactory instance;

    private PizzaFactory() {}

    public static PizzaFactory getInstance() {
        if (instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("greek")) {
            return new GreekPizza();
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza();
        }
        return null;
    }
}
