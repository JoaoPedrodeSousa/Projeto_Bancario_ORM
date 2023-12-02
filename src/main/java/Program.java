import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("project-bank");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.close();
        emf.close();
    }
}
