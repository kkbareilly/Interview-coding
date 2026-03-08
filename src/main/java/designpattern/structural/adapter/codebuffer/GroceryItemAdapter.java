package designpattern.structural.adapter.codebuffer;

public class GroceryItemAdapter implements Item {

   GroceryItem item;

    GroceryItemAdapter(GroceryItem item){
        this.item=item;
    }
    @Override
    public String getItemName() {
        return item.getItemName();
    }

    @Override
    public String getPrice() {
        return item.getPrice();
    }

    @Override
    public String getRestaurant() {
        return item.getStoreName();
    }
}
