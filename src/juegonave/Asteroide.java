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
}
