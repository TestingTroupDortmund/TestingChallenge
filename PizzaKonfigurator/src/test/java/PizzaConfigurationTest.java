import PizzaComponents.Dough;
import PizzaComponents.MainTopping;
import PizzaComponents.Sauce;
import PizzaComponents.SubTopping;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PizzaConfigurationTest {

    @Test
    public void testBasePizza() {
        PizzaConfiguration pizzaConfig = new PizzaConfiguration();
        pizzaConfig.setDough(Dough.WHITE);
        pizzaConfig.setSauce(Sauce.TOMATO);
        PizzaOrder pizzaOrder = new PizzaOrder(pizzaConfig);
        assertEquals(3.0, pizzaOrder.getAmount(),0.0);
    }

    @Test
    public void testWholeGrainPizza() {
        PizzaConfiguration pizzaConfig = new PizzaConfiguration();
        pizzaConfig.setDough(Dough.WHOLE_GRAIN_80);
        pizzaConfig.setSauce(Sauce.CREME_FRAICHE);
        pizzaConfig.getMainTopping().add(MainTopping.SALAMI);
        pizzaConfig.getMainTopping().add(MainTopping.MUSHROOM);
        pizzaConfig.getMainTopping().add(MainTopping.SPINACH);
        pizzaConfig.setSubTopping(SubTopping.GOUDA);
        PizzaOrder pizzaOrder = new PizzaOrder(pizzaConfig);
        assertEquals(8.5, pizzaOrder.getAmount(),0.0);
    }

    @Test
    public void testGlutenFreePizza() {
        PizzaConfiguration pizzaConfig = new PizzaConfiguration();
        pizzaConfig.setDough(Dough.GLUTEN_FREE);
        pizzaConfig.setSauce(Sauce.TOMATO);
        pizzaConfig.getMainTopping().add(MainTopping.DONER);
        pizzaConfig.getMainTopping().add(MainTopping.GARLIC);

        PizzaOrder pizzaOrder = new PizzaOrder(pizzaConfig);
        assertEquals(8.0, pizzaOrder.getAmount(),0.0);
    }

    @Test
    public void testDoubleToppings() {
        PizzaConfiguration pizzaConfig = new PizzaConfiguration();
        pizzaConfig.setDough(Dough.WHITE);
        pizzaConfig.setSauce(Sauce.CREME_FRAICHE);
        pizzaConfig.getMainTopping().add(MainTopping.HAM);
        pizzaConfig.getMainTopping().add(MainTopping.HAM);
        pizzaConfig.getMainTopping().add(MainTopping.ARTICHOKE);
        pizzaConfig.getMainTopping().add(MainTopping.GARLIC);
        pizzaConfig.setSubTopping(SubTopping.GOUDA);

        PizzaOrder pizzaOrder = new PizzaOrder(pizzaConfig);
        assertEquals(10.0, pizzaOrder.getAmount(),0.0);
    }

    @Test
    public void testInvalidCombination() {
        PizzaConfiguration pizzaConfig = new PizzaConfiguration();
        pizzaConfig.setDough(Dough.GLUTEN_FREE);
        pizzaConfig.setSauce(Sauce.CREME_FRAICHE);

        PizzaOrder pizzaOrder = new PizzaOrder(pizzaConfig);
        assertEquals(0.0, pizzaOrder.getAmount(),0.0);
    }

    @Test
    public void testMultipleMainToppings() {
        PizzaConfiguration pizzaConfig = new PizzaConfiguration();
        pizzaConfig.setDough(Dough.WHOLE_GRAIN_30);
        pizzaConfig.setSauce(Sauce.TOMATO);
        pizzaConfig.getMainTopping().add(MainTopping.SALAMI);
        pizzaConfig.getMainTopping().add(MainTopping.MUSHROOM);
        pizzaConfig.getMainTopping().add(MainTopping.SPINACH);
        pizzaConfig.getMainTopping().add(MainTopping.ARTICHOKE);
        pizzaConfig.getMainTopping().add(MainTopping.LACHS);
        pizzaConfig.getMainTopping().add(MainTopping.DONER);

        PizzaOrder pizzaOrder = new PizzaOrder(pizzaConfig);
        assertEquals(12.5, pizzaOrder.getAmount(),0.0);
    }

    @Test
    public void testDifferentDoughs() {
        PizzaConfiguration pizzaConfig1 = new PizzaConfiguration();
        pizzaConfig1.setDough(Dough.WHITE);
        pizzaConfig1.setSauce(Sauce.TOMATO);

        PizzaOrder pizzaOrder1 = new PizzaOrder(pizzaConfig1);
        assertEquals(2.0, pizzaOrder1.getAmount(),0.0);

        PizzaConfiguration pizzaConfig2 = new PizzaConfiguration();
        pizzaConfig2.setDough(Dough.WHOLE_GRAIN_30);
        pizzaConfig2.setSauce(Sauce.CREME_FRAICHE);

        PizzaOrder pizzaOrder2 = new PizzaOrder(pizzaConfig2);
        assertEquals(3.0, pizzaOrder2.getAmount(),0.0);

        PizzaConfiguration pizzaConfig3 = new PizzaConfiguration();
        pizzaConfig3.setDough(Dough.WHOLE_GRAIN_80);
        pizzaConfig3.setSauce(Sauce.CREME_FRAICHE);

        PizzaOrder pizzaOrder3 = new PizzaOrder(pizzaConfig3);
        assertEquals(3.5, pizzaOrder3.getAmount(),0.0);

        PizzaConfiguration pizzaConfig4 = new PizzaConfiguration();
        pizzaConfig4.setDough(Dough.GLUTEN_FREE);
        pizzaConfig4.setSauce(Sauce.TOMATO);

        PizzaOrder pizzaOrder4 = new PizzaOrder(pizzaConfig4);
        assertEquals(4.0, pizzaOrder4.getAmount(),0.0);
    }

    @Test
    public void testDifferentSauces() {
        PizzaConfiguration pizzaConfig1 = new PizzaConfiguration();
        pizzaConfig1.setDough(Dough.WHITE);
        pizzaConfig1.setSauce(Sauce.TOMATO);

        PizzaOrder pizzaOrder1 = new PizzaOrder(pizzaConfig1);
        assertEquals(2.0, pizzaOrder1.getAmount(),0.0);

        PizzaConfiguration pizzaConfig2 = new PizzaConfiguration();
        pizzaConfig2.setDough(Dough.WHITE);
        pizzaConfig2.setSauce(Sauce.CREME_FRAICHE);

        PizzaOrder pizzaOrder2 = new PizzaOrder(pizzaConfig2);
        assertEquals(2.5, pizzaOrder2.getAmount(),0.0);

        PizzaConfiguration pizzaConfig3 = new PizzaConfiguration();
        pizzaConfig3.setDough(Dough.WHITE);
        pizzaConfig3.setSauce(Sauce.NONE);

        PizzaOrder pizzaOrder3 = new PizzaOrder(pizzaConfig3);
        assertEquals(2.0, pizzaOrder3.getAmount(),0.0);
    }

    @Test
    public void testDifferentMainToppings() {
        PizzaConfiguration pizzaConfig1 = new PizzaConfiguration();
        pizzaConfig1.setDough(Dough.WHITE);
        pizzaConfig1.setSauce(Sauce.TOMATO);
        pizzaConfig1.getMainTopping().add(MainTopping.SALAMI);

        PizzaOrder pizzaOrder1 = new PizzaOrder(pizzaConfig1);
        assertEquals(3.0, pizzaOrder1.getAmount(),0.0);

        PizzaConfiguration pizzaConfig2 = new PizzaConfiguration();
        pizzaConfig2.setDough(Dough.WHITE);
        pizzaConfig2.setSauce(Sauce.TOMATO);
        pizzaConfig2.getMainTopping().add(MainTopping.MUSHROOM);

        PizzaOrder pizzaOrder2 = new PizzaOrder(pizzaConfig2);
        assertEquals(3.0, pizzaOrder2.getAmount(),0.0);

        PizzaConfiguration pizzaConfig3 = new PizzaConfiguration();
        pizzaConfig3.setDough(Dough.WHITE);
        pizzaConfig3.setSauce(Sauce.TOMATO);
        pizzaConfig3.getMainTopping().add(MainTopping.SPINACH);

        PizzaOrder pizzaOrder3 = new PizzaOrder(pizzaConfig3);
        assertEquals(4.0, pizzaOrder3.getAmount(),0.0);

        PizzaConfiguration pizzaConfig4 = new PizzaConfiguration();
        pizzaConfig4.setDough(Dough.WHITE);
        pizzaConfig4.setSauce(Sauce.TOMATO);
        pizzaConfig4.getMainTopping().add(MainTopping.ARTICHOKE);

        PizzaOrder pizzaOrder4 = new PizzaOrder(pizzaConfig4);
        assertEquals(4.0, pizzaOrder4.getAmount(),0.0);
    }

    @Test
    public void testDifferentSubToppings() {
        PizzaConfiguration pizzaConfig1 = new PizzaConfiguration();
        pizzaConfig1.setDough(Dough.WHITE);
        pizzaConfig1.setSauce(Sauce.TOMATO);
        pizzaConfig1.setSubTopping(SubTopping.GOUDA);

        PizzaOrder pizzaOrder1 = new PizzaOrder(pizzaConfig1);
        assertEquals(3.0, pizzaOrder1.getAmount(),0.0);

        PizzaConfiguration pizzaConfig2 = new PizzaConfiguration();
        pizzaConfig2.setDough(Dough.WHITE);
        pizzaConfig2.setSauce(Sauce.TOMATO);
        pizzaConfig2.setSubTopping(SubTopping.MOZZARELLA);

        PizzaOrder pizzaOrder2 = new PizzaOrder(pizzaConfig2);
        assertEquals(3.0, pizzaOrder2.getAmount(),0.0);

        PizzaConfiguration pizzaConfig3 = new PizzaConfiguration();
        pizzaConfig3.setDough(Dough.WHITE);
        pizzaConfig3.setSauce(Sauce.TOMATO);
        pizzaConfig3.setSubTopping(SubTopping.NONE);

        PizzaOrder pizzaOrder3 = new PizzaOrder(pizzaConfig3);
        assertEquals(2.0, pizzaOrder3.getAmount(),0.0);
    }

    // Weitere Testfälle können hier hinzugefügt werden
}
