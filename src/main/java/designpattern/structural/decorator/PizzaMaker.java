package designpattern.structural.decorator;

public class PizzaMaker {
    public static void main(String[] args) {
        Pizza pizza=new TomatoSouce(new Mozzarala(new PlainPizaa()));

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

    }
}
