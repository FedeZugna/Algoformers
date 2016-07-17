/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceraEntrega;

import model.*;
import model.algoformers.*;
import model.bonus.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class tercerEntregaTests {

	public tercerEntregaTests() {
	}

	@Before
	public void before() {
		Tablero tablero = Tablero.getInstancia();
		tablero.reiniciarTablero();
	}

	@Test
	public void DobleCanionDuplicaDanioPor3TurnosPropiosAHumanoide() {

		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Coordenada coord3 = new Coordenada(3, 2);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		Algoformer megatron = new Megatron();
		DobleCanion dobleCanion = new DobleCanion();
		tablero.ubicarElemento(optimus, coord1);
		tablero.ubicarElemento(megatron, coord2);
		tablero.ubicarElemento(dobleCanion, coord3);
		// antes de capturar el bonus
		int danio_base = optimus.getAtaque();
		int vidaEsperadaEnemigo = megatron.getVida();
		optimus.capturarBonus(dobleCanion); // capturar toma 1 turno
		dobleCanion.notificar();// termino el turno ese

		optimus.atacar(megatron); // primer turno con buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - 2 * danio_base;
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		dobleCanion.notificar(); // pasa el primer turno

		optimus.atacar(megatron); // segundo turno con buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - 2 * danio_base;
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		dobleCanion.notificar(); // pasa el segundo turno

		optimus.atacar(megatron); // tercer turno con buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - 2 * danio_base;
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		dobleCanion.notificar(); // pasa el tercer turno

		optimus.atacar(megatron); // ya no tiene buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - danio_base;// ya no saca el
																// doble
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
	}

	@Test
	public void DobleCanionDuplicaDanioPor3TurnosPropiosAAlterno() {

		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Coordenada coord3 = new Coordenada(3, 2);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		Algoformer megatron = new Megatron();
		DobleCanion dobleCanion = new DobleCanion();
		tablero.ubicarElemento(optimus, coord1);
		tablero.ubicarElemento(megatron, coord2);
		tablero.ubicarElemento(dobleCanion, coord3);
		// pasa optimus a modo alterno
		optimus.transformar();
		// antes de capturar el bonus
		int danio_base = optimus.getAtaque();
		int vidaEsperadaEnemigo = megatron.getVida();
		optimus.capturarBonus(dobleCanion); // capturar toma 1 turno
		dobleCanion.notificar();// termino el turno ese

		optimus.atacar(megatron); // primer turno con buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - 2 * danio_base;
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		dobleCanion.notificar(); // pasa el primer turno

		optimus.atacar(megatron); // segundo turno con buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - 2 * danio_base;
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		dobleCanion.notificar(); // pasa el segundo turno

		optimus.atacar(megatron); // tercer turno con buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - 2 * danio_base;
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		dobleCanion.notificar(); // pasa el tercer turno

		optimus.atacar(megatron); // ya no tiene buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - danio_base;// ya no saca el
																// doble
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
	}

	@Test
	public void BurbujaAnulaDanioPor2TurnosPropiosAHumanoide() {
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Coordenada coord3 = new Coordenada(3, 2);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		Algoformer megatron = new Megatron();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		tablero.ubicarElemento(optimus, coord1);
		tablero.ubicarElemento(megatron, coord2);
		tablero.ubicarElemento(burbuja, coord3);
		// antes de capturar el bonus
		int danio_base = optimus.getAtaque();
		int vidaEsperadaEnemigo = megatron.getVida();

		megatron.capturarBonus(burbuja); // capturar toma 1 turno
		burbuja.notificar();// termino el turno ese

		optimus.atacar(megatron);
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		// primer turno con buff
		burbuja.notificar(); // pasa el primer turno

		optimus.atacar(megatron);
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		// segundo turno con buff
		burbuja.notificar(); // pasa el segundo turno

		optimus.atacar(megatron); // ya no tiene buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - danio_base;// ahora si lo
																// dania
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
	}

	@Test
	public void BurbujaAnulaDanioPor2TurnosPropiosAAlterno() {
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Coordenada coord3 = new Coordenada(3, 2);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		Algoformer megatron = new Megatron();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		tablero.ubicarElemento(optimus, coord1);
		tablero.ubicarElemento(megatron, coord2);
		tablero.ubicarElemento(burbuja, coord3);
		// transformo a megatron
		megatron.transformar();
		// antes de capturar el bonus
		int danio_base = optimus.getAtaque();
		int vidaEsperadaEnemigo = megatron.getVida();

		megatron.capturarBonus(burbuja); // capturar toma 1 turno
		burbuja.notificar();// termino el turno ese

		optimus.atacar(megatron);
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		// primer turno con buff
		burbuja.notificar(); // pasa el primer turno

		optimus.atacar(megatron);
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
		// segundo turno con buff
		burbuja.notificar(); // pasa el segundo turno

		optimus.atacar(megatron); // ya no tiene buff
		vidaEsperadaEnemigo = vidaEsperadaEnemigo - danio_base;// ahora si lo
																// dania
		assertTrue(vidaEsperadaEnemigo == megatron.getVida());
	}

	@Test
	public void FlashTriplicaVelocidadPor3TurnosPropiosAHumanoide() {
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		Flash flash = new Flash();
		tablero.ubicarElemento(optimus, coord1);
		tablero.ubicarElemento(flash, coord2);
		// antes de capturar el bonus
		int velocidad_base = optimus.getVelocidad_despl();

		optimus.capturarBonus(flash);

		assertTrue(optimus.getVelocidad_despl() == (3 * velocidad_base));
	}

	@Test
	public void FlashTriplicaVelocidadPor3TurnosPropiosAAlterno() {
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		Flash flash = new Flash();
		tablero.ubicarElemento(optimus, coord1);
		tablero.ubicarElemento(flash, coord2);
		// transformo a optimus
		optimus.transformar();
		// antes de capturar el bonus
		int velocidad_base = optimus.getVelocidad_despl();

		optimus.capturarBonus(flash);

		assertTrue(optimus.getVelocidad_despl() == (3 * velocidad_base));
	}
}
