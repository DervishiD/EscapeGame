import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;

public class MyWorld extends World{
    
    private static final int WORLD_WIDTH = 1600;
    private static final int WORLD_HEIGHT = 800;
    private final Player PLAYER;
    private final GreenfootImage BORDER_IMAGE;
    private final Border UP_BORDER, DOWN_BORDER, LEFT_BORDER, RIGHT_BORDER;
    private final int BORDER_LENGTH = WORLD_WIDTH * 5;
    private final int BORDER_HEIGHT = 40;
    
    public MyWorld(){    
        
        super(WORLD_WIDTH, WORLD_HEIGHT, 1, false);
        
        Greenfoot.setSpeed(50);
        
        getBackground().setColor(Color.BLACK);
        
        BORDER_IMAGE = new GreenfootImage(BORDER_LENGTH, BORDER_HEIGHT);
        BORDER_IMAGE.fill();
        
        UP_BORDER      = new Border(BORDER_IMAGE);
        DOWN_BORDER    = new Border(BORDER_IMAGE);
        LEFT_BORDER    = new Border(BORDER_IMAGE);
        RIGHT_BORDER   = new Border(BORDER_IMAGE);
        
        LEFT_BORDER.setRotation(90);
        RIGHT_BORDER.setRotation(90);
        
        addObject(UP_BORDER   , WORLD_WIDTH/2                    , -(BORDER_LENGTH - WORLD_HEIGHT)/2);
        addObject(DOWN_BORDER , WORLD_WIDTH/2                    , (BORDER_LENGTH + WORLD_HEIGHT)/2);
        addObject(LEFT_BORDER , -(BORDER_LENGTH - WORLD_WIDTH)/2 , WORLD_HEIGHT/2);
        addObject(RIGHT_BORDER, (BORDER_LENGTH + WORLD_WIDTH)/2  , WORLD_HEIGHT/2);
        
        PLAYER = new Player();
        addObject(PLAYER, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        
    }
    
    public Player getPlayer() { return PLAYER; }
    
}
