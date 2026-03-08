package designpattern.behavioral.strategy;

public class AddOperation implements Strategy {
    @Override
    public int doOps(int a, int b) {
        return a+b;
    }
}
