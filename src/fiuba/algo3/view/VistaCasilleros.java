package view;

import java.util.HashMap;


import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import model.Casillero;
import model.Coordenada;
import model.Tablero;

public class VistaCasilleros {

	private HashMap<Coordenada, Canvas> casilleros;
	private Tablero tablero = Tablero.getInstancia();
	
	public VistaCasilleros(HashMap<Coordenada, Canvas> casilleros) {
		this.casilleros = casilleros ;
	}

	public void dibujar() {
		for (Coordenada coordHash : casilleros.keySet()){
			dibujarCont(tablero.devolverCasillero(coordHash));
		}
	}

	private void dibujarCont(Casillero cas) {
		String ruta = "file:src/fiuba/algo3/fotos/pueba1.png";//cas.devuelveRutaImgCont();
		Image imagen = new Image(ruta);
		casilleros.get(cas.getUbicacion()).getGraphicsContext2D().drawImage(imagen, 1, 1, 100, 100);
	}
	public void update(){
		dibujar();
	}

}
