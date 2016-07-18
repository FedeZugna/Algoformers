/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import model.algoformers.*;

/**
 *
 * @author Martin
 */
public class Master {
	// singleton
	private Master() {
	}

	private static Master instancia = new Master();

	public static Master getInstancia() {
		return instancia;
	}

	private Algoformer algofActual;

	public Algoformer devolverAlgoformerActual() {
		return this.algofActual;
	}

	public void terminarTurno() {
		Tablero.getInstancia().pasarTurno();
	}

}
