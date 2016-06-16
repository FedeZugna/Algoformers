/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerEntrega;

import org.junit.Test;


import java.util.ArrayList;

import model.*;
import model.algoformers.EstadoAlgoformer;
import model.algoformers.EstadoHumanoide;

import org.junit.Assert;

/**
 *
 * @author Martin
 */
public class ListaCircularEstaticaTests {

	public ListaCircularEstaticaTests() {
	}

	@Test
	public void pruebaListaCircularSeCreaVacia() {
		ArrayList<EstadoAlgoformer> lista_vacia = new ArrayList<>();
		ListaCircularEstatica lista = new ListaCircularEstatica(lista_vacia);
		Assert.assertTrue(lista.isEmpty());
	}

	@Test
	public void pruebaListaCircularSeLlena() {
		ArrayList<EstadoAlgoformer> lista = new ArrayList<>();
		EstadoAlgoformer pruebaUno = new EstadoHumanoide(1, 1, 1);
		lista.add(pruebaUno);
		ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
		Assert.assertFalse(listaCirc.isEmpty());
	}

	@Test
	public void pruebaListaCircularEsCircularPara1Elemento() {
		ArrayList<EstadoAlgoformer> lista = new ArrayList<>();
		EstadoAlgoformer pruebaUno = new EstadoHumanoide(1, 1, 1);
		lista.add(pruebaUno);
		ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
		Assert.assertTrue(listaCirc.get() == pruebaUno);
		Assert.assertTrue(listaCirc.get() == pruebaUno);
	}

	@Test
	public void pruebaListaCircularEsCircularPara2Elementos() {
		ArrayList<EstadoAlgoformer> lista = new ArrayList<>();
		EstadoAlgoformer pruebaUno = new EstadoHumanoide(1, 1, 1);
		lista.add(pruebaUno);
		EstadoAlgoformer pruebaDos = new EstadoHumanoide(2, 2, 2);
		lista.add(pruebaDos);
		ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
		Assert.assertTrue(listaCirc.get() == pruebaUno);
		Assert.assertTrue(listaCirc.get() == pruebaDos);
		Assert.assertTrue(listaCirc.get() == pruebaUno);
		Assert.assertTrue(listaCirc.get() == pruebaDos);
	}

}
