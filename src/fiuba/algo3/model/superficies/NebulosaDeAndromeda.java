/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.superficies;

import model.algoformers.*;
import model.bonus.Inmobilizador;
import model.bonus.StatModifier;

/**
 *
 * @author Martin
 */
public class NebulosaDeAndromeda extends EspacioAereo {
        private static int DURACION_TURNOS_INMOBILIZADO = 3;
	@Override
	public int getPasos_alterno() {
		return EspacioAereo.CantidadMovimientosEstandarAereo;
	}
	
	public void aplicarEfectosSuperficieAlgoformer(Algoformer a){
            StatModifier inmobilizadorNebulosa = new Inmobilizador(DURACION_TURNOS_INMOBILIZADO);
            a.agregarModificadorVelocidadDesplazamiento(inmobilizadorNebulosa);
	}

}
