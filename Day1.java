
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
public class Day1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("day1.txt"));
        ArrayList<Integer> frequencies = new ArrayList<>();
        ArrayList<Integer> inputs = new ArrayList<>();
        frequencies.add(0);
        int total = 0;
        while(scanner.hasNextInt())
        {
            int tmp = scanner.nextInt();
            inputs.add(tmp);
        }
            
        boolean foundDup = false;
        while(!foundDup)
        {
            for(int tmp:inputs)
            {
                total += tmp;
                if(frequencies.contains(total))
                {
                    System.out.println("Found a duplicate:" + total + " after " + frequencies.size());
                    foundDup = true;
                    break;
                }
                frequencies.add(total);
            }
        }
        System.out.println("Total:" + total);
    }
}
