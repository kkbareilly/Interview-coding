package designpattern.creational.builder;

public class MealDirector {
    MealBuilder mealBuilder;

    MealDirector(MealBuilder mealBuilder){
        this.mealBuilder=mealBuilder;
    }
    public Meal prepareMeal(){
        this.mealBuilder.addBread();
        this.mealBuilder.addColdDrink();
        this.mealBuilder.addCurry();
        this.mealBuilder.addBread();
        return mealBuilder.build();
    }
}
