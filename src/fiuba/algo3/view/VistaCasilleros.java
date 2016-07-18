package view;

import java.util.HashMap;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import model.Coordenada;
import model.Tablero;

public class VistaCasilleros {

	private HashMap<Coordenada, Canvas> casilleros;
	private Tablero tablero = Tablero.getInstancia();

	public VistaCasilleros(HashMap<Coordenada, Canvas> casilleros) {
		this.casilleros = casilleros;
	}

	public void dibujar() {
		for (Coordenada coordHash : casilleros.keySet()) {
			String ruta = tablero.devolverCasillero(coordHash).devuelveRutaImgCont();
			Image imagen = new Image(ruta);
			casilleros.get(coordHash).getGraphicsContext2D().drawImage(imagen, 1, 1, 75, 75);
		}
	}

	public void dibujarAereo() {
		for (Coordenada coordHash : casilleros.keySet()) {
			String ruta = tablero.devolverCasillero(coordHash).devuelveRutaImgContAereo();

			Image imagen = new Image(ruta);
			casilleros.get(coordHash).getGraphicsContext2D().drawImage(imagen, 1, 1, 75, 75);
		}
	}

	public void update() {
		dibujar();
	}

	public void updateAereo() {
		dibujarAereo();
	}

}
