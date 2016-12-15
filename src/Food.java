/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devineni
 */
public class Food {
    int fx,fy;
    public int getX()
    {
        do{
         fx = (int) (Math.random() * 99);//generating a random x postion 
        }while(fx % 2 ==0);
        return fx;//returning x
    }
    public int getY()
    {
        do
        {
        fy = (int) (Math.random() * 99);//generating a random y position
        }while(fy % 2 ==0);
        return fy;//returning y
    }
}
