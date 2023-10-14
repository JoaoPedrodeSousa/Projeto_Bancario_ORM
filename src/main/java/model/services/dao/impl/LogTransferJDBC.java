package model.services.dao.impl;

import model.Entities.impl.Account;
import model.Entities.impl.Log;
import model.Entities.impl.LogTransactions;
import model.services.dao.ILogTransferDao;
import model.services.database.DB;
import model.services.database.DbException;

import java.sql.*;

public class LogTransferJDBC implements ILogTransferDao {

    private Connection conn;
    private Account acc1;
    private Account acc2;

    public LogTransferJDBC(Connection conn, Account acc1, Account acc2) {
        this.conn = conn;
        this.acc1 = acc1;
        this.acc2 = acc2;
    }

    @Override
    public void insert(Log log) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO transacoes(tipo,valor,conta_origem, conta_destino) " +
                                           "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1,log.getType());
            st.setDouble(2, log.getValue());
            st.setInt(3, acc1.getId());
            st.setInt(4, acc2.getId());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();

                if (rs.next()){
                    int id = rs.getInt(1);
                    log.setId(id);
                }
                DB.closeResultSet(rs);
            }
        }

        catch (SQLException e){
            throw new DbException(e.getMessage());
        }

        finally {
            DB.closeStatement(st);
        }
    }
    @Override
    public Log findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM transacoes WHERE id = ?");

            st.setInt(1,id);
            rs = st.executeQuery();

            if (rs.next()){
                Log log = new LogTransactions(rs.getInt(1),rs.getString(2),rs.getDouble(4),rs.getDate(3),rs.getInt(5),rs.getInt(6));
                return log;
            }
            return null;

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
