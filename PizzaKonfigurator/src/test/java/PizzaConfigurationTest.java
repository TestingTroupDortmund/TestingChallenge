import PizzaComponents.Dough;
import PizzaComponents.MainTopping;
import PizzaComponents.Sauce;
import PizzaComponents.SubTopping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PizzaConfigurationTest {

    private final Dough dough;
    private final Sauce sauce;
    private final MainTopping[] mainToppings;
    private final SubTopping subTopping;
    private final double expectedAmount;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { Dough.WHITE, Sauce.TOMATO, new MainTopping[]{MainTopping.SALAMI}, SubTopping.MOZZARELLA, 5.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.MUSHROOM, MainTopping.HAM}, SubTopping.NONE, 6 },
                { Dough.WHITE, Sauce.TOMATO, new MainTopping[]{MainTopping.SALAMI}, SubTopping.MOZZARELLA, 5.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.MUSHROOM, MainTopping.HAM}, SubTopping.NONE, 6.0 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.LACHS, MainTopping.ARTICHOKE, MainTopping.SALAMI}, SubTopping.GOUDA, 11 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.HAM, MainTopping.HAM, MainTopping.MUSHROOM}, SubTopping.NONE, 6.5 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.LACHS}, SubTopping.GOUDA, 8.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.DONER, MainTopping.MUSHROOM, MainTopping.HAM}, SubTopping.MOZZARELLA, 10 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.ARTICHOKE, MainTopping.MUSHROOM, MainTopping.SPINACH}, SubTopping.GOUDA, 10 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM}, SubTopping.MOZZARELLA, 11 },
                { Dough.WHITE, Sauce.TOMATO, new MainTopping[]{MainTopping.SALAMI}, SubTopping.NONE, 4.0 },
                { Dough.WHOLE_GRAIN_30, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.MUSHROOM}, SubTopping.NONE, 5.0 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.LACHS, MainTopping.ARTICHOKE}, SubTopping.GOUDA, 10 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.HAM, MainTopping.MUSHROOM}, SubTopping.NONE, 5.5 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.LACHS}, SubTopping.GOUDA, 8.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.DONER, MainTopping.MUSHROOM, MainTopping.HAM}, SubTopping.MOZZARELLA, 10 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.ARTICHOKE, MainTopping.MUSHROOM, MainTopping.SPINACH}, SubTopping.GOUDA, 10 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM}, SubTopping.MOZZARELLA, 11 },
                { Dough.GLUTEN_FREE, Sauce.NONE, new MainTopping[]{MainTopping.ARTICHOKE, MainTopping.ARTICHOKE}, SubTopping.MOZZARELLA, 9 },
                { Dough.WHITE, Sauce.TOMATO, new MainTopping[]{MainTopping.GARLIC, MainTopping.GARLIC}, SubTopping.NONE, 4.0 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.LACHS, MainTopping.ARTICHOKE, MainTopping.SPINACH}, SubTopping.GOUDA, 12.0 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM}, SubTopping.GOUDA, 10.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.DONER, MainTopping.MUSHROOM, MainTopping.HAM}, SubTopping.MOZZARELLA, 10.0 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.ARTICHOKE, MainTopping.MUSHROOM, MainTopping.SPINACH}, SubTopping.GOUDA, 10.0 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM}, SubTopping.MOZZARELLA, 11.0 },
                { Dough.WHITE, Sauce.TOMATO, new MainTopping[]{MainTopping.SALAMI, MainTopping.MUSHROOM, MainTopping.SPINACH, MainTopping.LACHS}, SubTopping.MOZZARELLA, 11.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.DONER, MainTopping.HAM, MainTopping.GARLIC}, SubTopping.GOUDA, 9.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.ARTICHOKE, MainTopping.SALAMI, MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM}, SubTopping.GOUDA, 13.5 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM, MainTopping.GARLIC}, SubTopping.MOZZARELLA, 11.5 },
                { Dough.WHOLE_GRAIN_30, Sauce.TOMATO, new MainTopping[]{MainTopping.DONER, MainTopping.MUSHROOM, MainTopping.HAM, MainTopping.GARLIC}, SubTopping.GOUDA, 10 },
                { Dough.WHITE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.LACHS, MainTopping.DONER, MainTopping.GARLIC}, SubTopping.GOUDA, 13 },
                { Dough.WHOLE_GRAIN_80, Sauce.TOMATO, new MainTopping[]{MainTopping.SALAMI, MainTopping.MUSHROOM, MainTopping.SPINACH, MainTopping.LACHS, MainTopping.HAM, MainTopping.GARLIC}, SubTopping.MOZZARELLA, 14 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.DONER, MainTopping.SALAMI}, SubTopping.MOZZARELLA, 10.5 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI}, SubTopping.NONE, 7.5 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.DONER}, SubTopping.MOZZARELLA, 8.5 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI}, SubTopping.NONE, 6.5 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI}, SubTopping.MOZZARELLA, 9.5 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI}, SubTopping.NONE, 8.0 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SPINACH, MainTopping.MUSHROOM, MainTopping.LACHS, MainTopping.DONER, MainTopping.GARLIC}, SubTopping.MOZZARELLA, 15.0 },
                { Dough.GLUTEN_FREE, Sauce.CREME_FRAICHE, new MainTopping[]{MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI, MainTopping.SALAMI}, SubTopping.MOZZARELLA, 15.5 }
        });
    }

    public PizzaConfigurationTest(Dough dough, Sauce sauce, MainTopping[] mainToppings, SubTopping subTopping, double expectedAmount) {
        this.dough = dough;
        this.sauce = sauce;
        this.mainToppings = mainToppings;
        this.subTopping = subTopping;
        this.expectedAmount = expectedAmount;
    }

    @Test
    public void testPizzaOrder() throws Exception {
        PizzaConfiguration config = new PizzaConfiguration();
        config.setDough(dough);
        config.setSauce(sauce);
        config.setMainTopping(Arrays.asList(mainToppings));
        config.setSubTopping(subTopping);
        try {
            PizzaOrder order = new PizzaOrder(config);
            assertEquals(expectedAmount, order.getAmount(), 0);
        }catch (Exception e){
            assertEquals(e.getMessage(),"Weiße soße gibt es bei glutenfrei nicht!");
        }
    }
}