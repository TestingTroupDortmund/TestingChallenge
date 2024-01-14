import PizzaComponents.Dough;
import PizzaComponents.MainTopping;
import PizzaComponents.Sauce;
import PizzaComponents.SubTopping;

import java.util.ArrayList;
import java.util.List;

public class PizzaConfiguration {
    private Dough dough;

    private List<MainTopping> mainTopping = new ArrayList<>();

    private Sauce sauce;

    private SubTopping subTopping;

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<MainTopping> getMainTopping() {
        return mainTopping;
    }

    public void setMainTopping(List<MainTopping> mainTopping) {
        this.mainTopping = mainTopping;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public SubTopping getSubTopping() {
        return subTopping;
    }

    public void setSubTopping(SubTopping subTopping) {
        this.subTopping = subTopping;
    }

}
