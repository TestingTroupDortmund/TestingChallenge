public class PizzaOrder implements InvoiceSupport{

    private PizzaConfiguration pizzaConfiguration;

    private double amount = 0;

    public PizzaOrder(PizzaConfiguration pizzaConfiguration){
        this.pizzaConfiguration = pizzaConfiguration;
    }

    @Override
    public double getAmount() {
        //TODO: put your KI-Generated Code here
        return this.amount;
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
