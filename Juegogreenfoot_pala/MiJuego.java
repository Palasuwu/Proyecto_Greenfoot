//Jorge Palacios #231385

import greenfoot.*;

public class MiJuego extends World
{
    private Jugador jugador;
    private int contadorElementos = 0;
    private GreenfootSound musiquitaFondo;
    
    public MiJuego()
    {    
        super(600, 400, 1);
        jugador = new Jugador();
        
        addObject(jugador, getWidth()/2, getHeight()/2);
        mostrarContadorElementos();
        musiquitaFondo = new GreenfootSound("Nyancat.wav");
        GreenfootImage fondo = getBackground();
        fondo.scale(600, 400);
        
    }
     public void started()
    {
        musiquitaFondo.playLoop();
    }
    public void ended()
    {
        musiquitaFondo.stop();
    }
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 2) {
            addObject(new Obstaculo(), getWidth(), Greenfoot.getRandomNumber(getHeight()));
        }
        
        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(new Elemento(), getWidth(), Greenfoot.getRandomNumber(getHeight()));
        }
        
    }
    
    public void incrementarContadorElementos()
    {
        contadorElementos++;
        mostrarContadorElementos();
    }
    
    private void mostrarContadorElementos()
    {
        showText("Pizzitas: " + contadorElementos, 80, 20);
    }
}
