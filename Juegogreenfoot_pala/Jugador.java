//Nyan :o 
import greenfoot.*;

public class Jugador extends Actor
{
    private GreenfootSound sonidoColision;
    
    public Jugador()
    {
        GreenfootImage imagenJugador = getImage();
        imagenJugador.scale(64, 64); // Redimensiona el sprite a 64x64 píxeles
        setImage(imagenJugador);
        
        sonidoColision = new GreenfootSound("maincra.wav");
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 5, getY());
        }
        
        verificarColision();
    }
    
    private void verificarColision()
    {
        Actor obstaculo = getOneIntersectingObject(Obstaculo.class);
        Actor elemento = getOneIntersectingObject(Elemento.class);
        
        if (obstaculo != null) {
            getWorld().removeObject(obstaculo);
            
            sonidoColision.play(); // Reproducir el sonido de colisión
            Greenfoot.stop();
            System.out.println("¡Perdiste! Explotaste a NyanCat :( .");
        }
        
        if (elemento != null) {
            getWorld().removeObject(elemento);
            MiJuego mundo = (MiJuego) getWorld();
            mundo.incrementarContadorElementos();
        }
    }
}

