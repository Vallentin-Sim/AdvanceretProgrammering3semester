package lektion9designpatterns.Decorator.DecoratorSubClass.dsubclasses;

import lektion9designpatterns.Decorator.DecoratorSubClass.Decorator;
import lektion9designpatterns.Decorator.SuperCar;

public class Metallak extends Decorator {

    public Metallak(SuperCar wrappedCar) {
        super(wrappedCar);
    }

    @Override
    public double cost() {
        return super.cost() + 5000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Metallak";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
