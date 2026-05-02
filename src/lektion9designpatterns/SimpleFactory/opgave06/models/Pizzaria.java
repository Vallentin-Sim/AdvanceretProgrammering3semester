package lektion9designpatterns.SimpleFactory.opgave06.models;

import lektion9designpatterns.SimpleFactory.opgave06.models.pizza.Pizza;

// Factory Method: Pizzaria er nu abstrakt.
// orderPizza() er template method — den definerer HVAD der sker (prepare, bake, cut, box).
// createPizza() er factory method — subklasser bestemmer HVILKEN pizza der laves.
// Stilvalget (NY/Chicago) er ikke en parameter længere — det er indkapslet i subklassen.
public abstract class Pizzaria {

    // Template method: algoritmen er fast, men pizza-oprettelsen delegeres nedad
    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    // Factory method: abstrakt — subklassen bestemmer hvilken konkret pizza der returneres
    protected abstract Pizza createPizza(String type);
}
