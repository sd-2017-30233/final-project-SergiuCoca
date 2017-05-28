package DataAccess;

import Business.Login;

import java.sql.*;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class DatabaseConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Volleyball?autoReconnect=true&useSSL=false";


    static final String USER = "root";
    static final String PASS = "admin";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int login(Login login){
        Connection connection = getConnection();
        PreparedStatement stmt=null;
        int l=0;
        try {
            String query = "SELECT * FROM  Users u where u.username=? AND u.password=?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, login.getTextField().getText());
            stmt.setString(2, login.getTextField_1().getText());
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                if(result.getInt("rank")==0) l=0;
                else if(result.getInt("rank")==1) l=1;
                else if(result.getInt("rank")==2) l=2;
                else login.getLblLogin().setVisible(true);
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return l;
    }
}