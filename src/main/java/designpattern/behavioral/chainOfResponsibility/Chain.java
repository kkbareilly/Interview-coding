package designpattern.behavioral.chainOfResponsibility;

public interface Chain {
    public void setNextChain(Chain chain);
    public void calculate(Number number);
}
