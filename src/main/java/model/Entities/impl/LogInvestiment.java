package model.Entities.impl;

import java.util.Date;

public class LogInvestiment extends Log{
    public LogInvestiment(Integer id, Integer idAccount, String type, Double value) {
        super(id, type, value);
        setIdAccount(idAccount);
    }

    public LogInvestiment(Integer id, Integer idAccount, String type, Double value, Date date) {
        super(id, type, value, date);
        setIdAccount(idAccount);
    }

}
