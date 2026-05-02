package lektion9designpatterns.Decorator.DecoratorSubClass;

import lektion9designpatterns.Decorator.SuperCar;

// Decorator wrapper: holder en reference til den SuperCar den dekorerer.
// cost() og getDescription() delegerer til den inderste bil — subklasser
// kalder super.cost() og super.getDescription() og tilføjer oven på.
public abstract class Decorator extends SuperCar {

    protected SuperCar wrappedCar;

    public Decorator(SuperCar wrappedCar) {
        super(wrappedCar.getModel(), wrappedCar.getPrice());
        this.wrappedCar = wrappedCar;
    }

    @Override
    public double cost() {
        return wrappedCar.cost();
    }

    @Override
    public String getDescription() {
        return wrappedCar.getDescription();
    }
}
