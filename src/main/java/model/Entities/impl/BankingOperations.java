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
    public static void lend(EntityManager entityManager){
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

    }
    public static void investiment(EntityManager entityManager){
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

    };
}
