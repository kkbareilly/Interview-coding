package designpattern.behavioral.visitor;


public class Liquir  implements Visitable{
    private double price;
    public Liquir(double price){
       this.price=price;
    }
    public double getPrice(){
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
