package designpattern.behavioral.chainOfResponsibility;

public class ChainOFResponsibility {
    public static void main(String[] args) {
        AddNumbers num=new AddNumbers();
        Subtract sub=new Subtract();

        num.setNextChain(sub);
        num.calculate(new Number(1,2,"Sub"));
    }
}
