package view;

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

        stage.setTitle("Algoformers");

        Juego juego = new Juego();
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego.obtenerJugadorActual(), juego);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, juego.obtenerJugadorActual());
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }
}
