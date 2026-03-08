package designpattern.creational.builder;

public class Main {

    public static void main(String[] args){
        Burger burger=new Burger.BurgerBuilder().egg(true).size("232").build();
        Meal meal=new MealDirector(new VegMeanBuilder()).prepareMeal();
    }
}
