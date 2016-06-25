/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.superficies;

import model.excepciones.NoPuedeMoverseException;
import model.algoformers.*;
/**
 *
 * @author Martin
 */
public abstract class EspacioAereo extends Superficie {

	protected static int CantidadMovimientosEstandarAereo = 1;
	private String nombre;
	
	@Override
	public int getPasos_humanoide() {
		throw new NoPuedeMoverseException();
	}
	public String devuelveNombreCont(){
		return nombre;
	}
	
	protected void agregarRutaDeImagen (String nombreDeRuta){
		this.nombre= nombreDeRuta;
	}


}
