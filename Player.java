import greenfoot.Greenfoot;
import java.util.List;

public class Player extends Avatar{
    
    private final double ACCELERATION = 0.3;
    private final double SPEED_LIMIT = 13;
    private double speedX = 0;
    private double speedY = 0;
    private int rotation;
    private final int ROTATION_SPEED = 3;
    private final double FRICTION = 0.96;
    
    public void act(){
        
        getPlayerMovement();
        
        move();
        
    }
    
    private void getPlayerMovement(){
    
        rotation = getRotation();
        
        if(Greenfoot.isKeyDown("Right")){
        
            setRotation(rotation + ROTATION_SPEED);

        }
        
        if(Greenfoot.isKeyDown("Left")){
        
            setRotation(rotation - ROTATION_SPEED);
        
        }
        
        if(Greenfoot.isKeyDown("Up")){
        
            speedX += Math.cos(Math.toRadians(rotation)) * ACCELERATION;
            speedY += Math.sin(Math.toRadians(rotation)) * ACCELERATION;
        
        }
        
        if(Greenfoot.isKeyDown("Down")){
        
            speedX -= Math.cos(Math.toRadians(rotation)) * ACCELERATION;
            speedY -= Math.sin(Math.toRadians(rotation)) * ACCELERATION;
        
        
        }
    
    }
    
    
    private void move(){
        
        TestSpeedLimit();
        
        friction();
        
        moveEntities();
        
    }
    
    private void TestSpeedLimit(){
    
        if(Math.abs(speedX) > SPEED_LIMIT){
            
            if(speedX > 0){
            
                speedX = SPEED_LIMIT;
            
            } else {
            
                speedX = -SPEED_LIMIT;
            
            }
            
        }
        
        if(Math.abs(speedX) > SPEED_LIMIT){
        
            if(speedY > 0){
            
                speedY = SPEED_LIMIT;
            
            } else {
            
                speedY = -SPEED_LIMIT;
            
            }
            
        }
    
    }
    
    private void friction(){
    
        if(!Greenfoot.isKeyDown("Up") && !Greenfoot.isKeyDown("Down")){
        
            speedX = FRICTION * speedX;
            speedY = FRICTION * speedY;
            
            if((speedX < 0.1 && speedX > -0.1)
                    || (speedY == 0 && speedX < 0.2 && speedX > -0.2)){
            
                speedX = 0;
            
            }
            
            if((speedY < 0.1 && speedY > -0.1)
                    || (speedX == 0 && speedY < 0.2 && speedY > -0.2)){
            
                speedY = 0;
            
            }
            
        }
        
    }
    
    private void moveEntities(){
    
        List<Entity> entities = getWorld().getObjects(Entity.class);
        
        for(Entity e : entities){
        
            e.setLocation(e.getX() - (int)speedX, e.getY() - (int)speedY);
            
        }
        
    }
    
}