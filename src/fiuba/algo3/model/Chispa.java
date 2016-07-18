package model;

import model.excepciones.AccionInvalidaException;
import model.superficies.Superficie;
import model.algoformers.*;

public class Chispa implements Interactuable {

	protected Casillero ubicacion;
	protected String nombre = "Chispa";
	final private String rutaImg = "file:src/fotos/Chispa/Chispa.png";

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
		throw new AccionInvalidaException();
	}

	@Override
	public void aplicarseEfectosSuperficie(Superficie superficie) {

	}

	@Override
	public void setUbicacion(Casillero ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String devuelveNombreCont() {
		return this.rutaImg;
	}

	public void serCapturadoPor(Algoformer algoformer) {
                Tablero.getInstancia().chispaFueCapturada(algoformer);
	}

}
