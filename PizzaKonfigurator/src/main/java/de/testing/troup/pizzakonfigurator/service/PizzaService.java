package de.testing.troup.pizzakonfigurator.service;


import de.testing.troup.pizzakonfigurator.model.Pizza;
import de.testing.troup.pizzakonfigurator.model.Topping;
import de.testing.troup.pizzakonfigurator.model.Teig;

import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    public double calculatePrice(Pizza pizza) {
        double totalPrice = 0.0;

        // Teigpreis
        switch (pizza.getDough()) {
            case WHITE:
                totalPrice += 2.0;
                break;
            case WHOLE_GRAIN_30:
                totalPrice += 2.5;
                break;
            case WHOLE_GRAIN_60:
                totalPrice += 3.0;
                break;
            case GLUTEN_FREE:
                totalPrice += 3.5;
                break;
        }

        // Soßenpreis
        switch (pizza.getSauce()) {
            case TOMATO:
                totalPrice += 1.0;
                break;
            case CREME_FRAICHE:
                totalPrice += 1.5;
                break;
            case NONE:
                // Kein zusätzlicher Preis für keine Soße
                break;
        }

        // Belägepreis
        for (Topping topping : pizza.getToppings()) {
            switch (topping) {
                case SALAMI:
                case MUSHROOM:
                case HAM:
                    totalPrice += 1.0;
                    break;
                case SPINACH:
                case ARTICHOKE:
                    totalPrice += 2.0;
                    break;
                case SALMON:
                case DONER:
                    totalPrice += 3.0;
                    break;
                case GARLIC:
                    totalPrice += 0.5;
                    break;
            }
        }

        // Käsepreis
        if (pizza.getCheeseTopping() != null) {
            totalPrice += 1.0;
        }

        return totalPrice;
    }
}
