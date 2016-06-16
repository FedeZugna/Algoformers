package model.bonus;

import model.*;
import model.algoformers.Algoformer;
import model.superficies.Superficie;

public abstract class Bonus implements Notificable, Interactuable {
	
	private String nombre;
	private Casillero ubicacion;
	private int duracion;
	private Algoformer duenio;
	
	public Bonus(int duracion){
		this.duracion = duracion;
	}
	
	@Override
	public Casillero getUbicacion() {
		return this.ubicacion;
	}

	@Override
	public void setUbicacion(Casillero ubicacion) {
		this.ubicacion = ubicacion;
		
	}
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void ubicarEn(Casillero casillero) {
		this.ubicacion = casillero;
		casillero.ubicarElemento(this);
	}
	
	public boolean fueUbicadoEn(Casillero casillero){
		return this.ubicacion == casillero;
	}
	
	public abstract int aplicarBonus(int factor);

	@Override
	public void notificar() {
		this.duracion--;
		if (this.duracion == 0) {
			this.destruir();
		}
	}
	
	public void cambiarDuenio(Algoformer duenio){
		this.duenio = duenio;
	}
	public void destruir() {
		this.duenio.quitarBonus(this);
	}
	
	@Override
	public boolean estaVivo() {
		new AccionInvalidaException();
		return true;
	}
	
	@Override
	public void aplicarseEfectosSuperficie(Superficie superficie) {
		
	}
	
}
