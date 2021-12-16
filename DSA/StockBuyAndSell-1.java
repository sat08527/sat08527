//Find the maxmum profit if u buy and sell once.
//int arr[]=[3,1,4,8,7,2,5];
//int aux[]=[3,8,8,8,7,5,5];
//Uising aux array

/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) {
        System.out.println("GfG!");
        int arr[] = {3,1,4,8,7,2,5
        };
        maxProfit(arr);
    }

//T-O(N), S-O(N)
   public static void maxProfit(int arr[]) {
    int maxFutProfit[] = new int[arr.length];
    maxFutProfit[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
        maxFutProfit[i] = Math.max(arr[i], maxFutProfit[i + 1]);
    }
    int maxProfit = 0;
    for (int i = 0; i < arr.length; i++) {
        int diff = maxFutProfit[i] - arr[i];
        if (diff > maxProfit) {
            maxProfit = diff;
        }
    }
    System.out.println("Maximum Profit::" + maxProfit);


}

//T-O(N), S-O(1)
//int arr[]=[3,1,4,8,7,2,5];
   public static void maxProfit(int arr[]) {
       int minSoFar=arr[0];
       int maxProfit = 0;
    for (int i = 0; i < arr.length; i++) {
        minSoFar=Math.min(minSoFar,arr[i]);
        int diff=arr[i] -minSoFar;
        if(diff>maxProfit)
            maxProfit=diff;
    }
    
    System.out.println("Maximum Profit::" + maxProfit);


}
}