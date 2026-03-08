package designpattern.behavioral.strategy;

public class StrategyApplication {
    public static void main(String[] args){
        Context context=new Context(new AddOperation());
    System.out.println(context.executeStrategy(2,4));
    Context context1 = new Context(new SubtractOperation());
        System.out.println(context1.executeStrategy(2,4));
    Context context2 = new Context(new DivisionOperation());
        System.out.println(context2.executeStrategy(2,4));
    }
}
