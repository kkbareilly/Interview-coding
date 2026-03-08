package designpattern.solid.singleresponsibility;

import java.util.HashMap;
import java.util.Map;

public class AccountOperations {

    Map<String,Account>accountMap=new HashMap<>();
    public void addAccount(Account ac){
        accountMap.put(ac.getAccountNumber(),ac);

    }
    public void update(Account ac){
        accountMap.put(ac.getAccountNumber(),ac);

    }
    public Account getAccount(Account ac){
      return   accountMap.get(ac.getAccountNumber());

    }
}
