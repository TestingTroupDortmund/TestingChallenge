
import java.util.List;

public class PizzaOrder implements InvoiceSupport {

    private PizzaConfiguration pizzaConfiguration;

    private double amount = 0;

    public PizzaOrder(PizzaConfiguration pizzaConfiguration) {
        this.pizzaConfiguration = pizzaConfiguration;
    }

    @Override
    public double getAmount() {
        calculateDoughCost();
        calculateSauceCost();
        calculateMainToppingCost();
        calculateSubToppingCost();
        return amount;
    }

    private void calculateDoughCost() {
        Dough dough = pizzaConfiguration.getDough();
        switch (dough) {
            case WHITE:
                amount += 2;
                break;
            case WHOLE_GRAIN_30:
                amount += 2.5;
                break;
            case WHOLE_GRAIN_80:
                amount += 3;
                break;
            case GLUTEN_FREE:
                amount += 3.5;
                break;
        }
    }

private void calculateSauceCost() {
    Sauce sauce = pizzaConfiguration.getSauce();
    Dough dough = pizzaConfiguration.getDough();

    switch (sauce) {
        case NONE:
            amount += 0;
            break;
        case TOMATO:
            amount += 1;
            break;
        case CREME_FRAICHE:
            // Check if the dough is gluten-free and the sauce is "Weiße Sauce"
            if (dough == Dough.GLUTEN_FREE) {
                System.out.println("Error: Gluten-free dough cannot be combined with Weiße Sauce.");
                // You might want to handle this error case differently, e.g., throw an exception.
            } else {
                amount += 1.5;
            }
            break;
    }
}

    private void calculateMainToppingCost() {
        List<MainTopping> mainToppings = pizzaConfiguration.getMainTopping();
        for (MainTopping topping : mainToppings) {
            switch (topping) {
                case SALAMI:
                case MUSHROOM:
                case HAM:
                    amount += 1;
                    break;
                case SPINACH:
                case ARTICHOKE:
                    amount += 2;
                    break;
                case LACHS:
                case DONER:
                    amount += 3;
                    break;
                case GARLIC:
                    amount += 0.5;
                    break;
            }
        }
    }

    private void calculateSubToppingCost() {
        SubTopping subTopping = pizzaConfiguration.getSubTopping();
        switch (subTopping) {
            case NONE:
                amount += 0;
                break;
            case GOUDA:
                amount += 1;
                break;
            case MOZZARELLA:
                amount += 1.5;
                break;
        }
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PizzaConfiguration getPizzaConfiguration() {
        return pizzaConfiguration;
    }

    public void setPizzaConfiguration(PizzaConfiguration pizzaConfiguration) {
        this.pizzaConfiguration = pizzaConfiguration;
    }
}
