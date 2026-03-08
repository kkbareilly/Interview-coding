package designpattern.behavioral.visitor;

public class Milk  implements  Visitable{
    public double getPrice(){
         return 2.4 ;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
