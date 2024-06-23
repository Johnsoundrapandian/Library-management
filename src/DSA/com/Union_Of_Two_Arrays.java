package DSA.com;
import java.util.*;
public class Union_Of_Two_Arrays {
    public static int doUnion(int a[], int n, int b[], int m)
    {
        Set<Integer>set = new HashSet<>();
        int count= 0;
        for(int i=0; i < a.length;i++){
            set.add(a[i]);
        }
        for(int j =0 ; j<b.length;j++){
            set.add(b[j]);
        }
        return set.size();
    }
}
