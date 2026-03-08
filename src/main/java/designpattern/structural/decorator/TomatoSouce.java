package designpattern.structural.decorator;

public class TomatoSouce extends ToppingDecorator{

    TomatoSouce(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" Tomato Souce";
    }

    @Override
    public double getCost() {
        return pizza.getCost()+.35;
    }
}