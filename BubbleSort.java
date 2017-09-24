import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Result
{
    int numOfSwaps;
    int lowest;
    int highest;
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        Result r = sort(n, a);
        printResult(r);
    }
    
    private static void printResult(Result r)
    {
        System.out.println("Array is sorted in " + r.numOfSwaps +" swaps.");
        System.out.println("First Element: " + r.lowest);
        System.out.println("Last Element: " + r.highest);
    }
    
    private static Result sort(int elementCount, int[] unsorted)
    {
        Result r = new Result();
        r.numOfSwaps =0;
        
        for(int i = 0; i < elementCount; i++)
        {
            int curSwaps = 0;
            for(int j = 0; j < elementCount - 1; j++)
            {
                //if first number is greater than next number
                if(unsorted[j] > unsorted[j+1])
                {
                    //swap j and j+1 so smaller number first
                    int tempVal = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = tempVal;
                    
                    //increase number of swaps
                    curSwaps++;
                }
            }
            
            //if no swaps done, sorting is complete
            if(curSwaps == 0)
                break;
            
            r.numOfSwaps += curSwaps;
        }
        
        r.lowest = unsorted[0];
        r.highest = unsorted[elementCount-1];
        
        return r;
    }
}
