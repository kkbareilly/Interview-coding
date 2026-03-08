package designpattern.structural.decorator.goodDesing;

public class CheeseBurstDecorator extends PizzaDecorator{
    CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }
    public String bake(){
        return pizza.bake()+cheesebusrst();
    }

    public String cheesebusrst(){
        return "cheese";
    }
}
