package LeetCode.Leet150.ruleengine;

import java.util.HashMap;

class BulkBuyLimitRule extends  Rule {

    @Override
    boolean evaluate(Cart cart) {
        HashMap<Categroy,Integer> map = new HashMap<>();
        cart.getItems().forEach(item -> {
            map.put(item.getCategroy(), map.getOrDefault(item.getCategroy(), 0)+item.getQuantity());
        });

        boolean res = true;
        System.out.println(map.toString());
        for(Categroy c: map.keySet()) {
            res  = res && (map.get(c) <= 10);
        }

        return res;
    }

}