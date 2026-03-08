package designpattern.creational.builder;

public abstract class MealBuilder {
public abstract void addBiryani();
public abstract void addColdDrink();
public abstract void addBread();
public abstract void addCurry();

public abstract Meal build();
}
