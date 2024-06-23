import java.util.Scanner;
public class Anagra
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the String1 :");
        String a = scanner.nextLine();
        int len1 = a.length();
        System.out.println("enter the String2 :");
        String b = scanner.nextLine();
        int len2 = b.length();
        if (a == b) {
            System.out.println("both Strings are Equal ");
        } else {
            System.out.println("both Strings are not equal ");
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        for (int i = 0; i < len1; i++) {
            for (int j = i + 1; j < len1; j++) {
                if(c[i] > c[j]){
                    char temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }

            }
        }
        for (int i = 0; i < len2; i++) {
            System.out.print(c[i]);
        }

        for (int i = 0; i < len2; i++) {
            for (int j = i + 1; j < len1; j++) {
                if(d[i] > d[j]){
                    char temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }

            }
        }

        for (int i = 0; i < len2; i++) {
            System.out.print(d[i]);
        }
           int count = 1;
            for (int j = 0 ; j < len1; j++) {
                if(c[j] != d[j]){
                    count = 0;
                    break;
                }
            }
            if (count == 1)
            {
                System.out.println("equal");
            }
            else
                System.out.println("not equal ");




    }

}
