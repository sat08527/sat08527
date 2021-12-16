/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) {
        System.out.println("GfG!");
        int arr[] = {
            3,
            1,
            0,
            4,
            5,
            3,
            7,
            1
        };
        calculateTappedWater(arr);
    }

    public static void calculateTappedWater(int arr[]) {
        int len = arr.length;
        int left[] = new int[len];
        int right[] = new int[len];

        left[0] = arr[0];
        right[len - 1] = arr[len - 1];
        //fill up the left array
        //0=3
        //1=3
        //2=3
        //3=4
        //4=5
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        //fill up the right array
        //6=1,7->7
        //5=7,3->7
        //4=7,5->7
        //3=7,4->7
        //
        
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        //min(left[i],right[i])-arr[i]
        int sum = 0;
        for (int i = 0; i < len; i++) {
            //System.out.print(Math.min(left[i], right[i])+"-");
            System.out.print("("+left[i]+","+ right[i]+")-");
            sum += Math.min(left[i], right[i]) - arr[i];
        }

        System.out.println("Units of water::" + sum);

    }
}