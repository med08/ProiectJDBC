package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.nio.LongBuffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Alexandru.Dinca on 7/8/2016.
 */
public class EntityManagerImpl implements EntityManager {
    Connection conn = null;


    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        /*
* -	create a connection to DB;
-	get table name, columns and fields by annotations using the methods from EntityUtils class;
-	create a Condition object in which you have to set column name and the value of the id;
-	create a QueryBuilder object  in which you have to set the name of the table, columns, query type and conditions;
-	call createQuery() method from QueryBuilder.java;
-	create a resultSet object using Statement and execute the query obtained above;
-	if the resultSet has any value (resultSet.next()) then:
o	 you have to create an instance of type T;
o	iterate through ColumnInfo list and obtain the field of the instance using getColumnName().
Ex: instance.getClass().getDeclaredField(column.getColumnName());
o	make the field accessible;
o	set the value of the field with the value obtained from resultSet object;
-	return the instance;
* */
        conn = DBManager.getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
//        -	get table name, columns and fields by annotations using the methods from EntityUtils class;
        String tableName=EntityUtils.getTableName(entityClass);
        List<ColumnInfo> infoColoane=EntityUtils.getColumns(entityClass);
        Field fld=EntityUtils.getFieldsByAnnotations(entityClass,);


        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) {

        Connection connection = DBManager.getConnection();
        String max_id = null;

        Statement statement = null;
        String query = "SELECT MAX("+ columnIdName +") AS MAX_ID FROM "+ tableName;

        try {
            statement = connection.createStatement();
            ResultSet RS =  statement.executeQuery(query);

            while (RS.next()) {

                max_id = RS.getString("MAX_ID");
            }

            long result = Long.valueOf(max_id).longValue();

            return result+1;

        } catch (SQLException e ) {
            e.printStackTrace();
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
