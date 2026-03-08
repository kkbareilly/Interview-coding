package designpattern.behavioral.strategy;

public class SubtractOperation implements Strategy {
    @Override
    public int doOps(int a, int b) {
        return a-b;
    }
}
