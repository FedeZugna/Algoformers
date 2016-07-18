package view;

import controller.Master;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.eventos.AplicacionOnKeyPressEventHandler;
import model.*;

public class Aplicacion extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {

                Master.getInstancia().crearNuevoJuego(stage);
                Master.getInstancia().iniciarJuego();
	}
}
