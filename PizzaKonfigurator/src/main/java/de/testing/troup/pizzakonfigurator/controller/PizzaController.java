package de.testing.troup.pizzakonfigurator.controller;


import de.testing.troup.pizzakonfigurator.model.Pizza;
import de.testing.troup.pizzakonfigurator.model.Sauce;
import de.testing.troup.pizzakonfigurator.model.Teig;
import de.testing.troup.pizzakonfigurator.model.Topping;
import de.testing.troup.pizzakonfigurator.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/selectIngredients")
    public String selectIngredients(Model model) {
        List<Teig> doughs = Arrays.asList(Teig.values());
        List<Sauce> sauces = Arrays.asList(Sauce.values());
        List<Topping> toppings = Arrays.asList(Topping.values());

        model.addAttribute("pizza", new Pizza());
        model.addAttribute("doughs", doughs);
        model.addAttribute("sauces", sauces);
        model.addAttribute("toppings", toppings);

        return "selectIngredients";
    }

    @PostMapping("/displayConfiguration")
    public String displayConfiguration(@ModelAttribute Pizza pizza, Model model) {
        double totalPrice = pizzaService.calculatePrice(pizza);
        model.addAttribute("pizza", pizza);
        model.addAttribute("totalPrice", totalPrice);

        return "displayConfiguration";
    }

    // Add more endpoints for confirming order, etc.
}
