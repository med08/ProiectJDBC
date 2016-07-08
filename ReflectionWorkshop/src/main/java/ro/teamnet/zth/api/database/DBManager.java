package ro.teamnet.zth.api.database;

import java.sql.*;

public class DBManager {

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;

    private DBManager() throws UnsupportedOperationException{
    }

    private static void registerDriver(){
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        registerDriver();
        try {
            return DriverManager.getConnection(CONNECTION_STRING,DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void checkConnection(Connection connection){
        Connection conn = getConnection();
        try{
            Statement st = conn.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        String SQL = "select ? from dual";
        try{
            PreparedStatement pst = conn.prepareStatement(SQL);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
