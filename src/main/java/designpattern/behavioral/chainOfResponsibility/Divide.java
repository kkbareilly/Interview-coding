package designpattern.behavioral.chainOfResponsibility;

public class Divide implements Chain {

    private Chain nextChain;
    @Override
    public void setNextChain(Chain chain) {
        this.nextChain=chain;
    }

    @Override
    public void calculate(Number request) {
        if(request.getCalculationWanted()=="Divide") {
            System.out.println("Divide=" +(request.getNum1()/request.getNum2()));
        }else {
System.out.println("Work only till divide");
        }
    }
}
