import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    private int turnSpeed;
    
    public Block(int maxTurnSpeed){
        this.turnSpeed = Greenfoot.getRandomNumber(2 * maxTurnSpeed) - (maxTurnSpeed);
        if(this.turnSpeed == 0) {
            this.turnSpeed = 1;
        }
    }
    
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //turn(this.turnSpeed);
        turn(1);
    }    
}
