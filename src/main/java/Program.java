import model.Entities.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        EntityManager entityManager = emf.createEntityManager();

        Account acc1 = BankingRegister.account(entityManager, new Account(null,"Josue","1234567890",500.0));
        Account acc2 = BankingRegister.account(entityManager, new Account(null,"Julia","1234567821",500.0));
        Account acc3 = BankingRegister.account(entityManager, new Account(null,"Maria","1234567812",500.0));

        BankingOperations.transfer(entityManager, acc1,acc2,250.0);
        BankingOperations.lend(entityManager, acc3,1000.0,0.03,12);
        BankingOperations.investment(entityManager, acc1,"Renda Variavel", 100.0);

        System.out.println(" ----> TUDO OK!!! <----");

        entityManager.close();
        emf.close();
    }
}
