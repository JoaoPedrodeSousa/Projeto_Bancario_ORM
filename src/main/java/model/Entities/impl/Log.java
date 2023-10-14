package model.Entities.impl;

import model.Entities.ILog;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id = null;
    private Integer idAccount;
    private Date date;
    private String type;
    private Double value;


    public Log(Integer id, String type, Double value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Log(Integer id, String type, Double value, Date date) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log log = (Log) o;
        return Objects.equals(getId(), log.getId()) && Objects.equals(getType(),
                log.getType()) && Objects.equals(getDate(),
                log.getDate()) && Objects.equals(getValue(), log.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getDate(), getValue());
    }

    @Override
    public String toString() {
        return "log{" +
                "id=" + id +
                ", tipo='" + type + '\'' +
                ", date=" + date +
                ", valor=" + value +
                '}';
    }
}
