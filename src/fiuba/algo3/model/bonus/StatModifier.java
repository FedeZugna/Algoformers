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
public abstract class StatModifier {
	private Stat duenio;

	public void cambiarDuenio(Stat duenio_nuevo) {
		this.duenio = duenio_nuevo;
	}

	public abstract int aplicarModificador(int stat);

	public void destruir() {
		this.duenio.quitarModificador(this);
	}

	public boolean sonElMismoEfecto(StatModifier otro) {
		return (this.getClass().equals(otro.getClass()));
	}
}
