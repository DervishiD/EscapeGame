import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Un Rusher détecte la position du joueur avec la méthode lockTarget(Entity e)
 * une seule fois lorsqu'il devient actif, puis se déplace vers
 * cette position à vitesse constante.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rusher extends Entity
{
    private MyWorld world;
    private Player player;
    private Vector target, playerPos;

    public Rusher(Vector pos, int speed) {
        world = null;
        player = null;
        setPos(pos);
        setSpeed(speed);
        target = null;
        setState(ACTIVE); // À supprimer plus tard
    }

    public void act() {
        // getWorld() retourne null dans le constructeur. 
        if (world == null || player == null) {
            world = (MyWorld) getWorld();
            player = world.getPlayer();
            playerPos = player.getPos();
        }
        
        if (getState() == ACTIVE) {
            if (target == null) {
                lockTarget((Entity) player);
            }
            travel();
        }
        setLocation((int) Math.round(getPos().getX()), (int) Math.round(getPos().getY()));
        updateFramesSinceStateChange();
    }

    void lockTarget(Entity e) { target = e.getPos(); }

    void travel() {
        // Vecteur reliant le Rusher et le joueur
        Vector v = Vector.addVectors(playerPos, 
                Vector.minus(this.getPos()));
        /*
         * Translation par le vecteur ayant la direction
         * et le sens de v et une norme getSpeed()
         */
        setPos(Vector.addVectors(getPos(), 
                    Vector.multiplyByScalar(
                        Vector.getUnitVector(v), getSpeed())));
    }

    void appear(int frame) {}
    void disappear(int frame) {}
    void draw(GreenfootImage image) {}
}
