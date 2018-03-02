/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;
import javafx.scene.shape.Polygon;

/**
 *
 * @author DaSTer
 */
public class Nave {
    public double angulonave;
    private double direccionnave;
    private double direccionnaveradianes;
    private double velocidadnave;
    private double velocidadgiro;
    //Variables de la posicion nave
    private double direccionx;
    private double direcciony;
    //Variables velocidad nave
    private double velocidadx=0;
    private double velocidady=0;
    
    double posx = 400;
    double posy = 200;
    
    final int ventanax =800;
    final int ventanay =400;
    
    Polygon navePoligono = new Polygon();
             
    public Nave(){
    navePoligono.getPoints().addAll(new Double[]{
            0.0, -30.0,
            10.0, 0.0,
            0.0, -5.0,
            -10.0, 0.0});
    }
    public Polygon getnave(){
        return navePoligono;
    }
    
    public void setVelocidadGiro(int vgiro){
        velocidadgiro = vgiro;
    }
    
    public void pulsaArriba (){
        direccionx = Math.sin(direccionnaveradianes);
        direcciony = Math.cos(direccionnaveradianes);
        velocidadx += direccionx*0.2;
        velocidady += -direcciony*0.2;
        if (velocidadx >= 3){
            velocidadx =3;
        }
        if (velocidady >= 3){
            velocidady =3;
        }
    }
    
    public void naveMover(){
        direccionnave = angulonave % 360;
        direccionnaveradianes = Math.toRadians(direccionnave);

        angulonave+= velocidadgiro;

        posx += velocidadx;
        posy += velocidady;


        if (posx >= ventanax){
            posx = 0;
        }
        if (posy >= ventanay){
            posy = 0;
        }

        if (posx < 0){
            posx = ventanax;
        }

        if (posy < 0){
            posy = ventanay;
        }
        getnave().setLayoutX(posx);
        getnave().setLayoutY(posy);
        getnave().setRotate(direccionnave);    
    }
}
