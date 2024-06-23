package DSA.com;
import java.util.*;
public class findTripletsWithZero_Sum {
    public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        int i  =0 ,j=i+1 , k= n-1;
        while(i<j&&j<k) {
            if (arr[i] + arr[j] + arr[k] == 0) {
                return true;
            } else if (arr[i] + arr[j] + arr[k] > 0) {
                k--;
            } else if (arr[i] + arr[j] + arr[k] < 0) {
                j++;
            }
            if (j == k) {
                i++;
                j = i + 1;
                k = arr.length - 1;
            }
        }
        return false;
    }
}
