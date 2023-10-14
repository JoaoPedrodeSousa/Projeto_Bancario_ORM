package model.services.dao.impl;

import model.Entities.impl.Log;
import model.Entities.impl.LogLend;
import model.services.dao.ILogLendDao;
import model.services.database.DB;
import model.services.database.DbException;

import java.sql.*;

public class LogLendJDBC implements ILogLendDao {

    private final Connection conn;

    public LogLendJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(LogLend logLend) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO " +
                    "emprestimos(id_conta, valor_emprestimo, taxa_juros, prazo_meses, status, tipo_juros, montante,juros)" +
                    "VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,logLend.getIdAccount());
            st.setDouble(2,logLend.getValue());
            st.setDouble(3,logLend.getInterest());
            st.setDouble(4,logLend.getTerm());
            st.setString(5,logLend.getStatus());
            st.setString(6, logLend.getType());
            st.setDouble(7, logLend.getAmount());
            st.setDouble(8, (logLend.getAmount() - logLend.getValue()));

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();

                if(rs.next()){
                    logLend.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(LogLend logLend) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE emprestimos SET status = ? WHERE id = ? ");

            st.setString(1, logLend.getStatus());
            st.setInt(2, logLend.getId());

            st.executeQuery();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public LogLend findById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("SELECT * FROM emprestimos WHERE id = ?");
            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            if(rs.next()){
                LogLend logLend = new LogLend(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getDouble(9)
                );

                logLend.setId(rs.getInt(1));

                DB.closeResultSet(rs);

                return logLend;

            }


        } catch (SQLException e){
            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
        }

    return null;
    }

    @Override
    public void DeleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM emprestimos WHERE id = ?");
            st.setInt(1,id);
            st.executeUpdate();

        } catch (SQLException e){
            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
        }
    }
}

