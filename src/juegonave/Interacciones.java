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
}
