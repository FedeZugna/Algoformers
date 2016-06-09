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
	// private TerrenoAire aire;
	// private TerrenoTierra tierra;
	// private Object ocupante; //Object hasta definir clase de interactuables
	// debiera ser un algoformer o un "interactuable"? En este tp solo se
	// usan algoformers para ocupar casilleros
	// LA CHISPA ES OTRO INTERACTUABLE
	private Coordenada ubicacion;
	private Terreno terreno;
	// private superficieAire;
	private Interactuable ocupante;

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

	public void ubicarElemento(Interactuable ocupanteAAgregar) {
		// si esta ocupado resolver
		this.ocupante = ocupanteAAgregar;
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

		System.out.println(algo1.getVelocidad_despl());

		System.out.println(this.getUbicacion().getAlto());
		System.out.println(this.getUbicacion().getLargo());

		System.out.println(origen.getUbicacion().getAlto());
		System.out.println(origen.getUbicacion().getLargo());

		return origen.getUbicacion().esAlcanzable(this.getUbicacion(), algo1.getVelocidad_despl() / valorPasos);
	}

	public Coordenada getUbicacion() {
		return this.ubicacion;
	}

//agregue esto
	public Terreno getTerreno() {
		return this.terreno;
	}

}
