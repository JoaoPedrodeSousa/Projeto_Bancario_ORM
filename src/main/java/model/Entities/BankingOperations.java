package model.Entities.impl;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class BankingOperations {
    public static void transfer(EntityManager entityManager, Account acc1, Account acc2, Double value){
        Transference transference = new Transference(null,"Transferencia",value, LocalDate.now(),acc1.getId(), acc2.getId());

        entityManager.getTransaction().begin();

        acc1.withdraw(value);
        acc2.deposit(value);

        BankingRegister.transference(entityManager, transference);

        entityManager.getTransaction().commit();
    }

    public static void lend(EntityManager entityManager, Account account, Double value, Double interest, Integer term){
        Lend lend = new Lend(null,account.getId(),value,interest,term,"simple",LocalDate.now());

        entityManager.getTransaction().begin();

        account.deposit(value);
        BankingRegister.lend(entityManager, lend);

        entityManager.getTransaction().commit();
    }

    public static void investment(EntityManager entityManager, Account account, String type, Double value){
        Investiment investiment = new Investiment(null,account.getId(),type,value, LocalDate.now());

        entityManager.getTransaction().begin();

        account.withdraw(value);
        BankingRegister.investment(entityManager, investiment);

        entityManager.getTransaction().commit();
    }
}
