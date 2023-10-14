package model.services.dao;

import model.Entities.impl.Log;

public interface ILogTransferDao {
    void insert(Log log);
    Log findById(Integer id);

}
