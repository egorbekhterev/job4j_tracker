package ru.job4j.decorator;

public class Main {
    public static void main(String[] args) {
        Pizza simplePizza = new SimplePizza();
        System.out.println(simplePizza.getCost() + " " + simplePizza.getIngridients());
        Pizza pizzaWithSausages = new PizzaWithSausages(new SimplePizza());
        System.out.println(pizzaWithSausages.getCost() + " " + simplePizza.getIngridients());
        Pizza superPizza =  new PizzaWithMushrooms(new PizzaWithSausages(new SimplePizza()));
        System.out.println(superPizza.getCost() + " " + superPizza.getIngridients());
    }
}
