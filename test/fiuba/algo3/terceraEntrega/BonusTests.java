/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceraEntrega;

import model.Coordenada;
import model.Juego;
import model.Tablero;
import model.algoformers.Algoformer;
import model.algoformers.Ataque;
import model.algoformers.AtaqueEstandar;
import model.algoformers.Megatron;
import model.algoformers.Optimus;
import model.bonus.BurbujaInmaculada;
import model.bonus.DobleCanion;
import model.bonus.Flash;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Martin
 */
public class BonusTests {

	@Before
	public void before() {
		Tablero.getInstancia().reiniciarTablero();
	}

	@Test
	public void DobleCanionDuplicaElDanio() {
		int danio_base, danio_bonificado;
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		tablero.ubicarElemento(optimus, coord1);
		danio_base = optimus.getAtaque();
		DobleCanion dobleCanion = new DobleCanion();
		tablero.ubicarElemento(dobleCanion, coord2);
		optimus.capturarBonus(dobleCanion);
		danio_bonificado = optimus.getAtaque();
		Assert.assertTrue((2 * danio_base) == danio_bonificado);
	}

	@Test
	public void DobleCanionDura3Turnos() {
		int danio_base, danio_bonificado;
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimuss = new Optimus();
		tablero.ubicarElemento(optimuss, coord1);
		danio_base = optimuss.getAtaque();
		DobleCanion dobleCanionn = new DobleCanion();
		tablero.ubicarElemento(dobleCanionn, coord2);
		optimuss.capturarBonus(dobleCanionn);
		dobleCanionn.notificar();// el turno que pasa capturando
		dobleCanionn.notificar();
		dobleCanionn.notificar();
		dobleCanionn.notificar();
		danio_bonificado = optimuss.getAtaque();
		Assert.assertTrue(danio_base == danio_bonificado);
	}

	@Test
	public void BurbujaInmaculadaAnulaDanioRecibido() {
		int VIDA_BASE, DANIO = 10;
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		tablero.ubicarElemento(optimus, coord1);
		VIDA_BASE = optimus.getVida();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		tablero.ubicarElemento(burbuja, coord2);
		optimus.capturarBonus(burbuja);
		Ataque ataque = new AtaqueEstandar(DANIO);
		ataque.ataqueEjecutar(optimus);
		Assert.assertTrue(optimus.getVida() == VIDA_BASE);
	}

	@Test
	public void BurbujaInmaculadaDura2Turnos() {
		int VIDA_ESPERADA, DANIO = 10;
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		tablero.ubicarElemento(optimus, coord1);
		VIDA_ESPERADA = optimus.getVida() - DANIO;
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		tablero.ubicarElemento(burbuja, coord2);
		optimus.capturarBonus(burbuja);
		burbuja.notificar();// pasa el turno que lo capturo
		burbuja.notificar();// primer turno
		burbuja.notificar();// segundo turno
		// ya no tiene mas burbuja
		Ataque ataque = new AtaqueEstandar(DANIO);
		ataque.ataqueEjecutar(optimus);
		Assert.assertTrue(optimus.getVida() == VIDA_ESPERADA);

	}

	@Test
	public void FlashTriplicaVelocidadDesplazamiento() {
		int velocidad_base, velocidad_bonificada;
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		tablero.ubicarElemento(optimus, coord1);
		velocidad_base = optimus.getVelocidad_despl();
		Flash flash = new Flash();
		tablero.ubicarElemento(flash, coord2);
		optimus.capturarBonus(flash);
		velocidad_bonificada = optimus.getVelocidad_despl();
		Assert.assertTrue((3 * velocidad_base) == velocidad_bonificada);
	}

	@Test
	public void FlashDura3Turnos() {
		int velocidad_base, velocidad_bonificada;
		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 4);
		Tablero tablero = Tablero.getInstancia();
		Juego juego = new Juego();
		tablero.definirJuego(juego);
		Algoformer optimus = new Optimus();
		tablero.ubicarElemento(optimus, coord1);
		velocidad_base = optimus.getVelocidad_despl();
		Flash flash = new Flash();
		tablero.ubicarElemento(flash, coord2);
		optimus.capturarBonus(flash);
		flash.notificar(); // el turno que gasta capturando
		flash.notificar();
		flash.notificar();
		flash.notificar();
		velocidad_bonificada = optimus.getVelocidad_despl();
		Assert.assertTrue(velocidad_base == velocidad_bonificada);
	}
}
