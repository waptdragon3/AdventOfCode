
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wthom
 */
public class Day2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int numDoubles = 0;
        int numTriples = 0;
        Scanner input = new Scanner(new File("day2.txt"));
        while(input.hasNextLine())
        {
            String line = input.nextLine().toUpperCase();
            int[] nums = new int[26];
            for(char c:line.toCharArray())
            {
                nums[c-'A']++;
            }
            System.out.println(Arrays.toString(nums));
            boolean is3 = false, is2 = false;
            for(int i = 0; i < 26; i++)
            {
                if(nums[i]==2)is2 = true;
                if(nums[i]==3)is3 = true;
            }
            if(is2)numDoubles++;
            if(is3)numTriples++;
        }
        
        
        System.out.println("Number of Doubles:" + numDoubles);
        System.out.println("Number of Triples:" + numTriples);
        System.out.println("Checksum: " + (numDoubles*numTriples));
    }
}
