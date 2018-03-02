/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author DaSTer
 */
public class Main extends Application {
    //Nave
    Nave nave = new Nave();
    

    
    double posx = 400;
    double posy = 200;
    
    //Variables ventana
    final int ventanax =800;
    final int ventanay =400;
    Scene ventana;
    //Asteroide
    Asteroide asteroide = new Asteroide();
    
    Bala bala;
    boolean colision;
    
    Text textoGameOver= new Text("Game Over");
    
    Pane root = new Pane();
//Lista balas ArrayList
    ArrayList<Bala> listaBalas = new ArrayList();
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Declaracion del arraylist:
        Arraylist<Bola> listaBolas = new Arraylist();
        
        Añadir bolas a la lista:
        for (int i=0; i<10; i++){
            Bola bola = new Bola();
            listaBolas.add(bola);ssss
        }
        Cojer la lista:
        Bola bola5 = listaBolas.get(5);
        */
        

        
        
        ventana = new Scene(root, ventanax, ventanay, Color.BLACK);
        primaryStage.setScene(ventana);
        primaryStage.show();
        
        //Llamada a nave para mostrarla en ventana 
        root.getChildren().add(nave.getnave()); 
        nave.getnave().setFill(Color.BLUE); 
        
        //Llamada a asteroide para mostrarlo en ventana
        root.getChildren().add(asteroide.getpoligono());
        asteroide.getpoligono().setFill(Color.RED);
        
        root.getStylesheets().add("estilos/estilos.css");
        
        //Muestra final de partida
        
        HBox gameOver = new HBox();
        gameOver.setTranslateX(posx/2);
        gameOver.setTranslateY(posy/2);
        gameOver.setMinWidth(posx);
        gameOver.setAlignment(Pos.CENTER);
        gameOver.setSpacing(100);

        root.getChildren().add(gameOver);

        Text textoGameOver = new Text("Game Over");
        textoGameOver.setFont(Font.font(50));
        textoGameOver.setFill(Color.WHITE);

        gameOver.getChildren().add(textoGameOver);
        
        //ssssnave.setId("nave");
        
        
        ventana.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case RIGHT:
                    nave.setVelocidadGiro(1);
                    break;
                    //nave.velocidadgiro=1;break;
                case LEFT:
                    nave.setVelocidadGiro(-1);
                    break;
                case UP:
                    nave.pulsaArriba();
                    break;
                case SPACE:
                        bala = new Bala(nave.posx, nave.posy, nave.angulonave);
                        listaBalas.add(bala);
                        root.getChildren().add(bala.getBala());
                        //Bola bola5 = listaBolas.get(5);

                    break;
            }
        });
        ventana.setOnKeyReleased((KeyEvent event) -> {
            nave.setVelocidadGiro(0);
        });
        animationNave.start(); //Llamada a la animación
    }//Cierre Método Start
    
    AnimationTimer animationNave = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //NAVE
                nave.naveMover();
                //ASTEROIDE 
                asteroide.asteroideMover();
                //BALA
                for (int i=0; i<listaBalas.size(); i++){
                    Bala bala = listaBalas.get(i);
                    bala.mueveBala();
                    
                }
                //for (int i=0;i<listaBalas;i++){
                    
                //}
                Shape colision = Shape.intersect(nave.navePoligono, asteroide.asteroidePoligono);
                boolean colisionVacia = colision.getBoundsInLocal().isEmpty();
                if (colisionVacia == false){
                    
                }
                
                
            }
        };
}//Cierre de la Clase JuegoNave
