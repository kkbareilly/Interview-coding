package LeetCode.Leet150.ruleengine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart(Arrays.asList(new Item(Categroy.PARACETAMOL,1,2),
                new Item(Categroy.ANALGESIC,2,3),
                new Item(Categroy.CHOCLATE,3,8),
                new Item(Categroy.PARACETAMOL,4,3)
        ));

        System.out.println(new RuleEngine().evaluate(cart));

    }

}
