package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Schritt 1: Teig auswählen
        double doughCost = chooseDough(scanner);
        System.out.println("Kosten für Teig: " + doughCost + "€");

        // Schritt 2: Soße auswählen
        double sauceCost = chooseSauce(scanner, doughCost);
        System.out.println("Kosten für Soße: " + sauceCost + "€");

        // Schritt 3: Belag auswählen
        double toppingCost = chooseBelag(scanner);
        System.out.println("Kosten für Belag: " + toppingCost + "€");

        // Schritt 4: Toppings auswählen
        double toppingsCost = chooseBelag(scanner);
        System.out.println("Kosten für Toppings: " + toppingsCost + "€");

        // Gesamtkosten berechnen
        double totalCost = doughCost + sauceCost + toppingCost + toppingsCost;
        System.out.println("Gesamtkosten: " + totalCost + "€");

        scanner.close();
    }

    private static double chooseDough(Scanner scanner) {
        System.out.println("Wähle den Teig:");
        System.out.println("1. Weißmehl (2€)");
        System.out.println("2. Vollkorn (30%) (+0,50€)");
        System.out.println("3. Vollkorn (80%) (+1,00€)");
        System.out.println("4. Glutenfrei (+1,50€)");

        int choice = scanner.nextInt();
        double cost = 0;

        switch (choice) {
            case 1:
                cost = 2;
                break;
            case 2:
                cost = 2.50;
                break;
            case 3:
                cost = 3;
                break;
            case 4:
                cost = 3.50;
                break;
            default:
                System.out.println("Ungültige Auswahl. Standardteig wird gewählt (2€).");
        }

        return cost;
    }

    private static double chooseSauce(Scanner scanner, double doughCost) {
        System.out.println("Wähle die Soße:");
        System.out.println("1. Keine Soße (0€)");
        System.out.println("2. Tomatensouße (1€)");
        System.out.println("3. Weiße Soße (1,50€)");

        int choice = scanner.nextInt();
        double cost = 0;

        switch (choice) {
            case 1:
                cost = 0;
                break;
            case 2:
                cost = 1;
                break;
            case 3:
                // Überprüfen, ob glutenfreier Teig gewählt wurde
                if (doughCost == 3.50) {
                    System.out.println("Ungültige Auswahl. Weiße Soße kann nicht mit glutenfreiem Teig kombiniert werden.");
                    cost = 0;
                } else {
                    cost = 1.50;
                }
                break;
            default:
                System.out.println("Ungültige Auswahl. Keine Soße wird gewählt (0€).");
        }

        return cost;
    }

    private static double chooseBelag(Scanner scanner) {
        System.out.println("Wähle den Belag (Mehrere Beläge durch Eingabe von 0 beenden):");
        System.out.println("1. Salami (1€)");
        System.out.println("2. Pilze (1€)");
        System.out.println("3. Schinken (1€)");
        System.out.println("4. Spinat (2€)");
        System.out.println("5. Artischocken (2€)");
        System.out.println("6. Lachs (3€)");
        System.out.println("7. Döner (3€)");
        System.out.println("8. Knoblauch (0,50€)");

        List<Double> costs = new ArrayList<>();

        int choice;
        do {
            System.out.println("Wähle eine Option oder gebe 0 ein, um die Auswahl zu beenden:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    costs.add(1.0);
                    break;
                case 4:
                case 5:
                    costs.add(2.0);
                    break;
                case 6:
                case 7:
                    costs.add(3.0);
                    break;
                case 8:
                    costs.add(0.50);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Ignoriere und fahre fort.");
            }
        } while (choice != 0);

        return costs.stream().mapToDouble(Double::doubleValue).sum();
    }
}
