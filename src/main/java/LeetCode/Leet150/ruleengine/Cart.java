package LeetCode.Leet150.ruleengine;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Item> items = new ArrayList<>();

    public Cart(List<Item> items) {
        this.items= items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
