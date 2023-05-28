import greenfoot.*;

public class Elemento extends Actor
{
    public Elemento()
    {
        GreenfootImage sprite = getImage();
        sprite.scale(64, 64); 
        setImage(sprite);
    }
    public void act() 
    {
        move(-2);
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }    

}