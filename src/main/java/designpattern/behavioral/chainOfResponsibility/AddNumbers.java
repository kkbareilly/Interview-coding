package designpattern.behavioral.chainOfResponsibility;

public class AddNumbers implements Chain {


    private Chain nextChain;
    @Override
    public void setNextChain(Chain chain) {
       this.nextChain=chain;
    }

    @Override
    public void calculate(Number request) {
        if(request.getCalculationWanted()=="Add") {
            System.out.println("Addition=" +(request.getNum1()+request.getNum2()));
        }else {
            nextChain.calculate(request);
        }
    }
}
