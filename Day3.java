
import java.io.File;
import java.io.FileNotFoundException;
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
public class Day3
{
    static int[][] fabric;
    
    public static void makeClaim(int startX, int startY, int sizeX, int sizeY)
    {
        for(int x = 0; x < sizeX+1; x++)
        {
            for(int y = 0; y < sizeY+1; y++)
            {
                fabric[x+startX][y+startY]++;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        fabric = new int[1001][1001];
        Scanner in = new Scanner(new File("day3.txt"));
        while(in.hasNextLine())
        {
            Scanner line = new Scanner(in.nextLine());
            line.next();
            line.next();
            String start = line.next();
            start = start.substring(0, start.length()-1);
            String size = line.next();
            
            
            int commaIndex = start.indexOf(',');
            int startX = Integer.parseInt(start.substring(0, commaIndex));
            int startY = Integer.parseInt(start.substring(commaIndex+1));
            
            int xIndex = size.indexOf('x');
            int sizeX = Integer.parseInt(size.substring(0, xIndex));
            int sizeY = Integer.parseInt(size.substring(xIndex+1));
            
            makeClaim(startX, startY, sizeX, sizeY);
            
        }
        int numOverlaps = 0;
        for(int i = 0; i < fabric.length; i++)
        {
            for(int j = 0; j < fabric[i].length; j++)
            {
                System.out.print(fabric[i][j]);
                if(fabric[i][j] > 1)
                    numOverlaps++;
            }
            System.out.println();
        }
        
        System.out.println("There are " + numOverlaps + " overlaps");
    }
}
