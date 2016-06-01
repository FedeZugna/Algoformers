package model;


public class Chispa implements Interactuable {

	protected Coordenada ubicacion;
	protected String nombre= "Chispa";
	
	@Override
	public Coordenada getUbicacion() {
		return ubicacion;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean estaVivo() {
		return true;
	}

	
}