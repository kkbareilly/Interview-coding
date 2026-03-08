package designpattern.structural.decorator.goodDesing;

public class OrderPizz {
public static void main(String[] args){
    Pizza pizza=new JalepanoDecorator(new CheeseBurstDecorator(new BasePizza()));
    System.out.println(pizza.bake());
}

}
