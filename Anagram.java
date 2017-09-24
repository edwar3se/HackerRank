import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public static int numberNeeded(String first, String second) 
    {   
        int needed = 0;
        
        int[] firstNums = createNumsArray(first);
        int[] secondNums = createNumsArray(second);
        
        //loop through 26 bc number of letter in alphabet and length of both arrays
        for(int loc = 0; loc < 26; loc++)
        {
            needed += Math.abs(firstNums[loc] - secondNums[loc]);
        }
        
        return needed;
    }
  
    private static int[] createNumsArray(String letters)
    {
        int[] numbers = new int[26]; //bc 26 letters in alphabet
        
        for(int loc = 0; loc < letters.length(); loc++)
        {
            char letter = letters.charAt(loc);
            numbers[letter - 'a'] += 1; //increase count of this letter by one
        }
        
        return numbers;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
