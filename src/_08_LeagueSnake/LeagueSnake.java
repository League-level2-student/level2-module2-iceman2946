package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    Segment head;
    int foodX;
    int foodY;
    int direction= UP;
    int foodEaten=0;
    ArrayList<Segment> tail= new ArrayList<Segment>();

    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
        head= new Segment(250,250);
        frameRate(20);
        dropFood();
    }

    void dropFood() {
        foodX= ((int)random(50)*10);
        foodY= ((int)random(50)*10);
        
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(214,242,27);
        drawFood();
        move();
        drawSnake();
        eat();
    }

    void drawFood() {
        fill(84,245,19);
    	square(foodX,foodY,10);
        
    }

    void drawSnake() {
    	fill(111,104,185);
        rect(head.x,head.y,10,10);
        manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
        fill(111,104,185);
        for(int i=0; i<tail.size(); i++) {
        	rect(tail.get(i).x,tail.get(i).y,10,10);
        }
        
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	checkTailCollision();
    	drawTail();
    	tail.add(new Segment(head.x,head.y));
    	tail.remove(0);
    	
    	

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        //if()
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
    	if(keyCode==UP) {
    		direction=UP;
    	}
    	if(keyCode==DOWN) {
    		direction=DOWN;
    	}
    	if(keyCode==LEFT) {
    		direction=LEFT;
    	}
    	if(keyCode==RIGHT) {
    		direction=RIGHT;
    	}
        
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            // Move head up
            head.y--;
        } else if (direction == DOWN) {
            // Move head down
             head.y++;
        } else if (direction == LEFT) {
            head.x--;
        } else if (direction == RIGHT) {
            head.x++;
        }
        checkBoundaries();
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
    	if(head.x<0) {
    		head.x=500;
    	}
    	else if(head.x>500) {
    		head.x=0;
    	}
    	else if(head.y>500) {
    		head.y=0;
    	}
    	else if(head.y<0) {
    		head.y=500;
    	}
        
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
    	if(head.x==foodX && head.y==foodY) {
    		foodEaten+=1;
    		tail.add(new Segment(head.x,head.y));
    		dropFood();
    	}
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
