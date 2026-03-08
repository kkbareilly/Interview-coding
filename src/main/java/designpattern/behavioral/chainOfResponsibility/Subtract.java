package designpattern.behavioral.chainOfResponsibility;

public class Subtract implements Chain {
    private Chain nextChain;
    @Override
    public void setNextChain(Chain chain) {
        this.nextChain=chain;
    }

    @Override
    public void calculate(Number request) {
        if(request.getCalculationWanted()=="Sub") {
            System.out.println("Subtract=" +(request.getNum1()-request.getNum2()));

        }else {
            nextChain.calculate(request);
        }
    }
}
