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
import model.algoformers.Algoformer;

/**
 *
 * @author Martin
 */
public class BotonTransformar extends Button {
	private static final String TEXTO_TRANSFORMAR = "Transformar";

	public BotonTransformar() {
		super(TEXTO_TRANSFORMAR);
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				Algoformer algofActual = Master.getInstancia().devolverAlgoformerActual();
				algofActual.transformar();
				Master.getInstancia().terminarTurno();

			}
		});
	}
}
