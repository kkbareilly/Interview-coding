package designpattern.behavioral.visitor;

public interface Visitor {
    public double visit(Liquir liquir);
    public double visit(Milk liquir);
    public double visit(Necessity liquir);
}
