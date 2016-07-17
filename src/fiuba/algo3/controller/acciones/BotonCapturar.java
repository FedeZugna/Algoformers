/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.acciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author Martin
 */
public class BotonCapturar extends Button {
	private static final String TEXTO_CAPTURAR = "Capturar";

	public BotonCapturar() {
		super(TEXTO_CAPTURAR);
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/*
				 * Casillero casilleroObjetivo =
				 * Master.getInstancia().pedirObjetivo(); Interactuable objetivo
				 * = casilleroObjetivo.devolverElemento(); Algoformer
				 * algofActual =
				 * Master.getInstancia().devolverAlgoformerActual();
				 * algofActual.capturar(objetivo);
				 * Master.getInstancia().terminarTurno();
				 */
			}
		});
	}
}
