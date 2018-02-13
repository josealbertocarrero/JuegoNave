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
    Polygon nave = new Polygon();
    
    public Nave(){
    nave.getPoints().addAll(new Double[]{
            0.0, -30.0,
            10.0, 0.0,
            0.0, -5.0,
            -10.0, 0.0});
    }
    public Polygon getnave(){
        return nave;
    }
}
