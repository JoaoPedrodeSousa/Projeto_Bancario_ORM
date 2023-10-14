package model.Entities.impl;

import model.Entities.IInterestOperations;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Lend extends Log implements IInterestOperations {
    private Double interest;
    private Integer term;
    private String status;
    private Double amount;

    public Lend(Integer id, Integer idAccount, Double valueLend, Double interest, Integer term, String status, String interestType, LocalDate date){
        super(id, interestType, valueLend, date);

        setIdAccount(idAccount);
        this.interest = interest;
        this.term = term;
        this.status = status;
        this.amount = interestType.equals("simple") ? simpleInterest() : compoundInterest();
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double compoundInterest() {
        setAmount(IInterestOperations.super.compoundInterest(getValue(), term, getInterest()));
        return amount;
    }

    public Double simpleInterest() {
        setAmount(IInterestOperations.super.simpleInterest(getValue(), term, getInterest()));
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lend)) return false;
        if (!super.equals(o)) return false;
        Lend logLend = (Lend) o;
        return Objects.equals(getInterest(), logLend.getInterest()) && Objects.equals(getTerm(), logLend.getTerm()) && Objects.equals(getStatus(), logLend.getStatus()) && Objects.equals(getAmount(), logLend.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInterest(), getTerm(), getStatus(), getAmount());
    }

    @Override
    public String toString() {
        return "LogLend{" +
                "interest=" + interest +
                ", term=" + term +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
