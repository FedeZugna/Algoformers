package model;

import model.superficies.*;

public interface Interactuable {

	public Casillero getUbicacion();

	public String getNombre();

	public boolean estaVivo();

	public void fueUbicadoEn(Casillero casillero);

	public void aplicarseEfectosSuperficie(Superficie superficie);
}
