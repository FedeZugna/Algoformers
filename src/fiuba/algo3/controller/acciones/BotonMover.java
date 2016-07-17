/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.acciones;

import controller.Master;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Casillero;
import model.algoformers.Algoformer;

/**
 *
 * @author Martin
 */
public class BotonMover extends Button {
	private static final String TEXTO_MOVER = "Mover";

	public BotonMover() {
		super(TEXTO_MOVER);
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// se ocupa de mover (falta pedir algoformer y casillero
				// objetivo)

				Casillero objetivo = Master.getInstancia().pedirObjetivo();
				Algoformer algofActual = Master.getInstancia().devolverAlgoformerActual();
				algofActual.mover(objetivo);
				Master.getInstancia().terminarTurno();
			}
		});
	}
}
