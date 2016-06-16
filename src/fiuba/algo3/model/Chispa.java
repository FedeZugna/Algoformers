package model;

import model.superficies.Superficie;

public class Chispa implements Interactuable {

	protected Casillero ubicacion;
	protected String nombre = "Chispa";

	@Override
	public Casillero getUbicacion() {
		return ubicacion;
	}

	@Override
	public void ubicarEn(Casillero casillero) {
		this.ubicacion = casillero;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean estaVivo() {
		return true;
	}

	@Override
	public void aplicarseEfectosSuperficie(Superficie superficie) {
		
	}

	@Override
	public void setUbicacion(Casillero ubicacion) {
		this.ubicacion = ubicacion;
	}

}
