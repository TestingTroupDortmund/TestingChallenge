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
            double totalAmount = 0;

            // Teigpreise
            switch (pizzaConfiguration.getDough()) {
                case WHITE:
                    totalAmount += 2.0;
                    break;
                case WHOLE_GRAIN_30:
                    totalAmount += 2.5;
                    break;
                case WHOLE_GRAIN_80:
                    totalAmount += 3.0;
                    break;
                case GLUTEN_FREE:
                    totalAmount += 3.5;
                    break;
            }

            // Soßenpreise
            switch (pizzaConfiguration.getSauce()) {
                case TOMATO:
                    totalAmount += 1.0;
                    break;
                case CREME_FRAICHE:
                    // Zusätzlicher Preis für weiße Soße bei glutenfreiem Teig
                    if (!(pizzaConfiguration.getDough() == Dough.GLUTEN_FREE)) {
                        totalAmount += 1.5;
                    }else{
                        throw new Exception("Weiße soße gibt es bei glutenfrei nicht!");
                    }
                    break;
                case NONE:
                    // Keine Soße ausgewählt
                    break;
            }

            // Beilagenpreise
            for (MainTopping topping : pizzaConfiguration.getMainTopping()) {
                switch (topping) {
                    case SALAMI:
                    case MUSHROOM:
                    case HAM:
                        totalAmount += 1.0;
                        break;
                    case SPINACH:
                    case ARTICHOKE:
                        totalAmount += 2.0;
                        break;
                    case LACHS:
                    case DONER:
                        totalAmount += 3.0;
                        break;
                    case GARLIC:
                        totalAmount += 0.5;
                        break;
                }
            }

            // SubTopping-Preise
            if (pizzaConfiguration.getSubTopping() != null) {
                switch (pizzaConfiguration.getSubTopping()) {
                    case GOUDA:
                        totalAmount += 1.0;
                        break;
                    case MOZZARELLA:
                        totalAmount += 1.5;
                        break;
                    case NONE:
                        // Kein SubTopping ausgewählt
                        break;
                }
            }
            return totalAmount;
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
