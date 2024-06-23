package LibrarayManagement.com;

import java.sql.*;

public class DB_Conection {
    private static final String url="jdbc:mysql://localhost:3306/library";
    private static final String username ="root";
    private static final String password ="John1045@";
     public static Connection getConnection()throws Exception{
         return DriverManager.getConnection(url,username,password);
     }
}
