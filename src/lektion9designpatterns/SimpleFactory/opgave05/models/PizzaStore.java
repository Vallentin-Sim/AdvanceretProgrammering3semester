package lektion9designpatterns.SimpleFactory.opgave05.models;

import lektion9designpatterns.SimpleFactory.opgave05.models.pizzas.Pizza;

// PizzaStore kender ikke til de konkrete pizza-klasser længere.
// Al oprettelseslogik er delegeret til PizzaFactory-singletonen.
public class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = PizzaFactory.getInstance().createPizza(type);
        if (pizza == null) {
            return null;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
