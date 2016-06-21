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
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane border = new BorderPane();
        VBoxStatsYOrdenesDisponibles statsYOrdenes = new VBoxStatsYOrdenesDisponibles();
        
        border.setCenter(agregarTile());
        //border.setBottom(addVBox());
        border.setRight(statsYOrdenes);
        
        
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

    /*
    * Creates an HBox with two buttons for the top region
    */
    
    private HBox addHBox(VBoxStatsYOrdenesDisponibles asd) {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        
        
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
