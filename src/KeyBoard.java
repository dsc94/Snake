
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devineni
 */

     public class KeyBoard extends Snake implements DrawListener 
    {
        int score;
        Draw d = new Draw();
        Food f;//creating Food instance
        boolean borders = false;
        boolean game;
        boolean foodforfirst = true;
        int blocks = 1;
        int fx,fy,sx,sy;
        boolean start = false;
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
         public  void  startGame()
        {
            game = true;
            d.setXscale(1,100);//setting the x scale to 100
            d.setYscale(1,100);//setting the y scale to 100
            d.clear(Color.black);//initalising to color black
            d.addListener(this);//add draw listemer for key events
            d.setPenColor(Color.yellow);
            //d.addListener(b);
            d.picture(50,70,"snake.png");
            d.text(50, 35,"1.Start Game");
            d.text(50, 25,"2.Instructions");
            d.text(50, 15,"3.Exit Game");
            //initGame();
        }
        public final void instructionPanel()
        {
           d.clear(Color.BLACK);// For the Game instructions on key press 2
           d.setPenColor(Color.yellow);
           d.text(50,70,"CONTROL THE SNAKE WITH THE A,W,S,D KEYS");
           d.text(50, 50,"MAKE SURE SNAKE DOES NOT COLLIDE WITH THE BORDER");
           d.text(50,30,"SNAKE SHOULD NOT EAT ITSELF");
        }
        public final void exitGame()
        {
            d.clear(Color.black);//Exiting Game on keypress 3
            d.setPenColor(Color.yellow);
            d.text(50, 50, "Thank You For Playing!!!");
        }
        public void initGame()
        {
            food();//calling food to place a andom food
            do{
            x[0] = (int) (Math.random() * 100);//for snake head x and y cordinate
            y[0]= (int) (Math.random() * 100);
            }while(x[0] % 2 == 0 && y[0] % 2 == 0);//placing in eb=ven co-ordinates
            for(int i=0;i<blocks;i++)
            
            {
            if(i == 0 && i == 0)
            {
            d.setPenColor(Color.red);//for head
            d.filledRectangle(x[i], y[i], 1, 1);
            }
            else
            {
            d.setPenColor(Color.yellow);//for rest of body
            d.filledRectangle(x[i], y[i], 1, 1);  
            }
            }
        }
       
       public void draw()
       {
            d.clear(Color.BLACK);//shouls clear the screen again without overlapping
            d.setXscale(1,100);
            d.setYscale(1, 100);
            d.setPenColor(Color.yellow);
            d.filledRectangle(fx, fy, 1, 1);
           for(int i =0;i<blocks;i++)
           {
              if(x[i] != 0 && y[i] != 0)
              {  
               //d.picture(x[i], y[i], "foodimage.jpg", 5, 5)
               if(i == 0 )
               {
               d.setPenColor(Color.red);//for snake head
               d.filledRectangle(x[i] , y[i] , 1, 1);
               
               }
               else
               {
               d.setPenColor(Color.yellow);//for snake rest of body
               d.filledRectangle(x[i] , y[i] , 1, 1); 
              
               }
               }
           }
        }
       
        public void food()
        {
            f= new Food();//creating anintance
            d.setPenColor(Color.yellow);
            //d.text(50, 50, "preparing food"); 
            fx = f.getX();//getting x -cordinate
            fy = f.getY();//getting y-cordinate
            d.filledRectangle(fx, fy, 1,1);
        }   
        public void move()
        { 
           
            for(int i=blocks;i>0;i--)
            {
                if(x[i] != 0 && y[i] != 0)
                {
                x[i] = x[i - 1];//move rest of snake body by one position
                y[i] = y[i - 1];
                }
            }
            if(left)
            {
               
                x[0] = x[0] - 1;//if turn to left move left by 1 position
                left = false;
                
            }
            if(right)
            {
                
                x[0] = x[0] + 1;//if turn to right move right by 1 position
                right = false;
                
            }
            if(up)
            {
                
                y[0] = y[0] + 1;//if turn to up move up by 1 position
                up = false;
               
            }
            if(down)
            {
               
                y[0] = y[0] - 1;//if turn to down move down by 1 position
                down = false; 
        }
        }
        public boolean eat()
        {
            if(((x[0]  == fx  && y[0] == fy )))
            {
                blocks = blocks + 1;//increasing snake body
                for(int i=1;i<blocks;i++)
                {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
                }
                x[0]  = fx;//placing the new postion as snake head
                y[0] = fy ;
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean checkborders()
        {
            if(x[0] == 0 || x[0] == 100 || y[0] == 0 || y[0] == 100)//if it collides with any of the border
            {
                borders = true;
            }
            return borders;
        }
        public  boolean checkitself()
        {
            for(int i=1;i<blocks;i++)
            {
                if(x[0] == x[i] && y[0] == y[i])//if it eats with own body
                {
  
                    borders = true;
                }
            }
            return borders;
        }    
    /**
     * @param args the command line arguments
     */
   

    private void gameOver() { 
        d.clear(Color.black);
        d.setPenColor(Color.yellow);
        d.text(50, 50, "Thank You for Playing");
        d.text(50, 30, "Game Over");
        d.text(50, 20, "Your score is " + String.valueOf(blocks));
        d.text(50, 10, "Press 3 to Exit Game");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        @Override
        public void mousePressed(double x, double y) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseDragged(double x, double y) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(double x, double y) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(char c) {
            if(c == '1')
            {
                d.clear(Color.black);
                initGame();              
            }
           
            if(c == 'S')//on key press S
            {
                down = true;
                if(eat())
                {
                  food();
                }
                move();
                draw();
                if(checkborders())
                {
                    gameOver();
                }
                if(checkitself())
                {
                    gameOver();
                }
                }
            if(c == 'W')//on key press W
            {
               up = true;
               if(eat())
                {
                  food();
                }
                move();
                draw();
                if(checkborders())
                {
                    gameOver();
                }
                if(checkitself())
                {
                    gameOver();
                }
            }
            if(c == 'A') // on key press A
            {
                
                left = true;
                if(eat())
                {
                  food();
                }
                
                move();
                draw();
                if(checkborders())
                {
                   gameOver();
                }
                if(checkitself())
                {
                    gameOver();
                }
            }    
              
            if(c == 'D')//on key press D
            {
                
                right = true;
                if(eat())
                {
                  food();
                }
                move();
                draw();
                if(checkborders())
                {
                    gameOver();
                }
                if(checkitself())
                {
                   gameOver();
                }
            }
            if(c == '2')//on key press 2
            {
                instructionPanel();
            }
            if(c == '3')//on key press 3
            {
                exitGame();
                System.exit(1);
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }