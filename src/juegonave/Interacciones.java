/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author DaSTer
 */
public class Interacciones {
    double posx = 400;
    double posy = 200;
    final int TEXT_SIZE=25;
    final int SCENE_TAM_X = 600;
    Text textScore;
    int score;
    int highScore;
    Text textHighScore = new Text("0");
    public void gameOver(Pane root){
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
    }
    
    public void marcador(Pane root){
        //LAYOUTS PARA MOSTRAR PUNTUACIONES
        //Layout Principal
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(SCENE_TAM_X);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        root.getChildren().add(paneScores);
        //Layout para puntuacion actual
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneCurrentScore);
        //Layout para la puntuación máxima
        HBox paneHighScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneHighScore);
        //Texto de la etiqueta para la puntuación
        Text textTitleScore = new Text("Score:");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.WHITE);
        //texto para la puntuacion
        textScore = new Text("0");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
        //Texto de etiqueta ara la puntiacion maxima
        Text textTitleHighScore = new Text("Max.Score:");
        textTitleHighScore.setFont(Font.font(TEXT_SIZE));
        textTitleHighScore.setFill(Color.WHITE);
        //Texto puntuacion maxima
        
        textHighScore.setFont(Font.font(TEXT_SIZE));
        textHighScore.setFill(Color.WHITE);
        //Añadir texto a los los layout reservados para ellos
        paneCurrentScore.getChildren().add(textTitleScore);
        paneCurrentScore.getChildren().add(textScore);
        paneHighScore.getChildren().add(textTitleHighScore);
        paneHighScore.getChildren().add(textHighScore);
    }
    
    public void aumentarPuntuacion(){
        score++;
        textScore.setText(String.valueOf(score));
    }
    public void cambiarPmaxima(){
        if(score > highScore){
            //Cambiar nueva puntuación más alta
            highScore = score;
            textHighScore.setText(String.valueOf(highScore));
        }
    }
}
