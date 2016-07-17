/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bonus;

/**
 *
 * @author Martin
 */
public class ModificadorPorcentualPermanente extends StatModifier {
	private int porcentaje;

	/**
	 * Constructor de la clase.
	 * 
	 * @param porcentaje
	 *            indica un porcentaje (positivo o negativo) a agregar o quitar
	 *            del stat base.
	 */
	public ModificadorPorcentualPermanente(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public int aplicarModificador(int stat) {
		return (stat * (100 + porcentaje) / 100);
	}

}
