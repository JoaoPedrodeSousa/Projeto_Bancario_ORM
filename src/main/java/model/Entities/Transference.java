package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Transference extends Log {
    @Column(name = "id_destiny_Account")
    private Integer idDestinyAccount;

    public Transference(Integer id, String type, Double value, LocalDate date, Integer idOriginAccount, Integer idDestinyAccount) {
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
