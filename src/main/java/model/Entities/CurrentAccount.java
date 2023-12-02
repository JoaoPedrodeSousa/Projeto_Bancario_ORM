package model.Entities;

import java.util.Random;

public class CurrentAccount extends Account {
    public CurrentAccount(Integer id, User owner) {
        super(id, owner);
    }


    @Override
    public void deposit(Double value) {
        super.deposit(value);
    }

    @Override
    public void withdraw(Double value) {
        super.withdraw(value);
    }
}
