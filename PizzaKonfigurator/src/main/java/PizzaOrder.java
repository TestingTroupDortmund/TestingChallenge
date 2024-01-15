import PizzaComponents.Dough;
import PizzaComponents.MainTopping;

public class PizzaOrder implements InvoiceSupport {

    private PizzaConfiguration pizzaConfiguration;

    private double amount = 0;

    public PizzaOrder(PizzaConfiguration pizzaConfiguration) {
        this.pizzaConfiguration = pizzaConfiguration;
    }

    @Override
    public double getAmount() throws Exception {

        double amount = 2.0; // Basispreis für den Teig

        // Kosten für den Teig hinzufügen
        switch (pizzaConfiguration.getDough()) {
            case WHOLE_GRAIN_30:
                amount += 0.5;
                break;
            case WHOLE_GRAIN_80:
                amount += 1.0;
                break;
            case GLUTEN_FREE:
                amount += 1.5;
                break;
            default:
                break;
        }

        // Kosten für die Soße hinzufügen
        switch (pizzaConfiguration.getSauce()) {
            case TOMATO:
                amount += 1.0;
                break;
            case CREME_FRAICHE:
                amount += 1.5;
                break;
            default:
                break;
        }

        // Kosten für den Belag hinzufügen
        for (MainTopping topping : pizzaConfiguration.getMainTopping()) {
            switch (topping) {
                case SALAMI:
                case MUSHROOM:
                case HAM:
                    amount += 1.0;
                    break;
                case SPINACH:
                case ARTICHOKE:
                    amount += 2.0;
                    break;
                case LACHS:
                case DONER:
                    amount += 3.0;
                    break;
                case GARLIC:
                    amount += 0.5;
                    break;
                default:
                    break;
            }
        }

        // Kosten für den Käse hinzufügen
        switch (pizzaConfiguration.getSubTopping()) {
            case GOUDA:
                amount += 1.0;
                break;
            case MOZZARELLA:
                amount += 1.5;
                break;
            default:
                break;
        }

        return amount;

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
