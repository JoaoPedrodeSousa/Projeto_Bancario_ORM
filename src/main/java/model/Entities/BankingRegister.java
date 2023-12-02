package model.Entities.impl;

import javax.persistence.EntityManager;

public class BankingRegister {
    public static Account account(EntityManager entityManager, Account account){
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account;

    }

    public static void transference(EntityManager entityManager, Transference transference){
        entityManager.persist(transference);
    }

    public static void lend(EntityManager entityManager, Lend lend){
        entityManager.persist(lend);
    }

    public static void investment(EntityManager entityManager, Investiment investiment){
        entityManager.persist(investiment);
    }
}

