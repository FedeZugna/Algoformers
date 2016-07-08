package view;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import model.Casillero;
import model.Coordenada;
import model.Tablero;

public class CanvasImagenCasillero extends Canvas {
	CanvasImagenCasillero(int i,int j,Casillero cas, VBoxStatsYOrdenesDisponibles barra){
		super(i,j);
		this.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				barra.actualizarStatsConCasillero(cas);
			}
			
		}
	);
	}
}
