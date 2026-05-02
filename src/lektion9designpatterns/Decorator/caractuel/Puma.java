package lektion9designpatterns.Decorator.caractuel;

import lektion9designpatterns.Decorator.SuperCar;

public class Puma extends SuperCar {

    public Puma(String model, double price) {
        super(model, price);
    }

    @Override
    public double cost() {
        return getPrice();
    }

    @Override
    public String getDescription() {
        return "Puma " + getModel() + " - " + getPrice() + " kr";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
