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
import model.Casillero;
import model.Coordenada;
import model.Juego;
import model.Jugador;
import model.Tablero;
import view.VistaCasilleros;

public class ContenedorPrincipal extends BorderPane {

	private static final String TITULO_JUEGO = "Algoformers";
	// Juego juego;

	BarraDeMenu menuBar;
	HBox contenedorCentral;
	HashMap<Coordenada, Canvas> casilleros;
	VBoxStatsYOrdenesDisponibles barraDerecha;
	VistaCasilleros vistaCasilleros;

	public ContenedorPrincipal(Stage stage, Jugador jugador, Juego juego) {
		stage.setTitle(TITULO_JUEGO);
		this.barraDerecha = new VBoxStatsYOrdenesDisponibles(jugador, juego, this);
		this.setRight(this.barraDerecha);
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
		for (int i = 1; i <= Tablero.LIMITELARGO; i++) {
			vbox = new VBox();
			for (int j = 1; j <= Tablero.LIMITEALTO; j++) {
				Coordenada coord = new Coordenada(i, j);
				Casillero casillero = Tablero.getInstancia().devolverCasillero(coord);
				CanvasImagenCasillero canvas = new CanvasImagenCasillero(75, 75, casillero, this.barraDerecha);
				casilleros.put(coord, canvas);
				vbox.getChildren().add(casilleros.get(coord));
			}
			hbox.getChildren().add(vbox);
		}
		contenedorCentral = hbox;
		contenedorCentral.setAlignment(Pos.CENTER);

		Image imagen = new Image("file:src/fotos/fondo-juego.jpg");
		// BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
		// BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
		// BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		contenedorCentral.setBackground(new Background(imagenDeFondo));

		this.vistaCasilleros = new VistaCasilleros(casilleros);
		this.vistaCasilleros.dibujar();
		this.setCenter(contenedorCentral);
	}

	public BarraDeMenu getBarraDeMenu() {
		return menuBar;
	}

	public void vistaCasillerosUpdate() {
		this.vistaCasilleros.update();
	}

	public void vistaCasillerosUpdateAereo() {
		this.vistaCasilleros.updateAereo();
	}

	/**
	 * Agrega el borde de la pantalla indicando el estado del juego (DEVNOTE: DE
	 * ALGUNA MANERA)
	 */
	private HBox agregarEstadoDelJuego() {
		HBox hbox = new HBox();
		// actualizar
		return hbox;
	}

}
