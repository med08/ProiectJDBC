package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexandru.Dinca on 7/8/2016.
 */
public class EntityManagerImpl implements EntityManager {



    Connection conn = null;

    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        conn = DBManager.getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return null;
    }

    @Override
    public void getNextIdVal(String tableName, String columnIdName) {

        conn = DBManager.getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
    }

    @Override
    public <T> Object insert(T entity) {
        conn = DBManager.getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        conn = DBManager.getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return null;
    }
}
