package model.Entities.impl;

import javax.persistence.EntityManager;

public class BankingRegister {
    public static void account(EntityManager entityManager, Account account){
        entityManager.getTransaction().begin();

        entityManager.persist(account);
        entityManager.getTransaction().commit();

    }

    public static void transference(EntityManager entityManager, Transference transference){
        entityManager.persist(transference);
    }

    public static void lend(EntityManager entityManager, Lend lend){
        entityManager.getTransaction().begin();

        entityManager.persist(lend);
        entityManager.getTransaction().commit();

    }

    public static void investiment(EntityManager entityManager, Investiment investiment){
        entityManager.getTransaction().begin();

        entityManager.persist(investiment);
        entityManager.getTransaction().commit();

    }
}

