package lektion9designpatterns.Decorator.DecoratorSubClass.dsubclasses;

import lektion9designpatterns.Decorator.DecoratorSubClass.Decorator;
import lektion9designpatterns.Decorator.SuperCar;

public class Laederbetraek extends Decorator {

    public Laederbetraek(SuperCar wrappedCar) {
        super(wrappedCar);
    }

    @Override
    public double cost() {
        return super.cost() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Laederbetraek";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
