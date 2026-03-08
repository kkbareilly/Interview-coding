package designpattern.structural.decorator;

public class Mozzarala extends ToppingDecorator{

    Mozzarala(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+"Mozzarala";
    }

    @Override
    public double getCost() {
        return pizza.getCost()+.5;
    }
}
