package model.Entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Investiment extends Log{
    public Investiment(Integer id, Integer idAccount, String type, Double value, LocalDate date) {
        super(id, type, value, date);
        setIdAccount(idAccount);
    }

}
