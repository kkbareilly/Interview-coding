package LeetCode.Leet150.ruleengine;

class BulkBuyLimitParacetalmol extends Rule {

    @Override
    boolean evaluate(Cart cart) {
        int totalQuantity = 0;
        for(Item i: cart.getItems()) {
            if(i.getCategroy() == Categroy.PARACETAMOL)
                totalQuantity += i.getQuantity();
        }
        return totalQuantity <= 5;
    }

}

