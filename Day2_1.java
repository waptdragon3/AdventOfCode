
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
public class Day2_1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("day2.txt"));
        ArrayList<String> inputs = new ArrayList<>();
        while(input.hasNextLine())
        {
            String line1 = input.nextLine().toUpperCase();
            int[] nums = new int[26];
            for(String line2:inputs)
            {
                int numDifference = 0;
                int diffIndex = -1;
                for(int i = 0; i < line1.length() && i < line2.length(); i++)
                {
                    if(line1.charAt(i) != line2.charAt(i))
                    {
                        numDifference++;
                        diffIndex = i;
                    }
                }
                if(numDifference == 1)
                {
                    
                    System.out.println(line1 + " " + line2);
                    System.out.println("Common letters: ");
                    for(int i = 0; i < line1.length(); i++)
                        if(i != diffIndex)
                            System.out.print(line1.charAt(i));
                    System.out.println();
                }
            }
            inputs.add(line1);
        }
    }
}
