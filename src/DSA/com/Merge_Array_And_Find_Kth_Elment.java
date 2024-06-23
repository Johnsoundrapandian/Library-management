package DSA.com;
import java.util.*;
public class Merge_Array_And_Find_Kth_Elment {
    public long kthElement( int arr1[], int arr2[], int n, int m, int h) {
        int[] arr = new int[n+m];
        int k =0;
        for(int j : arr1){
            arr[k++] = j;
        }
        for(int j : arr2){
            arr[k++] = j;
        }
        Arrays.sort(arr);
        return (long)arr[h-1];

    }
}
