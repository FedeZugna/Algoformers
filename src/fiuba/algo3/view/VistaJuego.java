package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import model.Juego;

public class VistaJuego {

    private Juego juego;
    Canvas canvas;

    public VistaJuego(Juego juego, Canvas canvas) {
        this.juego= juego;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        //canvas.getGraphicsContext2D().fillOval(robot.getPosicion().getX() + 230, robot.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update() {
        this.dibujar();
    }

}
