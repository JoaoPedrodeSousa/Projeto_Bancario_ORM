package model.services.dao;

import model.Entities.impl.LogInvestiment;

public interface ILogInvestimentDao {
    void insert(LogInvestiment logInvestiment);

    void update(LogInvestiment logInvestiment);
    void deleteById(Integer id);
    LogInvestiment findById(Integer id);
}
