import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe abstraite générique dont héritent l'avatar
 * du joueur et les ennemis. Toute entité garde
 * en mémoire le nombre de frames qui sont passées
 * depuis la dernière fois qu'elle a changé d'état.
 * Ceci sert par exemple à donner une durée précise
 * à l'animation d'apparition d'un ennemi. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor
{
    public final int APPEARING = 0, ACTIVE = 1, DISAPPEARING = 2;
    private int state, framesSinceStateChange;
    private float speed;
    private GreenfootImage image;
    private Vector pos = new Vector(0, 0), velocity = new Vector(0, 0);
    
    abstract void appear(int frame);
    abstract void disappear(int frame);
    abstract void draw(GreenfootImage image);
    abstract void travel();
    
    public double getSpeed() { return speed; }
    
    public void setState(int newState) {
        state = newState;
        framesSinceStateChange = 0;
    }

    public int getState() { return state; }
    public Vector getPos() { return pos; }
    public Vector getVelocity() { return velocity; }
    
    public int getFramesSinceStateChange() {
        return framesSinceStateChange;
    }
    
    public void setPos(Vector v) { pos = v; }
    public void setVelocity(Vector v) { velocity = v; }
    public void setSpeed(float v) { speed = v; }

    public void updateFramesSinceStateChange() {
        ++framesSinceStateChange;
    }
}
