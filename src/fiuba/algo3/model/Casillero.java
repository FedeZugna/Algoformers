/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.excepciones.*;
import model.superficies.*;
import model.algoformers.*;
import model.bonus.*;
import model.*;

/**
 *
 * @author Martin
 */
public class Casillero {

	private Coordenada ubicacion;
	private Terreno terreno;
	private EspacioAereo espacioAereo;
	private Interactuable ocupante = null;

	public Casillero(Terreno terreno, EspacioAereo aire) {
		this.terreno = terreno;
		this.espacioAereo = aire;
		this.ocupante = null;
	}

	public void setUbicacion(Coordenada ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setTerreno(Terreno superficie) {
		this.terreno = superficie;
	}

	public EspacioAereo getEspacioAereo() {
		return espacioAereo;
	}

	public void setEspacioAereo(EspacioAereo espacioAereo) {
		this.espacioAereo = espacioAereo;
	}

	public boolean casilleroOcupado() {
		return (this.ocupante != null);
	}

	public void ubicarElemento(Interactuable ocupanteAAgregar) {
		if (this.casilleroOcupado()) {
			throw new CasilleroOcupadoException();
		}
		this.ocupante = ocupanteAAgregar;
		ocupanteAAgregar.ubicarEn(this);
		this.aplicarEfectosSuperficie(ocupanteAAgregar);
	}

	public Interactuable devolverElemento() {
		return this.ocupante;
	}

	public void removerElemento() {
		ocupante.setUbicacion(null);
		ocupante = null;

	}

	public boolean puedeMoverseAca(Algoformer algo1, Casillero origen) {
		int valorPasos = algo1.devolverPasosPara(this.terreno);
		return origen.getUbicacion().esAlcanzable(this.getUbicacion(), algo1.getVelocidad_despl() / valorPasos);
	}

	public Coordenada getUbicacion() {
		return this.ubicacion;
	}

	public Superficie getTerreno() {
		return this.terreno;
	}

	public void aplicarEfectosSuperficie(Interactuable ocupanteAAgregar) {
		// this.terreno.aplicarEfectosSuperficie(this);
	}

	public String devuelveRutaImgCont() {
		if (ocupante == null) {
			return terreno.devuelveNombreCont();
		}
		return ocupante.devuelveNombreCont();

	}

	public String devuelveRutaImgContAereo() {
		if (ocupante == null) {
			return espacioAereo.devuelveNombreCont();
		}
		return ocupante.devuelveNombreCont();
	}
}
