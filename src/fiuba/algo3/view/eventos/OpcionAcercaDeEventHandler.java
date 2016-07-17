package view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent actionEvent) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Acerca de...");
		alert.setHeaderText("Programa Algoformers");
		String mensaje = "75.07 Algoritmos y  programacion III.\n "
				+ "Integrantes:\n Nicolas Continanza\n Juan Leffler\n Martin Errazquin\n LucasCatolino";
		alert.setContentText(mensaje);
		alert.show();
	}
}
