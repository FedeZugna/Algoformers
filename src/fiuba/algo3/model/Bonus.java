package model;

import model.superficies.Superficie;

public abstract class Bonus implements Notificable, Interactuable {

	@Override
	public Casillero getUbicacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ubicarEn(Casillero casillero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarseEfectosSuperficie(Superficie superficie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub

	}

}
