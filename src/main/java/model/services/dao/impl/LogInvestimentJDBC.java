package model.services.dao.impl;

import model.Entities.impl.LogInvestiment;
import model.services.dao.ILogInvestimentDao;
import model.services.database.DB;
import model.services.database.DbException;

import java.sql.*;

public class LogInvestimentJDBC implements ILogInvestimentDao {

    private final Connection conn;

    private PreparedStatement st = null;


    public LogInvestimentJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(LogInvestiment logInvestiment) {
        try {
            st = conn.prepareStatement(
                    "INSERT INTO investimentos(" +
                    "id_conta, " +
                    "tipo_ativo, " +
                    "valor_investido " +
                    "VALUES( ? , ? , ? )", Statement.RETURN_GENERATED_KEYS
            );

            st.setInt(1,logInvestiment.getIdAccount());
            st.setString(2,logInvestiment.getType());
            st.setDouble(3, logInvestiment.getValue());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    logInvestiment.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }
        }

        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(LogInvestiment logInvestiment) {
        try{
            st = conn.prepareStatement("UPDATE investimentos SET id_conta = ? , SET tipo_ativo = ? , SET valor_investido = ? WHERE id = ?");

            st.setInt(1,logInvestiment.getIdAccount());
            st.setString(2,logInvestiment.getType());
            st.setDouble(3,logInvestiment.getValue());
            st.setInt(4,logInvestiment.getId());

            st.executeUpdate();
        }

        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            st = conn.prepareStatement("DELETE FROM investimentos WHERE id = ?");

            st.setInt(1,id);

            st.executeUpdate();

        }

        catch (SQLException e){
            throw new DbException(e.getMessage());
        }

        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public LogInvestiment findById(Integer id) {
        ResultSet rs;
        try {
            st = conn.prepareStatement("SELECT * FROM investimentos WHERE id = ?");

            st.setInt(1,id);

            rs = st.executeQuery();

            if(rs.next()){
                LogInvestiment logInvestiment =
                        new LogInvestiment(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getDate(5)
                );

                DB.closeResultSet(rs);

                return logInvestiment;
            }
            return null;


        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
        }
    }
}
