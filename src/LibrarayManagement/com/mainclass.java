package LibrarayManagement.com;
import java.sql.*;
import java.util.*;
public class mainclass {
    static librarayDAO ld= new librarayDAO();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)throws Exception{
        deleteBook();

    }
        static void addBook() throws Exception{
        String name  = scanner.nextLine();
        String authour  = scanner.nextLine();
        int noOfBook = scanner.nextInt();
        ld.addNewBooks(name,authour,noOfBook);
    }
    static void deleteBook() throws Exception{
        String name  = scanner.nextLine();
        ld.removeBook(name);
    }
}
