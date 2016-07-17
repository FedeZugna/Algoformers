/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bonus;

import model.Notificable;

/**
 *
 * @author Martin
 */
public abstract class StatModifierConDuracion extends StatModifier implements Notificable {

	private int turnosRestantes;

	@Override
	public void notificar() {
		this.turnosRestantes--;
		if (this.turnosRestantes < 0) {
			this.destruir();
		}
	}

	public StatModifierConDuracion(int duracion) {
		this.turnosRestantes = duracion;
	}

}
