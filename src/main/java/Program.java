import model.Entities.impl.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        EntityManager em = emf.createEntityManager();

        Account acc1 = new Account(null,"Josue","1234567890",200.0);
        Account acc2 = new Account(null,"Julia","1234567821",340.0);
        Account acc3 = new Account(null,"Maria","1234567812",400.0);

        em.getTransaction().begin();
        em.persist(acc1);
        em.persist(acc2);
        em.persist(acc3);
        em.getTransaction().commit();
        System.out.println("OK");

        em.close();
        emf.close();
    }
}
