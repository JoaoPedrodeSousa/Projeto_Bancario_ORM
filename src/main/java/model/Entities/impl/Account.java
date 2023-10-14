package model.Entities.impl;


import model.Entities.IOperationsAccount;

import java.io.Serializable;
import java.util.Objects;

public class Account implements IOperationsAccount, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id = null;
    private String owner;
    private final String register;
    private Double balance = 0.0;

    public Account(String owner, String register) {
        this.owner = owner;
        if(register.length() != 10){
            throw new RuntimeException();
        }

        else {
            this.register = register;
        }
    }

    public Account(Integer id, String owner, String register) {
        this.id = id;
        this.owner = owner;

        if(register.length() != 10){
            throw new RuntimeException();
        }

        else {
            this.register = register;
        }
    }

    public Account(String owner, String register, Double balance) {
        this.owner = owner;
        this.balance = balance;

        if(register.length() != 10){
            throw new RuntimeException();
        }
        else {
            this.register = register;
        }
    }

    public Account(Integer id, String owner, String register, Double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;

        if(register.length() != 10){
            throw new RuntimeException();
        }
        else {
            this.register = register;
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegister() {
        return register;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(Double value) {
        balance -= value;
    }

    @Override
    public void deposit(Double value) {
        balance += value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getOwner(), account.getOwner()) && Objects.equals(getRegister(), account.getRegister()) && Objects.equals(getBalance(), account.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOwner(), getRegister(), getBalance());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", register='" + register + '\'' +
                ", balance=" + balance +
                '}';
    }
}
