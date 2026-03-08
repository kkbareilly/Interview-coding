package designpattern.solid.OpenCLose;

public class Calculator {

    public int calculate(int num1,int num2,Operations operations){
        return operations.perform(num1,num2);
    }
}
