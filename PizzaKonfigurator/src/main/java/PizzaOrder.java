import PizzaComponents.Dough;
import PizzaComponents.MainTopping;

public class PizzaOrder implements InvoiceSupport{

    private PizzaConfiguration pizzaConfiguration;

    private double amount = 0;

    public PizzaOrder(PizzaConfiguration pizzaConfiguration){
        this.pizzaConfiguration = pizzaConfiguration;
    }

    @Override
    public double getAmount() throws Exception {
            // TODO hier generierte Methode einfügen
            return 0.0
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public PizzaConfiguration getPizzaConfiguration() {
        return pizzaConfiguration;
    }

    public void setPizzaConfiguration(PizzaConfiguration pizzaConfiguration) {
        this.pizzaConfiguration = pizzaConfiguration;
    }
}
