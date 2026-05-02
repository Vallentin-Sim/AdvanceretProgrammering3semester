package lektion9designpatterns.Decorator.DecoratorSubClass.dsubclasses;

import lektion9designpatterns.Decorator.DecoratorSubClass.Decorator;
import lektion9designpatterns.Decorator.SuperCar;

public class Bakkecensor extends Decorator {

    public Bakkecensor(SuperCar wrappedCar) {
        super(wrappedCar);
    }

    @Override
    public double cost() {
        return super.cost() + 3000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Bakkecensor";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
