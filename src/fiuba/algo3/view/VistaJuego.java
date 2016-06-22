package view;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import model.Interactuable;
import model.Juego;
import model.Tablero;
import model.algoformers.Algoformer;

public class VistaJuego {

    private Juego juego;
    Canvas canvas;

    public VistaJuego(Juego juego, Canvas canvas) {
        this.juego= juego;
        this.canvas = canvas;
    }

    public void dibujar() { 
        this.clean();
        ArrayList<Algoformer> equipo1 = juego.devolverAlgoformersVivosDeJugador1();
        ArrayList<Algoformer> equipo2 = juego.devolverAlgoformersVivosDeJugador2();
        for (Algoformer temp : equipo1){
        	dibujar(temp);
        }
        for (Algoformer temp : equipo2){
        	dibujar(temp);
        }
        dibujar(juego.chispa);
        
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        //canvas.getGraphicsContext2D().fillOval(robot.getPosicion().getX() + 230, robot.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);
    }

    private void dibujar(Interactuable elemento) {
		
	}

	public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update() {
        this.dibujar();
    }

}
