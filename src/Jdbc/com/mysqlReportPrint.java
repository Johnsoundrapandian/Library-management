package Jdbc.com;
import java.sql.*;
public class mysqlReportPrint{
    public static void main(String[] args)throws Exception{
        updateDelete();
    }
    public static void querryPrint()throws Exception{
        String url = "jdbc:mysql://localhost:3306/pandi";
        String username="root";
        String password="John1045@";
        String query="select * from employee";
        System.out.println(url);
        Connection con = DriverManager.getConnection(url,username,password);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, username, password);
//        }catch (Exception ex) {
//            System.out.println("Hello");
//            ex.printStackTrace();
//        }
//        System.out.println(con);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        for(int i=0;i<4;i++) {
            rs.next();
            System.out.print(rs.getString(1)+" ");
            System.out.print(rs.getString(2)+" ");
            System.out.print(rs.getString(3)+" ");
            System.out.print(rs.getLong(4)+" \n");
        }
        con.close();

    }
    public static void querryUpdate()throws Exception{
        String url = "jdbc:mysql://localhost:3306/pandi";
        String username="root";
        String password="John1045@";
        String querry="insert into employee(id,name,salary) value(10,'ananthi',20000)";
        Connection con=DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        int rs= st.executeUpdate(querry);
        System.out.println(rs);
        con.close();
    }
    public static void preparedstatement()throws Exception{
        String url="jdbc:mysql://localhost:3306/pandi";
        String username= "root";
        String password="John1045@";
        int id = 11;
        String name ="moorthy";
        int salary = 25000;
        String querry="insert into employee(id,name,salary) value(?,?,?)";
        Connection con =DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(querry);
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setInt(3,salary);
        int row=pst.executeUpdate();
        System.out.println(row);
    }
    public static void callablestatement()throws Exception{
        String url="jdbc:mysql://localhost:3306/pandi";
        String username= "root";
        String password="John1045@";
          int id = 6;
//        String name ="moorthy";
//        int salary = 25000;
//        String querry="insert into employee(id,name,salary) value(?,?,?)";
        Connection con =DriverManager.getConnection(url,username,password);
        CallableStatement cst = con.prepareCall("{call GetEmpDetails(?,?)}");
        cst.setInt(1,id);
        cst.registerOutParameter(2,Types.VARCHAR);
//        cst.setString(2,name);
//        cst.setInt(3,salary);
        //ResultSet rs =cst.executeQuery();
        cst.executeUpdate();
        System.out.println(cst.getString(2));
//            while(rs.next()){
//                System.out.println(rs.getInt(1));
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getString(3));
//                System.out.println(rs.getInt(4));
//            }


    }
    public static void updateDelete()throws Exception{
        String url ="jdbc:mysql://localhost:3306/pandi";
        String username="root";
        String password="John1045@";//commit vs auto comit
        String querry1 ="update employee set salary=39000 where id = 4";
        String querry2 ="update employee set salary=42000 where id = 5";
        String querry3 ="update employee set salary=44000 where id = 6";
        String querry4 ="update employee set salary=43000 where id = 8";
        Connection con = DriverManager.getConnection(url,username,password);
        con.setAutoCommit(false);
        Statement pst = con.createStatement();
        pst.addBatch(querry1);
        pst.addBatch(querry2);
        pst.addBatch(querry3);
        pst.addBatch(querry4);
        int[] row = pst.executeBatch();
        //System.out.println(row);
//        int row1 = pst.executeUpdate(querry2);
//        System.out.println(row1);
        for(int i : row){
            if(i>0) continue;
            else con.rollback();

//        if(row1>0 && row>0){
//            con.commit();
        }
        con.commit();
        con.close();
    }
}
