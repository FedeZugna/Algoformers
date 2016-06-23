/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.excepciones.CasilleroOcupadoException;
import model.superficies.*;
import model.algoformers.*;

/**
 *
 * @author Martin
 */
public class Casillero {

	private Coordenada ubicacion;
	private Terreno terreno;
	private EspacioAereo espacioAereo;
	private Interactuable ocupante = null;

	public Casillero(Terreno terreno/* TerrenoAire aire, TerrenoTierra tierra */) {
		this.terreno = terreno;
		/*
		 * this.aire = aire; this.tierra = tierra;
		 */
		// this.ocupante = new CasilleroVacio();
		// this.ocupante= null;
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

	public boolean casilleroOcupado(){
		return (this.ocupante != null);
	}
	
	
	public void ubicarElemento(Interactuable ocupanteAAgregar) {
		if (this.casilleroOcupado()){
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
		ocupante.setUbicacion( null);
		ocupante = null;
		// this.ocupante = new CasilleroVacio();
	}
	/*
	 * public bool/void? accederCasillero(Algoformer algof){ ->si esta ocupado
	 * no dejar entrar ->aplicar condiciones de terreno //RECORDAR LIMPIAR EL
	 * OTRO CASILLERO }
	 */

	public boolean puedeMoverseAca(Algoformer algo1, Casillero origen) {
		int valorPasos = algo1.devolverPasosPara(this.terreno);
		return origen.getUbicacion().esAlcanzable(this.getUbicacion(), algo1.getVelocidad_despl() / valorPasos);
	}

	public Coordenada getUbicacion() {
		return this.ubicacion;
	}

//agregue esto
	public Terreno getTerreno() {
		return this.terreno;
	}

	public void aplicarEfectosSuperficie(Interactuable ocupanteAAgregar) {
		//this.terreno.aplicarEfectosSuperficie(this);
		
	}
	public String devuelveRutaImgCont() {
		if (ocupante!=null){
			return ocupante.devuelveNombreCont();
		}
		return terreno.devuelveNombreCont();
	}

}
