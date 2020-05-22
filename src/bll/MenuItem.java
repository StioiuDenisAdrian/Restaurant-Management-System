package bll;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    protected String name;
    protected double price;

    public MenuItem(String name, double price){
        this.name=name;
        this.price=price;
    }

    public abstract double computePrice();

    public abstract String ingredients();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
