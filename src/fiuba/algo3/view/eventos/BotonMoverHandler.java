package view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Robot;
import view.VistaJuego;

public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaJuego vista;
    private final Robot robot;

    public BotonMoverHandler(VistaJuego vista, Robot robot) {
        this.vista = vista;
        this.robot = robot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.robot.mover();
        this.vista.update();
    }
}
