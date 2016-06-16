/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.superficies;

import model.Algoformer;

/**
 *
 * @author Martin
 */
public class NebulosaDeAndromeda extends EspacioAereo {

	@Override
	public int getPasos_alterno() {
		return EspacioAereo.CantidadMovimientosEstandarAereo;
	}
	
	public void aplicarEfectosSuperficieAlgoformer(Algoformer a){	
		a.setVelocidadDespl(0);
	}

}
