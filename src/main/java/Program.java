import model.Entities.impl.Account;
import model.Entities.impl.BankingRegister;
import model.Entities.impl.Lend;
import model.Entities.impl.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        EntityManager em = emf.createEntityManager();

        Account acc1 = new Account(null,"Josue","1234567890",500.0);
        Account acc2 = new Account(null,"Julia","1234567821",500.0);
        Account acc3 = new Account(null,"Maria","1234567812",500.0);

        DateTimeFormatter dmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fmt = LocalDate.parse(LocalDate.now().toString(),dmt);

        BankingRegister.account(em, acc1);
        BankingRegister.account(em, acc2);


        System.out.println("--- TUDO OK!!!!!!!");

        em.refresh();
        em.close();
        emf.close();
    }
}
