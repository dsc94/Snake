

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devineni
 */
public class Snake  {
        public int x[] = new int[100];//array for x-cordinates
        public int y[] = new int[100];//array for y-cordinates
        
        public Snake()
        {
            
            for(int i=0;i<x.length;i++)
            {
                x[i] = 0;//initilasing all to 0
                y[i] = 0;
            }
           
        }
        public static void main(String args[])
        {
            
            Snake s = new Snake();
            KeyBoard k = new KeyBoard();//an instance of KeyBoard class
            k.startGame();//staring game 
        }
       
}     