package LibrarayManagement.com;
import java.sql.*;
public class librarayDAO {
    public void bookList()throws Exception{
        String query = "select * from book";
        Connection con = DB_Conection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);//only read so use executeQuery
        while(rs.next()){
            System.out.print("s.no: "+rs.getInt(1));
            System.out.print("    Book Name : "+rs.getString(2));
            System.out.print("    Authour Name : "+rs.getString(3));
            System.out.print("    no.of available Books : "+rs.getInt(4)+"\n");
        }

    }
    public void displayBookInfo() throws Exception{
        String query = "select * from book";
        Connection con = DB_Conection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            System.out.print(" Book Name  : "+rs.getString(2));
            System.out.print("     Authour Name  : "+rs.getString(3)+"\n");
        }
    }
    public String user_Take_Books(String id,String b_Name,String a_Name)throws Exception{
        Connection con = DB_Conection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from book");
        boolean check = false;
        int count_Book = 0;
        while(rs.next()){
           if( rs.getString(2).equals(b_Name) && rs.getString(3).equals(a_Name)){
               check = true;
               count_Book = rs.getInt(4);

               break;
           }
        }
        String qury = "update book set NO_Of_Book= '"+(count_Book-1)+"'where name ='"+b_Name+"' and athour='"+a_Name+"'";
        if(count_Book==0) return "not available this book";
        else if(check) {
            PreparedStatement pre  = con.prepareStatement(qury);
            int row  = pre.executeUpdate();
            if(row==1) return "book available";
        }
        PreparedStatement pst = con.prepareStatement("insert into usertakebook value ('"+id+"','"+b_Name+"','"+a_Name+"')");
       return "";
    }

    public void addNewBooks(String name, String author,int num) throws Exception{
        int pk = countBook()+1;
        String query = "insert into book value("+pk+",'"+name+"','"+author+"',"+num+")";
        Connection con = DB_Conection.getConnection();
        PreparedStatement st = con.prepareStatement(query);
       // int row = st.executeUpdate();
        System.out.println(st.executeUpdate());
    }
    public void removeBook(String name) throws Exception{
        int pk = countBook()+1;
        String query = "delete from book where name ='"+name+"'";
        Connection con = DB_Conection.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        // int row = st.executeUpdate();
        System.out.println(st.executeUpdate());
    }
    public int countBook()throws Exception{
        String query = "select * from book";
        Connection con = DB_Conection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);//only read so use executeQuery
        int count =0;
        while(rs.next()){
            count++;
        }
        return count;
    }
    public int countUser()throws Exception{
        String query = "select * from logIn";
        Connection con = DB_Conection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);//only read so use executeQuery
        int count =0;
        while(rs.next()){
            count++;
        }
        return count;
    }
    public String UserRigister(String name,long mo_number,int count)throws Exception{
        String co = "";
        if(count+1<10) co = "LIB00"+(count+1);
        else if(count+1>9 && count+1<100) co ="LIB0"+(count+1);
        else if(count+1>9) co="LIB"+(count+1);

        boolean trfa = rigisterationCheck(mo_number,co);
        if(trfa){
            return "mobile number already exist";
        }
        String query ="insert into logIn values("+(count+1)+",'"+name+"',"+mo_number+",'"+co+"')";
        Connection con = DB_Conection.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        int rs = st.executeUpdate();
        System.out.println(rs);
        return co;
    }
    public boolean rigisterationCheck(long mo_number,String id)throws Exception{
        String query = "select * from logIn";
        Connection con = DB_Conection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            if(rs.getLong(3) == mo_number && (rs.getString(4)).equals(id)){
                return true;
            }
        }
        return false;
    }
}
