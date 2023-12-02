package model.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_account")
    private Integer idAccount;
    private LocalDate date;
    private String type;
    private Double value;

    public Log(Integer id, String type, Double value, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
