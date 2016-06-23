package view;

import java.util.HashMap;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Coordenada;
import view.VistaCasilleros;

public class ContenedorPrincipal extends BorderPane {

    private static final String TITULO_JUEGO = "Algoformers";

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    HBox contenedorCentral;
    HashMap<Coordenada, Canvas> casilleros;

    public ContenedorPrincipal(Stage stage) {
    	stage.setTitle(TITULO_JUEGO);
        this.setRight(new VBoxStatsYOrdenesDisponibles());
        this.setMenu(stage);
        this.setCentro();
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {

    	this.casilleros = new HashMap<Coordenada, Canvas>();
        HBox hbox = new HBox();
        VBox vbox;
		for (int i = 1; i <= 15; i++) {
			vbox = new VBox();
			for (int j = 1; j <= 10; j++) {
				casilleros.put(new Coordenada(i,j), new Canvas(100,100));
				vbox.getChildren().add(casilleros.get((new Coordenada(i,j))));
		    	//Image imagenOpt = new Image("file:src/vista/imagenes/megatron.jpeg");
		    	//casilleros.get(new Coordenada(i,j)).getGraphicsContext2D().drawImage(imagenOpt, 1, 1, 100, 100);
 
			}
			hbox.getChildren().add(vbox);
		}
    	contenedorCentral=hbox;
    	contenedorCentral.setAlignment(Pos.CENTER);
    	Image imagen = new Image("file:src/vista/imagenes/fondo.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        VistaCasilleros vistaCasillero = new VistaCasilleros(casilleros);
        vistaCasillero.dibujar();
        this.setCenter(contenedorCentral);
    }
    
    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

    /**
     * Agrega el borde de la pantalla indicando el estado del juego (DEVNOTE: DE ALGUNA MANERA)
    */
    private HBox agregarEstadoDelJuego(){
        HBox hbox = new HBox();
        // actualizar
        return hbox;
    }
   
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
