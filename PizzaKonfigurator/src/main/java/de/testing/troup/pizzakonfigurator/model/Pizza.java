package de.testing.troup.pizzakonfigurator.model;

import java.util.List;

public class Pizza {
    private Teig dough;
    private Sauce sauce;
    private List<Topping> toppings;
    private Topping cheeseTopping;

    // Konstruktor, Getter und Setter

    public Teig getDough() {
        return dough;
    }

    public void setDough(Teig dough) {
        this.dough = dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Topping getCheeseTopping() {
        return cheeseTopping;
    }

    public void setCheeseTopping(Topping cheeseTopping) {
        this.cheeseTopping = cheeseTopping;
    }
}