import model.Entities.impl.Account;
import model.Entities.impl.OperationsAccount;
import model.services.dao.impl.AccountJDBC;
import model.services.database.DB;
import java.sql.Connection;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException {
        Connection pg = DB.getConnection();
        AccountJDBC accountJDBC = new AccountJDBC(pg);

        Account acc1 = accountJDBC.findById(105);
        Account acc2 = accountJDBC.findById(106);
        Account acc3 = accountJDBC.findById(107);
        Account acc4 = accountJDBC.findById(108);

//        Account acc1 = new Account("Joao","9001002345",2000.0);
//        Account acc2 = new Account("Maria","1258976435",500.0);
//        Account acc3 = new Account("Joaquim","3125897643",1500.0);
//        Account acc4 = new Account("Helena","2548976435",1500.0);
//
//        accountJDBC.insert(acc1);
//        accountJDBC.insert(acc2);
//        accountJDBC.insert(acc3);
//        accountJDBC.insert(acc4);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println(acc4);
        System.out.println("\n#####################################################################\n");


        OperationsAccount.transfer(accountJDBC, acc1, acc2, 10.0);
        OperationsAccount.transfer(accountJDBC, acc3, acc4, 20.0);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println(acc4);

        System.out.println("\n#####################################################################\n");
        OperationsAccount.lend(acc4,500.0,0.05,12,"pendente","simple");

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println(acc4);



    }
}
