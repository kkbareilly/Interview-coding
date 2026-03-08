package designpattern.behavioral.visitor;

public class TaxVisitor implements Visitor {
    @Override
    public double visit(Liquir liquir) {

        return liquir.getPrice()*5;
    }

    @Override
    public double visit(Milk milk) {

        return milk.getPrice()*2;
    }

    @Override
    public double visit(Necessity necessity) {
       return necessity.getPrice()*3;
    }
}
