package designpattern.creational.builder;

public class VegMeanBuilder extends  MealBuilder {
    Meal meal;

   public VegMeanBuilder(){
        this.meal=new Meal();
    }
    @Override
    public void addBiryani() {
        this.meal.setBiryani("Veg");
    }

    @Override
    public void addColdDrink() {
       this.meal.setColdDrink("Coke");
    }

    @Override
    public void addBread() {
      this.meal.setBread("Britaniya");
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
