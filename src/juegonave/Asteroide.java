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
    Polygon poligono = new Polygon ();
    
    private int velocidadasteroide = 1;
    private double anguloastradian;
    private double anguloasteroide= Math.random()*359;
    private double direccionx;
    private double direcciony;
    private double posxas = 400;
    private double posyas = 200;
    final int ventanax =800;
    final int ventanay =400;
    
    
    public Asteroide() {
    poligono.getPoints().addAll(new Double[]{
            0.0, 50.0,
            100.0, 100.0,
            200.0, 50.0,
            125.0, 0.0,
            75.0, 0.0});

    }
    public Polygon getpoligono(){
        return poligono;
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
        
        getpoligono().setLayoutX(posxas);
        getpoligono().setLayoutY(posyas);
    }
}
