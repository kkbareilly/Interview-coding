package designpattern.structural.decorator.goodDesing;

public class PizzaDecorator implements Pizza {

    Pizza pizza;
    PizzaDecorator(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public String bake() {
        return pizza.bake();
    }
}
