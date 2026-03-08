package designpattern.behavioral.chainOfResponsibility;

public class Number {

    private int num1;
    private int num2;

    private String calculationWanted;

    Number(int newNumber1,int newNumber2,String calculationWanted){
        this.num1=newNumber1;
        this.num2=newNumber2;
        this.calculationWanted=calculationWanted;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getCalculationWanted() {
        return calculationWanted;
    }
}
