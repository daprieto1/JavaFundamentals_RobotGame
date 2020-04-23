import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author (Diego Prieto) 
 * @version (1.0.0)
 */
public class RobotWorld extends World
{
    public static final int robotInitX = 300;
    public static final int robotInitY = 500;
    
    private int currentLevel;
    private int currentMaxTurnSpeed;
    
    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();        
    }

    /**
     * Change the speed of the block.
     * Re-locate pizzas positions.
     */
    public void setUpLevel(){
        if(currentLevel == 1){
            addObject(new Block(currentMaxTurnSpeed),427,145);
            addObject(new Pizza(), 720, 46);
            addObject(new Pizza(), 433, 38);
            addObject(new Pizza(), 183, 302);
            addObject(new Pizza(), 682, 312);
            addObject(new Pizza(), 417, 537);
        }
        if(currentLevel == 2){
            addObject(new Block(currentMaxTurnSpeed), 428, 362);
            addObject(new Pizza(), 433, 38);
            addObject(new Pizza(), 183, 302);
            addObject(new Pizza(), 682, 312);
            addObject(new Pizza(), 417, 537);             
            addObject(new Pizza(), 720, 46);
        } else if(currentLevel == 3){
        }else if(currentLevel == 4){
        }        
    }
    
    public void increaseLevel(){
        currentLevel++;
        currentMaxTurnSpeed++;
        setUpLevel();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        //Set initial level
        currentLevel = 0;
        currentMaxTurnSpeed = 2;
        
        // Create the robot
        addObject(new Robot(), RobotWorld.robotInitX, RobotWorld.robotInitY);

        // Create all the walls
        addObject(new Wall(), 52, 147);
        addObject(new Wall(), 159, 147);
        addObject(new Wall(), 266, 147);
        addObject(new Wall(), 587, 147);
        addObject(new Wall(), 692, 147);
        addObject(new Wall(), 791, 147);


        addObject(new Home(), 751, 552);

        addObject(new ScorePanel(), 71, 554);  
        
        increaseLevel();
    }
    
    
}
