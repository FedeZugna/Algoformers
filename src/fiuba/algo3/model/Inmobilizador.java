/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Inmobilizador extends StatModifierConDuracion {

	@Override
	public int aplicarModificador(int stat) {
		throw new NoPuedeMoverseException();
	}

}
