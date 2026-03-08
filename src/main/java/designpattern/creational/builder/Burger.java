package designpattern.creational.builder;

public class Burger {

    Burger(BurgerBuilder burgerBuilder){

    }
    private  String size;
    private boolean egg;
    private  boolean extraCheege;
    private boolean onion;
    private  boolean lettuce;

    public String getSize() {
        return size;
    }

    public boolean isEgg() {
        return egg;
    }

    public boolean isExtraCheege() {
        return extraCheege;
    }

    public boolean isOnion() {
        return onion;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public static class BurgerBuilder{
        private  String size;
        private boolean egg;
        private  boolean extraCheege;
        private boolean onion;
        private  boolean lettuce;

        public BurgerBuilder size(String size){
            this.size=size;
            return this;
        }
        public BurgerBuilder egg(boolean egg){
            this.egg=egg;
            return this;
        }
        public BurgerBuilder extraCheege(boolean extraCheege){
            this.extraCheege=extraCheege;
            return this;
        }
        public BurgerBuilder onion(boolean onion){
            this.onion=onion;
            return this;
        }
        public BurgerBuilder lettuce(boolean lettuce){
            this.lettuce=lettuce;
            return this;
        }
        public Burger build(){
            return new Burger(this);
        }
    }

}
