/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author DaSTer
 */
public class Bala {

    Nave nave;
    Circle bala; 
    double angulobala;
    double posxbala;
    double posybala;
    double resto;
    double anguloradianes;
    
    private double direccionx;
    private double direcciony;
    
    final int ventanax =800;
    final int ventanay =400;
    
    public Bala(double posx, double posy, double angulo) {
        posxbala = posx;
        posybala = posy;
        angulobala = angulo;
        bala = new Circle(posx, posy , 3);
        bala.setFill(Color.WHITE);

    }
    
    public Circle getBala(){
        return bala;
    }
    
    public void mueveBala(){
        posxbala += direccionx;
        posybala += -direcciony;
        
        resto = angulobala % 360;
        anguloradianes = Math.toRadians(resto);
        
        direccionx = Math.sin(anguloradianes);
        direcciony = Math.cos(anguloradianes);

        bala.setCenterX(posxbala);
        bala.setCenterY(posybala);
        

   }
}
