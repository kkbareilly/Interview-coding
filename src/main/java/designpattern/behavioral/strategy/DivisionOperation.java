package designpattern.behavioral.strategy;

public class DivisionOperation implements Strategy {
    @Override
    public int doOps(int a, int b) {
        return a/b;
    }
}
