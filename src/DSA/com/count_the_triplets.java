package DSA.com;
import java.util.*;
public class count_the_triplets {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        Set <Integer> set=new TreeSet<>();
        for(int d : arr){
            set.add(d);
        }
        //Arrays.sort(arr);
        int i =0,j=i+1,count =0;
        while(j<n && i<j){
            if( set.contains(arr[i]+ arr[j])) {
                count++;
            }
            j++;
            if(j==n-1) {
                i++;
                j=i+1;
            }

        }
        return count;
    }
}
