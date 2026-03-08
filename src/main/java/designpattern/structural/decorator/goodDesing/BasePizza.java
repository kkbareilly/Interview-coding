package designpattern.structural.decorator.goodDesing;

public class BasePizza implements Pizza{
    @Override
    public String bake() {
        return "base";
    }
}
