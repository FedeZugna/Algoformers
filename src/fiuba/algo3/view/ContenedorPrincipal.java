package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Juego;

public class ContenedorPrincipal extends BorderPane {

    private static final String TITULO_JUEGO = "Algoformers";
    private static final String RUTA_IMG1 = "fotos/prueba1.png";

    BarraDeMenu menuBar;
    VistaJuego vistaJuego;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage, Juego juego) {
        
        this.setRight(new VBoxStatsYOrdenesDisponibles());
        this.setMenu(stage);
        this.setCentro(juego);
      //this.setConsola();
      //this.setBotonera(juego);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Juego juego) {

    	canvasCentral = new Canvas(460, 220);
        vistaJuego = new VistaJuego(juego, canvasCentral);
        vistaJuego.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    	/*
    	 * StackPane sp = new StackPane();
    	 
        Image img = new Image("file:src/optimus.jpg");
        ImageView imgView = new ImageView(img);
        sp.getChildren().add(imgView);
        //Adding HBox to the scene
    	*/
    	
    	
    	
    }
    
    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
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
        // actualizar
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
    

  /* private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }*/

    /*private void setBotonera(Juego juego) {

	
	Button botonMover = new Button();
    botonMover.setText("Mover");
    BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaJuego, juego);
    botonMover.setOnAction(moveButtonHandler);
	
	
    Button botonDireccion = new Button();
    botonDireccion.setText("Cambiar direccion");
    BotonDireccionHandler directionButtonHandler = new BotonDireccionHandler(robot);
    botonDireccion.setOnAction(directionButtonHandler);

    VBox contenedorVertical = new VBox(botonMover, botonDireccion);
    contenedorVertical.setSpacing(10);
    contenedorVertical.setPadding(new Insets(15));

    this.setLeft(contenedorVertical);

}*/
   
}
