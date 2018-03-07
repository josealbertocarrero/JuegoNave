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
public class Asteroide {
    Polygon asteroidePoligono = new Polygon ();
    
    private int velocidadasteroide = 1;
    private double anguloastradian;
    private double anguloasteroide= Math.random()*359;
    private double direccionx;
    private double direcciony;
    private double posxas = 800;
    private double posyas = 400;
    final int ventanax =800;
    final int ventanay =400;
    
    
    public Asteroide() {
    asteroidePoligono.getPoints().addAll(new Double[]{
            0.0, 50.0,
            100.0, 100.0,
            200.0, 50.0,
            125.0, 0.0,
            75.0, 0.0});

    }
    public Polygon getpoligono(){
        return asteroidePoligono;
    }
    public void asteroideMover(){
        anguloastradian = Math.toRadians(anguloasteroide);
        direccionx = Math.sin(anguloastradian);
        direcciony = Math.cos(anguloastradian);
                
        posxas += direccionx;
        posyas += direcciony;
        
        if (posxas >= ventanax){
            posxas = 0;
        }
        if (posyas >= ventanay){
            posyas = 0;
        }

        if (posxas < 0){
            posxas = ventanax;
        }

        if (posyas < 0){
            posyas = ventanay;
        }
        
        getpoligono().setTranslateX(posxas);
        getpoligono().setTranslateY(posyas);
    }
}
