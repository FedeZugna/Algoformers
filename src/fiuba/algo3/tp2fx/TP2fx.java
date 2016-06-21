/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2fx;

import view.*;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Martin
 */
public class TP2fx extends Application {
    private static final String TITULO_JUEGO = "Algoformers";
    private static final String RUTA_IMG1 = "fotos/prueba1.png";
    
    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        */
        BorderPane border = new BorderPane();
        VBoxStatsYOrdenesDisponibles statsYOrdenes = new VBoxStatsYOrdenesDisponibles();
        HBox hbox = addHBox(statsYOrdenes);
        border.setTop(hbox);
        border.setRight(agregarTile());
        border.setLeft(addVBox());
        border.setBottom(statsYOrdenes);
        
        
        statsYOrdenes.actualizarStatsObjetivo(0, 0, 0, 0, 0);//prueba de actualizacion de valores
        
        //el setup
        Scene scene = new Scene(border, 300, 250);
        primaryStage.setTitle(TITULO_JUEGO);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); //deshabilita el ESC to exit FS mode
        if (!primaryStage.isFullScreen()){
            primaryStage.setFullScreen(true);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 

    /*
    * Creates an HBox with two buttons for the top region
    */
    
    private HBox addHBox(VBoxStatsYOrdenesDisponibles asd) {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Valores en 0");
        buttonCurrent.setPrefSize(100, 20);
        
        EventHandler<ActionEvent> handler0 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               asd.actualizarStatsObjetivo(0, 0, 0, 0, 0);
            }
        };
        EventHandler<ActionEvent> handler1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               asd.actualizarStatsObjetivo(1, 1, 1, 1, 1);
            }
        };
        
        buttonCurrent.setOnAction(handler0);
        Button buttonProjected = new Button("Valores en 1");
        buttonProjected.setPrefSize(100, 20);
        buttonProjected.setOnAction(handler1);
        
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
        return hbox;
    }
    
    /*
     * Creates a VBox with a list of links for the left region
     */
    private VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes
        
        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Sales"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribution"),
            new Hyperlink("Costs")};

        for (int i=0; i<4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
        
        return vbox;
    }
    
    /**
     * Agrega el borde de la pantalla indicando el estado del juego (DEVNOTE: DE ALGUNA MANERA)
    */
    private HBox agregarEstadoDelJuego(){
        HBox hbox = new HBox();
        //inicio
        
        
        
        //fin
        return hbox;
    }
    
    private TilePane agregarTile(){
        TilePane tile = new TilePane();
        tile.setHgap(8);
        tile.setPrefColumns(3);
     
        Image img1 = new Image(RUTA_IMG1);
        for (int i = 0; i < 4; i++) {
            tile.getChildren().add(new ImageView(img1));
        }
        return tile;
    }

}
