package LeetCode.Leet150.ruleengine;

import java.util.Arrays;
import java.util.List;

class RuleEngine extends Rule {

    private List<Rule> rules = Arrays.asList(new BulkBuyLimitParacetalmol(), new BulkBuyLimitRule());

    @Override
    boolean evaluate(Cart cart) {
        boolean res = true;
        for(Rule r: rules) {
            res = res && r.evaluate(cart);
        }
        return res;
    }

}
