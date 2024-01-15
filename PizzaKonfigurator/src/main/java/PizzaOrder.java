public class PizzaOrder implements InvoiceSupport {

    private PizzaConfiguration pizzaConfiguration;
    private double amount = 0;

    public PizzaOrder(PizzaConfiguration pizzaConfiguration) {
        this.pizzaConfiguration = pizzaConfiguration;
    }

    @Override
    public double getAmount() {
        // Hier wird die KI-generierte Logik für die Preisberechnung eingefügt
        // Du kannst die Preise für Dough, MainTopping, Sauce, SubTopping usw. entsprechend berücksichtigen
        double doughPrice = calculateDoughPrice(pizzaConfiguration.getDough());
        double mainToppingPrice = calculateMainToppingPrice(pizzaConfiguration.getMainTopping());
        double saucePrice = calculateSaucePrice(pizzaConfiguration.getSauce());
        double subToppingPrice = calculateSubToppingPrice(pizzaConfiguration.getSubTopping());

        // Gesamtpreis berechnen
        this.amount = doughPrice + mainToppingPrice + saucePrice + subToppingPrice;

        return this.amount;
    }

    // Beispiel für die Berechnung des Preises für Dough
   // Beispiel für die Berechnung des Preises für Dough
private double calculateDoughPrice(Dough dough) {
    double doughPrice = 0;

    switch (dough) {
        case WHITE:
            doughPrice = 2.0;
            break;
        case WHOLE_GRAIN_30:
            doughPrice = 2.0 + 0.5; // Weißmehl + Aufpreis für 30% Vollkorn
            break;
        case WHOLE_GRAIN_80:
            doughPrice = 2.0 + 1.0; // Weißmehl + Aufpreis für 80% Vollkorn
            break;
        case GLUTEN_FREE:
            doughPrice = 1.5; // Festpreis für glutenfrei
            break;
    }

    return doughPrice;
}

// Beispiel für die Berechnung des Preises für Sauce
private double calculateSaucePrice(Sauce sauce, Dough dough) {
    double saucePrice = 0;

    // Überprüfen, ob weiße Soße ausgewählt wurde und der Teig glutenfrei ist
    if (sauce == Sauce.CREME_FRAICHE && dough == Dough.GLUTEN_FREE) {
        System.out.println("Weiße Soße darf nicht mit glutenfreiem Teig gewählt werden. Standardmäßig wird keine Soße verwendet.");
        return saucePrice;
    }

    switch (sauce) {
        case NONE:
            saucePrice = 0.0;
            break;
        case TOMATO:
            saucePrice = 1.0;
            break;
        case CREME_FRAICHE:
            saucePrice = 1.5;
            break;
    }

    return saucePrice;
}
// Beispiel für die Berechnung des Preises für Main Toppings
private double calculateMainToppingPrice(List<MainTopping> mainToppings) {
    double mainToppingPrice = 0;

    // Überprüfen, ob Beläge ausgewählt wurden
    if (mainToppings != null && !mainToppings.isEmpty()) {
        for (MainTopping topping : mainToppings) {
            switch (topping) {
                case SALAMI:
                case MUSHROOM:
                case HAM:
                    mainToppingPrice += 1.0; // Preis für Salami, Pilze und Schinken
                    break;
                case SPINACH:
                case ARTICHOKE:
                    mainToppingPrice += 2.0; // Preis für Spinat und Artischocken
                    break;
                case LACHS:
                case DONER:
                    mainToppingPrice += 3.0; // Preis für Lachs und Döner
                    break;
                case GARLIC:
                    mainToppingPrice += 0.5; // Preis für Knoblauch
                    break;
                // Hier können weitere Beläge hinzugefügt werden
            }
        }
    }

    return mainToppingPrice;
}
// Beispiel für die Berechnung des Preises für Sub Topping
private double calculateSubToppingPrice(SubTopping subTopping) {
    double subToppingPrice = 0;

    // Überprüfen, ob Sub Topping ausgewählt wurde
    if (subTopping != null) {
        switch (subTopping) {
            case MOZZARELLA:
                System.out.print("Möchten Sie Mozzarella als Sub Topping? (ja/nein): ");
                String mozzarellaChoice = scanner.next().toLowerCase();

                if (mozzarellaChoice.equals("ja")) {
                    subToppingPrice = 1.0; // Preis für Mozzarella
                } else {
                    System.out.print("Möchten Sie Gouda als Sub Topping? (ja/nein): ");
                    String goudaChoice = scanner.next().toLowerCase();

                    if (goudaChoice.equals("ja")) {
                        subToppingPrice = 1.0; // Preis für Gouda
                    } else {
                        System.out.println("Kein weiteres Sub Topping ausgewählt.");
                    }
                }
                break;
            case GOUDA:
                System.out.print("Möchten Sie Gouda als Sub Topping? (ja/nein): ");
                String goudaChoice = scanner.next().toLowerCase();

                if (goudaChoice.equals("ja")) {
                    subToppingPrice = 1.0; // Preis für Gouda
                } else {
                    System.out.println("Kein weiteres Sub Topping ausgewählt.");
                }
                break;
            case NONE:
                System.out.println("Kein Sub Topping ausgewählt.");
                break;
        }
    }

    return subToppingPrice;
}

    // Ähnliche Methoden für die Berechnung der Preise für MainTopping, Sauce, SubTopping können erstellt werden.

    // ...

    public PizzaConfiguration getPizzaConfiguration() {
        return pizzaConfiguration;
    }

    public void setPizzaConfiguration(PizzaConfiguration pizzaConfiguration) {
        this.pizzaConfiguration = pizzaConfiguration;
    }
}
