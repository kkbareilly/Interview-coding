package designpattern.behavioral.visitor;

public class Necessity implements  Visitable{

    public double getPrice(){
        return 10.5;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
