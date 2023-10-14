package model.Entities.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogTransactions extends Log {
    private Integer idDestinyAccount;

    public LogTransactions(Integer id, String type, Double value, Integer idOriginAccount, Integer idDestinyAccount) {
        super(id, type, value);

        setIdAccount(idOriginAccount);

        this.idDestinyAccount = idDestinyAccount;
    }

    public LogTransactions(Integer id, String type, Double value, Date date, Integer idOriginAccount, Integer idDestinyAccount) {
        super(id, type, value, date);

        setIdAccount(idOriginAccount);

        this.idDestinyAccount = idDestinyAccount;
    }

    public Integer getIdDestinyAccount() {
        return idDestinyAccount;
    }

    public void setIdDestinyAccount(Integer idDestinyAccount) {
        this.idDestinyAccount = idDestinyAccount;
    }


}
