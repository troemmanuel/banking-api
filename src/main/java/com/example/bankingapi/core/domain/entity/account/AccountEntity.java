package com.example.bankingapi.core.domain.entity.account;

import java.util.UUID;

public class AccountEntity {
    final private UUID _id;
    final protected AccountEntityProps props;

    AccountEntity(UUID id, AccountEntityProps props) {
        this._id = id;
        this.props = props;
    }

    void validate() {
        // if (!this._id.getClass().getName().equals("UUID") ) throw new IllegalArgumentException();
    }

    public UUID getId() {
        return this._id;
    }

    public Integer getBalance() {
        return this.props.getBalance();
    }

    public Boolean getIsActive() {
        return this.props.getIsActive();
    }

    public String getType() {
        return this.props.getType();
    }

    public static AccountEntity createAccount(UUID id, AccountEntityProps accountEntityProps){
     return new AccountEntity(id, accountEntityProps);
    }

    public void addMoney(Integer amount) {
        final Integer balance = this.props.getBalance();
        final Integer newBalance = balance + amount;
        this.props.setBalance(amount);
    }

    public void withdrawMoney(Integer amount) {
        final Integer balance = this.props.getBalance();
        if (balance < amount) {
            throw new RuntimeException("Balance cannot be lesser than amount to withdraw");
        }
        final Integer newBalance = balance - amount;
        this.props.setBalance(amount);
    }

}
