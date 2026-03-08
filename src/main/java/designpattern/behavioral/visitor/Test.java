package designpattern.behavioral.visitor;

public class Test {
    public static void main(String[] args) {
        TaxVisitor taxVisitor=new TaxVisitor();
        TaxHoliDayVisitor taxHoliDayVisitor=new TaxHoliDayVisitor();
        Necessity necessity=new Necessity();
       System.out.println(necessity.accept(taxVisitor));
        System.out.println(necessity.accept(taxHoliDayVisitor));

    }
}
