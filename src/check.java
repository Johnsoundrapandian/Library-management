import java.util.Scanner;

public class check {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prevTerm = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < prevTerm.length(); i++) {
            if (i < prevTerm.length() - 1 && prevTerm.charAt(i) == prevTerm.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(prevTerm.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms to generate: ");
        int numTerms = scanner.nextInt();
        System.out.println(countAndSay(numTerms));
//        for (int i = 1; i <= numTerms; i++) {
//            System.out.println("Term " + i + ": " + countAndSay(i));
//        }
    }
}

