/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author DaSTer
 */
public class Main extends Application {
    //Nave
    Nave nave = new Nave ();
    double angulonave;
    double direccionnave;
    double direccionnaveradianes;
    double velocidadnave;
    double velocidadgiro;
    //Variables de la posicion nave
    double direccionx = Math.sin(direccionnaveradianes);
    double direcciony = Math.cos(direccionnaveradianes);
    //Variables velocidad nave
    double velocidadx=0;
    double velocidady=0;
    
    double posx = 400;
    double posy = 200;
    
    //Variables ventana
    final int ventanax =800;
    final int ventanay =400;
    Scene ventana;
    //Asteroide
    Asteroide asteroide = new Asteroide();
    
    int velocidadasteroide = 1;
    double anguloastradian;
    double anguloasteroide= Math.random()*359;
    double posxas = 400;
    double posyas = 200;
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        ventana = new Scene(root, ventanax, ventanay, Color.BLACK);
        primaryStage.setScene(ventana);
        primaryStage.show();
        
        //Llamada a nave para mostrarla en ventana
        root.getChildren().add(nave.getnave());
        nave.getnave().setFill(Color.BLUE);
        
        //Llamada a asteroide para mostrarlo en ventana
        root.getChildren().add(asteroide.getpoligono());
        asteroide.getpoligono().setFill(Color.RED);
        
        ventana.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case RIGHT:
                    velocidadgiro=1;
                    break;
                case LEFT:
                    velocidadgiro=-1;
                    break;
                case UP:
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
                    break;
            }
        });
        ventana.setOnKeyReleased((KeyEvent event) -> {
            velocidadgiro = 0;
        });
        animationNave.start(); //Llamada a la animación
    }//Cierre Método Start
    
    AnimationTimer animationNave = new AnimationTimer() {
            @Override
            public void handle(long now) {
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
                
                //ASTEROIDE
                
                anguloastradian = Math.toRadians(anguloasteroide);
                posxas = Math.sin(anguloastradian);
                posyas = Math.cos(anguloastradian);
                
                posxas += velocidadasteroide;
                posyas += velocidadasteroide;
                
                nave.getnave().setLayoutX(posx);
                nave.getnave().setLayoutY(posy);
                nave.getnave().setRotate(direccionnave);
                
                asteroide.getpoligono().setLayoutX(posxas);
                asteroide.getpoligono().setLayoutY(posyas);
            }
        };
}//Cierre de la Clase JuegoNave
