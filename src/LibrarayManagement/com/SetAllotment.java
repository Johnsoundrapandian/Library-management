package LibrarayManagement.com;

import java.util.ArrayList;
import java.util.Scanner;

public class SetAllotment {
    static Scanner scanner = new Scanner(System.in);
    static Library b = new Library();
    static librarayDAO u = new librarayDAO();

    public static void main(String[] args) throws Exception {
        u.bookList();
        rigister();
    }
    static void rigister()throws Exception{
        boolean flag = true;
        String id = "";
        do {
            System.out.println("1) rigister");
            System.out.println("2) LogIn");
            int scan = scanner.nextInt();
            flag = false;
            switch (scan) {
                case 1:
                    String mty = scanner.nextLine();
                    System.out.print("Enter the User name : ");
                    String name = scanner.nextLine();
                    long mo_number;
                    do {
                        flag = false;
                        System.out.print("Enter User Mobile number : ");
                        mo_number = scanner.nextLong();
                        if (mo_number < 100000000L && mo_number > 9999999999L) {
                            flag = true;
                        } else flag = false;
                    } while (flag);
                    int count = u.countUser();
                    String lib_Id = u.UserRigister(name, mo_number, count);
                    System.out.println("your Library Id is " + lib_Id);
                    rigister();
                    break;
                case 2:
                    String emty = scanner.nextLine();
                    System.out.print("Enter your Mobile Nummber : ");
                    long mo_num = scanner.nextLong();
                    String empty = scanner.nextLine();
                    System.out.print("Enter your library id : ");
                    String lib_id = scanner.nextLine();
                    boolean boo = u.rigisterationCheck(mo_num, lib_id);
                    if (boo) {
                        System.out.println("user be in library....");
                        id = lib_id;
                    } else {
                        System.out.println("user not defined....");
                        flag = true;
                    }
                    break;
                default:
                    flag = true;
                    System.out.println("exit....");
            }
        } while (flag);
        process(id);
    }
    static int count= 0;
    static void process (String id) throws Exception{
        count++;
        int al = 0;
        boolean flag = false;
        do {
            u.displayBookInfo();
            System.out.println("1) take book ");
            System.out.println("2) exit ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String mty = scanner.nextLine();
                    System.out.println("Enter book name");
                    String b_Name = scanner.nextLine();
                    System.out.println("Enter auther name");
                    String a_Name = scanner.nextLine();
                    System.out.println(u.user_Take_Books(id, b_Name, a_Name));
                    break;
                case 2:
                    System.out.println("Thank You");
                    al =1;
                    break;
                default:
                    flag = true;
                    System.out.println("enter the correct option ");
            }
        } while (flag);
        if (al==1) return ;
            do{
            System.out.println("1) Extra take book");
            System.out.println("2) Exit");
            int op = scanner.nextInt();
            switch(op){
                case 1:
                    if(count==2) {
                        System.out.println("you have take max book");
                        break;
                    }
                    process(id);
                    break;
                case 2:
                    System.out.println("Thank You ...");
                    break;
                default:
                    System.out.println("invalid option");
            }

        }while(flag);

    }
}
