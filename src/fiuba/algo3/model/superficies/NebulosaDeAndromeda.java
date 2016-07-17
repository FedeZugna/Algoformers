/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.superficies;

import model.Tablero;
import model.algoformers.*;
import model.bonus.Inmobilizador;
import model.bonus.StatModifierConDuracion;

/**
 *
 * @author Martin
 */
public class NebulosaDeAndromeda extends EspacioAereo {
	private static int DURACION_TURNOS_INMOBILIZADO = 3;
	private String nombre = "file:src/fotos/Terrenos/Nebulosa.png";

	public NebulosaDeAndromeda() {
		agregarRutaDeImagen(nombre);
	}

	@Override
	public int getPasos_alterno() {
		return EspacioAereo.CantidadMovimientosEstandarAereo;
	}

	public void aplicarEfectosSuperficieAlgoformer(Algoformer a) {
		StatModifierConDuracion inmobilizadorNebulosa = new Inmobilizador(DURACION_TURNOS_INMOBILIZADO);
		a.agregarModificadorVelocidadDesplazamiento(inmobilizadorNebulosa);
		Tablero.getInstancia().agregarNotificable(inmobilizadorNebulosa);
	}

}
