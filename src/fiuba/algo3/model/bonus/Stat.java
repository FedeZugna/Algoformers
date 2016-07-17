/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bonus;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Martin
 */
public class Stat {
	private LinkedList<StatModifier> modificadores;
	private int stat_base;

	public Stat(int stat_base) {
		this.stat_base = stat_base;
		this.modificadores = new LinkedList<>();
	}

	/**
	 * Agrega el modificador recibido a los modificadores del stat. IMPORTANTE:
	 * 
	 * @param modificador
	 *            no debe ser el mismo efecto que un efecto existente en el
	 *            stat.
	 */
	public void agregarModificador(StatModifier modificador) {
		for (StatModifier modif_existente : this.modificadores) {
			if (modif_existente.sonElMismoEfecto(modificador)) {
				return;
			}
		}
		modificador.cambiarDuenio(this);
		this.modificadores.add(modificador);
	}

	public int devolverStat() {
		int stat = this.stat_base;
		Iterator<StatModifier> iterador = this.modificadores.iterator();
		while (iterador.hasNext()) {
			stat = iterador.next().aplicarModificador(stat);
		}
		return stat;
	}

	public void quitarModificador(StatModifier modificador) {
		this.modificadores.remove(modificador);
	}

	public void cambiarValorBase(int valor_base_nuevo) {
		this.stat_base = valor_base_nuevo;
	}
}
