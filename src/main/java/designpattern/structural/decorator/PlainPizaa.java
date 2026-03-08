package designpattern.structural.decorator;

public class PlainPizaa implements Pizza{
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 10l;
    }
}
