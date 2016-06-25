package view;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import model.Casillero;
import model.Coordenada;
import model.Tablero;

public class CanvasImagenCasillero extends Canvas {
	CanvasImagenCasillero(int i,int j, VBoxStatsYOrdenesDisponibles barra){
		super(i,j);
		this.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				Casillero cas = Tablero.getInstancia().devolverCasillero(new Coordenada(i,j));
				barra.actualizarStatsConCasillero(cas);
			}
			
		}
	);
	}
}
