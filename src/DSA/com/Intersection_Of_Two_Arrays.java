package DSA.com;
import java.util.*;
public class Intersection_Of_Two_Arrays{
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        Set<Integer>set = new HashSet<>();
        for(int i =0 ;  i<a.length;i++){
            set.add(a[i]);
        }
        int count=0;
        for(int j =0; j<b.length;j++){
            if(set.contains(b[j])){
                count++;
                set.remove(b[j]);
            }

        }
        // if (count==20) return 18;
        return count;
    }
}
