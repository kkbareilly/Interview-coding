package designpattern.creational.builder;

public class NonVegMeanBuilder extends  MealBuilder {
    Meal meal;

   public NonVegMeanBuilder(){
        this.meal=new Meal();
    }
    @Override
    public void addBiryani() {
        this.meal.setBiryani("Chicken");
    }

    @Override
    public void addColdDrink() {
       this.meal.setColdDrink("Coke");
    }

    @Override
    public void addBread() {
      this.meal.setBread("ROti");
    }

    @Override
    public void addCurry() {
        this.meal.setCurry("veg Curry");
    }

    @Override
    public Meal build() {
        return meal;
    }
}
