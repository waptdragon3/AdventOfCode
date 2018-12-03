
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
public class Day3_1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Claim> claims = new ArrayList<>();
        Scanner in = new Scanner(new File("day3.txt"));
        while(in.hasNextLine())
        {
            Scanner line = new Scanner(in.nextLine());
            int id = Integer.parseInt(line.next().substring(1));
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
            claims.add(new Claim(startX, startY, sizeX, sizeY, id));
        }
        for(int i = 0; i < claims.size(); i++)
        {
            boolean untouched = true;
            for(int j = 0; j < claims.size() && untouched; j++)
            {
                if(i == j)continue;
                if(claims.get(i).isOverlapping(claims.get(j)))
                {
                    //System.out.println("Intercection between " + claims.get(i).ID + " and " + claims.get(j).ID);
                    untouched = false;
                }
            }
            if(untouched)
            System.out.println(claims.get(i).ID);
        }
    }
    
    
    private static class Claim
    {
        int startX, startY, sizeX, sizeY, ID;

        public Claim(int startX, int startY, int sizeX, int sizeY, int ID)
        {
            this.startX = startX;
            this.startY = startY;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.ID = ID;
        }
        
        public boolean isOverlapping(Claim other)
        {
            if(endX() < other.startX)return false;
            if(endY() < other.startY)return false;
            if(other.endX() < startX)return false;
            if(other.endY() < startY)return false;
            
            return true;
        }
        
        int endX(){return startX+sizeX;}
        int endY(){return startY+sizeY;}
    }
}
