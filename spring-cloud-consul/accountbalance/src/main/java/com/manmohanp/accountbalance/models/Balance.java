package com.manmohanp.accountbalance.models;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Balance {
    @NotNull(message="Account Id is mandatory")
    String accountId;
    @NotNull(message="Balance is mandatory")
    Double balance;
    @NotNull(message="Date is mandatory")
    Date onDate;
    List<Offer> offers;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", onDate=" + onDate +
                ", offers=" + offers +
                '}';
    }
}
