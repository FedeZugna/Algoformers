/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerEntrega;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import controller.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Coordenada;
import model.Juego;
import model.Jugador;
import model.Tablero;
import model.algoformers.AlcanceExcedidoException;
import model.algoformers.Algoformer;
import model.algoformers.AtaqueInvalidoException;
import model.algoformers.Megatron;
import model.algoformers.NoPuedeMoverseException;
import model.algoformers.Optimus;

/**
 *
 * @author Martin
 */
@SuppressWarnings("unused")
public class PrimerEntregaTests {

	@Before
	public void before(){
		Tablero tablero= Tablero.getInstancia();
		tablero.reiniciarTablero();
	}
	
	@Test
	public void test01agregarAlgoformerHumanoideYMoverlo() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, VERT1 = 10, HORIZ2 = 11, VERT2 = 11;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		Algoformer algof1 = new Optimus();
		jug1.ubicarElemento(algof1, coord1);
		jug1.mover(algof1, tablero1.devolverCasillero(coord2));
		assertTrue(algof1.getUbicacion() == tablero1.devolverCasillero(coord2));
	}

	@Test (expected = NoPuedeMoverseException.class)
	public void test02agregarAlgoformerHumanoideYIntentaMoverloFueraDeRango() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, HORIZ2 = 11, VERT1 = 19, VERT2 = 20;

		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		Algoformer algof1 = new Optimus();
		jug1.ubicarElemento(algof1, coord1);
		jug1.mover(algof1, tablero1.devolverCasillero(coord2));

		Coordenada posicionInicial= new Coordenada(1,1);
		Coordenada destino1= new Coordenada(1,2);
		Coordenada destino2= new Coordenada(1,3);
		Coordenada destino3= new Coordenada(1,4);
		Coordenada destino4= new Coordenada(1,5);
		Coordenada destino5= new Coordenada(1,6);
		Tablero tablero= Tablero.getInstancia();
		Jugador jugador= new Jugador(tablero, "AUTOBOTS");
		Algoformer optimus= jugador.devolverEquipo().get(0);
		jugador.ubicarElemento(optimus, posicionInicial);
		System.out.println(optimus.getMovimientosRestantes());
		jugador.mover(optimus, tablero.devolverCasillero(destino1));
		System.out.println(optimus.getMovimientosRestantes());
		jugador.mover(optimus, tablero.devolverCasillero(destino2));
		System.out.println(optimus.getMovimientosRestantes());
		jugador.mover(optimus, tablero.devolverCasillero(destino3));
		System.out.println(optimus.getMovimientosRestantes());
		jugador.mover(optimus, tablero.devolverCasillero(destino4));
		System.out.println(optimus.getMovimientosRestantes());
		jugador.mover(optimus, tablero.devolverCasillero(destino5));

	}

	@Test
	public void test03transformarAlgoformerIdaYVuelta() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, VERT1 = 10;

		Tablero tablero1 = Tablero.getInstancia();
		Algoformer algof1 = new Optimus();

		algof1.transformar();
		Assert.assertTrue(algof1.getEstadoActual().getAtaque() == (15));
	}

	@Test
	public void test04agregarAlgoformerAlternoYMoverlo() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, HORIZ2 = 11, VERT1 = 10, VERT2 = 12;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		Algoformer algof1 = new Optimus();
		algof1.transformar();
		jug1.ubicarElemento(algof1, coord1);
		jug1.mover(algof1, tablero1.devolverCasillero(coord2));
		assertTrue(algof1.getUbicacion() == tablero1.devolverCasillero(coord2));
	}

	@Test
	public void test05InicializacionDeJuego() {

		Juego juego = new Juego();
//		juego.agregarJugador("AUTOBOTS");
//		juego.agregarJugador("DECEPTICONS");
//		juego.inicializarTablero();

		ArrayList<Algoformer> equipoD = new ArrayList<Algoformer>();
		equipoD = juego.devolverEquipoDe("DECEPTICONS");
		Assert.assertTrue(equipoD.size() == 3);
		Assert.assertTrue(equipoD.get(0).getNombre() == "Megatron");
		Assert.assertTrue(equipoD.get(1).getNombre() == "Bonecrusher");
		Assert.assertTrue(equipoD.get(2).getNombre() == "Frenzy");

		ArrayList<Algoformer> equipoA = new ArrayList<Algoformer>();
		equipoA = juego.devolverEquipoDe("AUTOBOTS");
		Assert.assertTrue(equipoA.size() == 3);
		Assert.assertTrue(equipoA.get(0).getNombre() == "Optimus");
		Assert.assertTrue(equipoA.get(1).getNombre() == "Bumblebee");
		Assert.assertTrue(equipoA.get(2).getNombre() == "Ratchet");

		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO / 2, Tablero.LIMITEALTO / 2))
				.getNombre() == "Chispa");

	}

	@Test
	public void test06algoformerNoPuedeAtacarseASiMismo() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, HORIZ2 = 11, VERT1 = 10, VERT2 = 12;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		Algoformer algof1 = new Megatron();
		jug1.ubicarElemento(algof1, coord1);
		Assert.assertTrue(Tablero.getInstancia().devolverElemento(coord1).getNombre() == "Megatron");
		jug1.atacar(algof1, coord1);
	}

	@Test(expected = AtaqueInvalidoException.class)
	public void test07algoformerNoPuedeAtacarCompaniero() {
		int HORIZ1 = 10, HORIZ2 = 13, VERT1 = 10, VERT2 = 13;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "AUTOBOTS");
		jug1.ubicarElemento(jug1.devolverEquipo().get(0), coord1);
		jug1.ubicarElemento(jug1.devolverEquipo().get(1), coord2);

		jug1.atacar(jug1.devolverEquipo().get(0), coord2);
	}

	@Test
	public void test08atacarEnemigoYVerificarDistanciaYDanio1() {

		int HORIZ1 = 10, HORIZ2 = 13, VERT1 = 10, VERT2 = 13;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();

		Algoformer algof1 = new Optimus();
		int vidaInicialOptimus = algof1.getVida();
		Algoformer algof2 = new Megatron();
		tablero1.ubicarElemento(algof1, coord1);
		tablero1.ubicarElemento(algof2, coord2);

		assertTrue(algof2.esAtaquePosible(coord1));

		algof2.atacar(algof1);
		assertTrue(algof1.getVida() < vidaInicialOptimus);
	}

	@Test(expected = AlcanceExcedidoException.class)
	public void test09atacarEnemigoYVerificarDistanciaYDanio2() {
		String NOMBRE_ALGOF1 = "Autobot1", NOMBRE_ALGOF2 = "Decepticon1";
		int ANCHO = 100, LARGO = 100, VIDA = 10, ATAQUE = 1, DISTANCIA_ATK1 = 1, VELOCIDAD_DESP = 10;
		int DISTANCIA_ATK2 = 10;
		int HORIZ1 = 10, HORIZ2 = 13, VERT1 = 10, VERT2 = 13;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Algoformer algof1 = new Optimus();
		Algoformer algof2 = new Megatron();
		tablero1.ubicarElemento(algof1, coord1);
		tablero1.ubicarElemento(algof2, coord2);

		assertFalse(algof1.esAtaquePosible(coord2));

		algof1.atacar(algof2);
	}

	@After
	public void after(){
		Tablero tablero= Tablero.getInstancia();
		tablero.reiniciarTablero();
	}
	
}
