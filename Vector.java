/**
 * Classe de vecteur mathématique facilitant les calculs
 * de position et de vitesse. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
    private double x, y;

    public Vector(double argX, double argY) {
        setCoordinates(argX, argY);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getNorm() { return Math.sqrt(x * x + y * y); }

    public void setCoordinates(double argX, double argY) {
        x = argX;
        y = argY;
    }

    static public Vector getUnitVector(Vector v) {
        return new Vector(v.getX() / v.getNorm(), v.getY() / v.getNorm());
    }

    static public Vector multiplyByScalar(Vector v, double d) {
        return new Vector(v.getX() * d, v.getY() * d);
    }

    static public Vector addVectors(Vector u, Vector v) {
        return new Vector(v.getX() + u.getX(), v.getY() + u.getY());
    }

    static public Vector minus(Vector v) {
        return new Vector(-v.getX(), -v.getY());
    }
}
