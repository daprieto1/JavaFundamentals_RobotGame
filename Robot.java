import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage robotImage1;
    private GreenfootImage robotImage2;
    private int lives;
    private int pizzaEaten;
    private int score;
    private int animateCounter;
    private int timer;
    private final int MAX_TIMER = 1000;

    /**
     * Constructor
     */
    public Robot(){
        robotImage1 = new GreenfootImage("man01.png");
        robotImage2 = new GreenfootImage("man02.png");
        lives = 3;
        pizzaEaten = 0;
        score = 0;   
        animateCounter = 0;
        timer = MAX_TIMER;
    }

    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        robotMovement();
        detectCollision();
        detectHomeCollision();
        detectPizzaCollision(); 
        updateTimer();
    }    

    /**
     * Move the robot using the arrow keys.
     */
    public void robotMovement(){
        detectRobotMovement("down", getX(), getY() + 3);
        detectRobotMovement("left", getX() - 3, getY());
        detectRobotMovement("right", getX() + 3, getY());
        detectRobotMovement("up", getX(), getY() - 3);    
    }

    /**
     * Detect if the Robot have a collision with a Wall.
     * In that case the Robot should return to the initial position.
     */
    public void detectCollision(){
        if(isTouching(Wall.class) || isTouching(Block.class)){
            collisionDetected();
        }
    }

    public void detectHomeCollision(){
        if(isTouching(Home.class) && pizzaEaten == 5){            
            Greenfoot.playSound("yipee.wav");
            goToInitialPostion();
            increaseScore();
            
            RobotWorld world = (RobotWorld)getWorld();
            world.increaseLevel();
            resetTime();
        }
    }

    public void detectPizzaCollision(){
        if(isTouching(Pizza.class)){            
            Greenfoot.playSound("eat.wav");
            removeTouching(Pizza.class);
            pizzaEaten++;
            timer += 200;
            showStatusGame();
        }
    }

    /**
     * Animate the robot movement
     */
    public void animate(){
        animateCounter++;
        if(animateCounter > 5){
            animateCounter = 0;
            if(getImage() == robotImage1){
                setImage(robotImage2);
            }else{
                setImage(robotImage1);
            }
        }        
    }
    
    public void updateTimer(){
        timer--;
        getWorld().showText("Time Left : " + timer, 70, 580);
        if(timer < 1){
            removeLife();
            resetTime();
        }
    }
    
    public void resetTime(){
        timer = MAX_TIMER;
    }
    
    /**
     * Display the game status.
     */
    private void showStatusGame(){
        getWorld().showText("Lives : " + lives, 70, 540);
        getWorld().showText("Score : "+ score, 70, 560);
    }
    
    /**
     * Detect if the robot has movement to any direction.
     */
    private void detectRobotMovement(String direction, int newXPosition, int newYPosition){
        if(Greenfoot.isKeyDown(direction)){
            setLocation(newXPosition, newYPosition);
            animate();
        }
    }
    
    /**
     * Execute all commands when a collision was detected.
     */
    private void collisionDetected(){
        Greenfoot.playSound("hurt.wav");
        removeLife();
    }
    
    /**
     * Remove a life and veriify if the game should stop.
     */
    private void removeLife(){
        lives--;
        showStatusGame();
        goToInitialPostion();
        
        if(lives <= 0){
            Greenfoot.stop();
        }
    }
    
    /**
     * Increa the score in 1, and display game status.
     */
    private void increaseScore(){
        score++;
        showStatusGame();
    }
    
    /**
     * The robot is set in the initial location.
     */
    private void goToInitialPostion(){
        setLocation(RobotWorld.robotInitX, RobotWorld.robotInitY);
    }
}
