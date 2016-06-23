package view;

import java.util.HashMap;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import model.Casillero;
import model.Coordenada;
import model.Interactuable;
import model.Tablero;

public class VistaCasillero {

	private HashMap<Coordenada, Canvas> casilleros;
	private Tablero tablero = Tablero.getInstancia();
	
	public VistaCasillero(HashMap<Coordenada, Canvas> casilleros) {
		this.casilleros = casilleros ;
	}

	public void dibujar() {
		for (Coordenada coordHash : casilleros.keySet()){
			dibujarCont(tablero.devolverCasillero(coordHash));
		}
	}

	private void dibujarCont(Casillero cas) {
    	String contCas = cas.devuelveNombreCont();
		Image imagen = new Image("file:src/vista/imagenes/"+ contCas +".jpeg");
		casilleros.get(cas.getUbicacion()).getGraphicsContext2D().drawImage(imagen, 1, 1, 100, 100);
	}
	public void update(){
		dibujar();
	}

}
