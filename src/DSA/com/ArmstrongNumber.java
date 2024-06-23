package DSA.com;

public class ArmstrongNumber {
    public static void main(String[] args){
        int a = 28;
        System.out.println(check(a));
    }
    public static boolean check(int a){
        int sum = 0,count=0;
        int dup = a;
        while(a!=0){
            count++;
            a=a/10;
        }
        a=dup;
        while(dup!=0){
            int remain=dup%10;
            sum += Math.pow(remain,count);
            dup = dup/10;
        }
        if(a!=sum){
            return false;
        }
        return true;
    }
}
