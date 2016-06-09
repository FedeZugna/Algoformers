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
public class DobleCanion extends StatModifierConDuracion {

    public DobleCanion(int duracion) {
        super(duracion);
    }

	@Override
	public int aplicarModificador(int stat) {
		return 2 * stat;
	}

}
