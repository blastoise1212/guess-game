/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mkreiner
 */
public class JavaFXApplication2 extends Application {
int numGuess;
Random rnd = new Random();
    @Override
    public void start(Stage primaryStage) {
        boolean win = false;
        //scene 1
        //int txtNum;
        
        int numToGuess = rnd.nextInt(100)+1;
        numGuess = numToGuess;
        System.out.println(numToGuess);
        TextField tf1 = new TextField​("5");
        String txtBox = tf1.getText();
        //tf1.setText("dgdh");
        //int txtAsNum = Integer.parseInt(txtBox);
        Image img = new Image("javafxapplication2/arrow.png");
        ImageView imgv = new ImageView(img);
        
        Image img2 = new Image("javafxapplication2/Arrow2.png");
        ImageView imgv2 = new ImageView(img2);
        Button btn = new Button();
        System.out.println();
        btn.setText("Guess");
        //scene 2
        Button btn2 = new Button();
        btn2.setText("Play Again");
        Button btn3 = new Button();
        btn3.setText("Quit");
        Label lbl = new Label();
        lbl.setText("guess a number between 1 and 100");
        //boolean win = false;
        //System.out.println(win);
        btn.setOnAction(new EventHandler<ActionEvent>() {
        
        
            @Override
            public void handle(ActionEvent event) {
            try
                {
                    String txtBox = tf1.getText();
                    int txtAsNum = Integer.parseInt(txtBox);
                    if(txtAsNum > numGuess)
                    {
                        //System.out.println("Lower");
                        imgv2.setVisible(true);
                        imgv.setVisible(false);
                    }
                    if(txtAsNum < numGuess)
                    {
                        //System.out.println("Higher");
                        imgv2.setVisible(false);
                        imgv.setVisible(true);
                        
                    }
                    if(txtAsNum == numGuess)
                    {
                        System.out.println("You win");
                        btn2.setVisible(true);
                        btn3.setVisible(true);
                    }
                    
                }
                catch(NumberFormatException nfe)
                {
                    System.out.println("Not a valid number!");
                } 
            }
            
            
            
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        
        
            @Override
            public void handle(ActionEvent event) {
                
                
            btn2.setVisible(false);
            btn3.setVisible(false);
            Reset();
            

            }
        
            
            
            
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
        
        
            @Override
            public void handle(ActionEvent event) {
                
                
            Platform.exit();
            

            }
        
            
            
            
        });
        
        
        
        //HBox root2 = new HBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        VBox root = new VBox();
        HBox hb3 = new HBox();
        btn2.setVisible(false);
        btn3.setVisible(false);
        
        
        hb1.getChildren().add(btn);
        hb1.getChildren().add(tf1);
        
        hb2.getChildren().add(btn2);
        hb2.getChildren().add(btn3);
        hb2.getChildren().add(lbl);
        
        
        
        
        hb3.getChildren().add(imgv);
        hb3.getChildren().add(imgv2);
        imgv2.setVisible(false);
        imgv.setVisible(false);
        //root.setAlignment(Pos.CENTER);
        
        
        
        root.getChildren().addAll(hb1, hb2, hb3);
        
        
        
        
        
        
        
                
                
        
        
        
        Scene scene = new Scene(root, 400, 400);
        
        
        primaryStage.setTitle("Guess That Number");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        
    }
    
    public void Reset()
    {
        numGuess = rnd.nextInt(100)+1;
        System.out.println(numGuess);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
