package model.services.dao;

import model.Entities.impl.LogLend;

public interface ILogLendDao {
    void insert(LogLend logLend);

    void update(LogLend logLend);

    LogLend findById(Integer id);

    void DeleteById(Integer id);


}
