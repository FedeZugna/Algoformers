/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.superficies.*;

/**
 *
 * @author Martin
 */
public class Casillero {

	private Coordenada ubicacion;
	private Terreno terreno;
	private EspacioAereo espacioAereo;
	private Interactuable ocupante;

	public Casillero(Terreno terreno/* TerrenoAire aire, TerrenoTierra tierra */) {
		this.terreno = terreno;
		this.espacioAereo = new Nube();
		this.ocupante= null;
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
		
		if (casilleroOcupado()){
			throw new CasilleroOcupadoException();
		}
		this.ocupante = ocupanteAAgregar;
		this.aplicarEfectosSuperficie(ocupanteAAgregar);
	}

	public Interactuable devolverElemento() {
		return this.ocupante;

	}

	public void removerElemento() {
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

	public void aplicarEfectosSuperficie(Interactuable ocupante) {
		this.terreno.aplicarEfectosSuperficie(ocupante);
		
	}

}
