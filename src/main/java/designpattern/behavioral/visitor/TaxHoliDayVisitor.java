package designpattern.behavioral.visitor;

public class TaxHoliDayVisitor implements Visitor {
    @Override
    public double visit(Liquir liquir) {

        return liquir.getPrice()*7;
    }

    @Override
    public double visit(Milk milk) {

        return milk.getPrice()*4;
    }

    @Override
    public double visit(Necessity necessity) {
       return necessity.getPrice()*6;
    }
}
