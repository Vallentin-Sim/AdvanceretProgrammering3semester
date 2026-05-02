package lektion9designpatterns.Decorator.DecoratorSubClass.dsubclasses;

import lektion9designpatterns.Decorator.DecoratorSubClass.Decorator;
import lektion9designpatterns.Decorator.SuperCar;

public class Turbo extends Decorator {

    public Turbo(SuperCar wrappedCar) {
        super(wrappedCar);
    }

    @Override
    public double cost() {
        return super.cost() + 10000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Turbo";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
