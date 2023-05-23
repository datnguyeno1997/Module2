package AnimalAndInterfaceEdible.Animal;

import AnimalAndInterfaceEdible.Edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSounnd() {
        return "Chicken: cluck-cluck";
    }
    public String howToEat() {
        return "could be fried";
    }
}
