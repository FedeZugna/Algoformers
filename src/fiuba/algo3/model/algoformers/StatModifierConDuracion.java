/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.algoformers;

import model.Notificable;

/**
 *
 * @author Martin
 */
public abstract class StatModifierConDuracion extends StatModifier implements Notificable {

	private int duracion;

	@Override
	public void notificar() {
		this.duracion--;
		if (this.duracion == 0) {
			this.destruir();
		}
	}

    public StatModifierConDuracion(int duracion) {
        this.duracion = duracion;
    }
        
        

}
