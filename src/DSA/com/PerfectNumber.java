package DSA.com;

public class PerfectNumber {
    public static void main(String[] args){
        int a = 8128;
        System.out.println(check(a));
    }
    public static boolean check(int a){
        int i =1,sum =0 ;
        if(a==1)return false;
        while(i<=a/2){
            if(a%i==0){
                sum+=i;
            }
            i++;
        }
        if(a!=sum){
            return false;
        }
        return true;
    }
}
