package lektion9designpatterns.Decorator.caractuel;

import lektion9designpatterns.Decorator.SuperCar;

public class Focus extends SuperCar {

    public Focus(String model, double price) {
        super(model, price);
    }

    @Override
    public double cost() {
        return getPrice();
    }

    @Override
    public String getDescription() {
        return "Focus " + getModel() + " - " + getPrice() + " kr";
    }
}
