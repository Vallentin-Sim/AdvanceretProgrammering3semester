package lektion9designpatterns.Decorator;

public abstract class SuperCar {
    private String model;
    private double price;

    public SuperCar(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double cost();

    public abstract String getDescription();
}
