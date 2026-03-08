package designpattern.solid.singleresponsibility;

import java.math.BigInteger;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private String firstname;
    private BigInteger amount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getAccountNumber(), account.getAccountNumber()) && Objects.equals(getFirstname(), account.getFirstname()) && Objects.equals(getAmount(), account.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getFirstname(), getAmount());
    }
}
