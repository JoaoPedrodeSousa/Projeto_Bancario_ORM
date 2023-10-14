package model.services.dao;

import model.Entities.impl.Account;

public interface AccountDao {
    void insert(Account obj);
    void update(Account obj);
    void deleteById(Integer id);
    Account findById(Integer id);
}
