package primerEntrega;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import model.*;
import model.superficies.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LucasTests {

	@Before
	public void before(){
		Tablero tablero= Tablero.getInstancia();
	}
	
	@Test
	public void test01InicializarTableroConUnOptimus() {
		Tablero tablero = Tablero.getInstancia();
		Algoformer optimus = new Optimus();
		Interactuable algoformer;
		Coordenada coordenadaOcupada = new Coordenada(1, 1);

		tablero.ubicarElemento(optimus, coordenadaOcupada);
		algoformer = tablero.devolverElemento(coordenadaOcupada);

		Assert.assertTrue(algoformer.getNombre() == "Optimus");
		Assert.assertTrue(algoformer.estaVivo());
	}

	@Test
	public void test02CrearJuegoYCreaUnMapa() {

		Assert.assertTrue(Tablero.getInstancia().devolverLargo() == 20);
		Assert.assertTrue(Tablero.getInstancia().devolverAlto() == 20);
	}

	@Test
	public void test03CrearJuegoConUnSoloJugadorYEquipoAutobots() {
		Juego juego = new Juego();
		juego.agregarJugador("AUTOBOTS");

		ArrayList<Algoformer> equipo;
		equipo = juego.devolverEquipoDe("AUTOBOTS");

		Assert.assertTrue(equipo.size() == 3);
		Assert.assertTrue(equipo.get(0).getNombre() == "Optimus");
		Assert.assertTrue(equipo.get(1).getNombre() == "Bumblebee");
		Assert.assertTrue(equipo.get(2).getNombre() == "Ratchet");
	}

	@Test
	public void test04CrearJuegoConUnSoloJugadorYEquipoDecepticons() {
		Juego juego = new Juego();
		juego.agregarJugador("DECEPTICONS");

		ArrayList<Algoformer> equipo = new ArrayList<Algoformer>();
		equipo = juego.devolverEquipoDe("DECEPTICONS");

		Assert.assertTrue(equipo.size() == 3);
		Assert.assertTrue(equipo.get(0).getNombre() == "Megatron");
		Assert.assertTrue(equipo.get(1).getNombre() == "Bonecrusher");
		Assert.assertTrue(equipo.get(2).getNombre() == "Frenzy");
	}

	@Test
	public void test05InicializarTableroParaUnJugador() {
		Juego juego = new Juego();
		juego.agregarJugador("AUTOBOTS");
		juego.posicionarAutobots();

		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre() == "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).getNombre() == "Bumblebee");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 3)).getNombre() == "Ratchet");
	}

	@Test
	public void test06CrearChispaEnMedioDelMapa() {
		Juego juego = new Juego();
		juego.posicionarChispaEnElMedio();
		int x = Tablero.LIMITELARGO / 2;
		int y = Tablero.LIMITEALTO / 2;

		Assert.assertTrue((juego.devolverElementoEnCoordenada(x, y)).getNombre() == "Chispa");
	}

	@Test
	public void test07InicializarTableroParaUnJugadorD() {
		Juego juego = new Juego();

		juego.agregarJugador("DECEPTICONS");
		juego.posicionarDecepticons();
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO))
				.getNombre() == "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO - 1))
				.getNombre() == "Bonecrusher");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO - 2))
				.getNombre() == "Frenzy");
	}

	@Test
	public void test08InicializarJuegoCompleto() {
		Juego juego = new Juego();
		juego.inicializarTablero();

		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO / 2, Tablero.LIMITEALTO / 2))
				.getNombre() == "Chispa");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre() == "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO))
				.getNombre() == "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).estaVivo());
	}

	@Test
	public void test09AutobotsSeCombinanEnUnSuperion() {
		// crea el terreno
		TerrenoRocoso terreno = new TerrenoRocoso();
		// crea las coordenadas
		Coordenada coordenada1 = new Coordenada(1, 1);
		Coordenada coordenada2 = new Coordenada(1, 2);
		Coordenada coordenada3 = new Coordenada(1, 3);
		// crea los casilleros y les da una ubicacion
		Casillero casillero1 = new Casillero(terreno);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2 = new Casillero(terreno);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3 = new Casillero(terreno);
		casillero3.setUbicacion(coordenada3);
		// crea el jugador
		Tablero tablero = Tablero.getInstancia();
		Jugador jugador = new Jugador(tablero, "AUTOBOTS");
		ArrayList<Algoformer> listaDeAlgoformers = jugador.devolverEquipo();
		// para que sea mas comodo de leer
		Algoformer optimus = listaDeAlgoformers.get(0);
		Algoformer bumblebee = listaDeAlgoformers.get(1);
		Algoformer ratchet = listaDeAlgoformers.get(2);
		// ubica a los algoformers
		optimus.fueUbicadoEn(casillero1);
		bumblebee.fueUbicadoEn(casillero2);
		ratchet.fueUbicadoEn(casillero3);
		Assert.assertTrue(casillero2.devolverElemento().getNombre() == "Bumblebee");
		// combina a los algoformers
		jugador.combinarAlgoformers(optimus, bumblebee, ratchet);
		Assert.assertTrue(listaDeAlgoformers.get(3).getNombre() == "Superion");
		Assert.assertTrue(listaDeAlgoformers.get(3).getVida() == 1000);
		Assert.assertTrue(listaDeAlgoformers.get(3).getUbicacion() == casillero1);
		Assert.assertTrue(casillero2.devolverElemento() == null);
		Assert.assertTrue(casillero3.devolverElemento() == null);
	}

	@Test
	public void test10DecepticonsSeCombinanEnUnMenasor() {
		// crea el terreno
		TerrenoRocoso terreno = new TerrenoRocoso();
		// crea las coordenadas
		Coordenada coordenada1 = new Coordenada(1, 4);
		Coordenada coordenada2 = new Coordenada(1, 5);
		Coordenada coordenada3 = new Coordenada(1, 3);
		// crea los casilleros y les da una ubicacion
		Casillero casillero1 = new Casillero(terreno);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2 = new Casillero(terreno);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3 = new Casillero(terreno);
		casillero3.setUbicacion(coordenada3);
		// crea el jugador
		Tablero tablero = Tablero.getInstancia();
		Jugador jugador = new Jugador(tablero, "DECEPTICONS");
		ArrayList<Algoformer> listaDeAlgoformers = jugador.devolverEquipo();
		// ubica a los algoformers
		listaDeAlgoformers.get(0).fueUbicadoEn(casillero1);
		listaDeAlgoformers.get(1).fueUbicadoEn(casillero2);
		listaDeAlgoformers.get(2).fueUbicadoEn(casillero3);
		// combina a los algoformers
		jugador.combinarAlgoformers(listaDeAlgoformers.get(0), listaDeAlgoformers.get(1), listaDeAlgoformers.get(2));
		Assert.assertTrue(listaDeAlgoformers.get(3).getNombre() == "Menasor");
		Assert.assertTrue(listaDeAlgoformers.get(3).getVida() == 1150);
	}
	
	@Test
	public void test11SuperionSeDescombina () {
		//crea el terreno
		TerrenoRocoso terreno= new TerrenoRocoso();
		//crea las coordenadas
		Coordenada coordenada1= new Coordenada(1,1);
		Coordenada coordenada2= new Coordenada(1,2);
		Coordenada coordenada3= new Coordenada(1,3);
		//crea los casilleros y les da una ubicacion
		Casillero casillero1= new Casillero(terreno);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2= new Casillero(terreno);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3= new Casillero(terreno);
		casillero3.setUbicacion(coordenada3);
		//crea el jugador
		Tablero tablero =  Tablero.getInstancia();
		Jugador jugador = new Jugador(tablero, "AUTOBOTS");
		ArrayList<Algoformer> listaDeAlgoformers= jugador.devolverEquipo();
		//para que sea mas comodo de leer
		Algoformer optimus= listaDeAlgoformers.get(0);
		Algoformer bumblebee= listaDeAlgoformers.get(1);
		Algoformer ratchet= listaDeAlgoformers.get(2);
		//ubica a los algoformers
		optimus.fueUbicadoEn(casillero1);
		bumblebee.fueUbicadoEn(casillero2);
		ratchet.fueUbicadoEn(casillero3);
		Assert.assertTrue(casillero2.devolverElemento().getNombre()== "Bumblebee");
		//combina a los algoformers
		jugador.combinarAlgoformers(optimus, bumblebee, ratchet);
		Assert.assertTrue(listaDeAlgoformers.get(3).estaVivo());
		Assert.assertTrue(listaDeAlgoformers.size()==4);
		//separa los algoformers
		jugador.separarAlgoformers();
		Assert.assertTrue(optimus.getVida()== 500);
		Assert.assertTrue(bumblebee.getVida()== 350);
		Assert.assertTrue(ratchet.getVida()== 150);
		Assert.assertFalse(listaDeAlgoformers.size()==4);//verifica que elimina el Superion
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getLargo()== 1);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getLargo()== 2);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getLargo()== 3);
	}
	
	@Test
	public void test12SuperionSeDescombinaEnLaEsquinaYNoRompeElPrograma () {
		//crea el terreno
		TerrenoRocoso terreno= new TerrenoRocoso();
		//crea las coordenadas
		Coordenada coordenada1= new Coordenada(20,1);
		Coordenada coordenada2= new Coordenada(20,2);
		Coordenada coordenada3= new Coordenada(20,3);
		//crea los casilleros y les da una ubicacion
		Casillero casillero1= new Casillero(terreno);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2= new Casillero(terreno);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3= new Casillero(terreno);
		casillero3.setUbicacion(coordenada3);
		//crea el jugador
		Tablero tablero =  Tablero.getInstancia();
		Jugador jugador = new Jugador(tablero, "AUTOBOTS");
		ArrayList<Algoformer> listaDeAlgoformers= jugador.devolverEquipo();
		//para que sea mas comodo de leer
		Algoformer optimus= listaDeAlgoformers.get(0);
		Algoformer bumblebee= listaDeAlgoformers.get(1);
		Algoformer ratchet= listaDeAlgoformers.get(2);
		//ubica a los algoformers
		optimus.fueUbicadoEn(casillero1);
		bumblebee.fueUbicadoEn(casillero2);
		ratchet.fueUbicadoEn(casillero3);
		Assert.assertTrue(casillero2.devolverElemento().getNombre()== "Bumblebee");
		//combina a los algoformers
		jugador.combinarAlgoformers(optimus, bumblebee, ratchet);
		Assert.assertTrue(listaDeAlgoformers.get(3).estaVivo());
		Assert.assertTrue(listaDeAlgoformers.size()==4);
		//separa los algoformers
		jugador.separarAlgoformers();
		Assert.assertTrue(optimus.getVida()== 500);
		Assert.assertTrue(bumblebee.getVida()== 350);
		Assert.assertTrue(ratchet.getVida()== 150);
		Assert.assertFalse(listaDeAlgoformers.size()==4);//verifica que elimina el Superion
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getLargo()== 20);
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getLargo()== 18);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getLargo()== 19);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getAlto()== 1);
	}

	/*
	 * @Test(expected=NombreDeEquipoNoExisteException.class) public void
	 * test09SeIngresaUnNombreDeEquipoInvalido() { Juego juego= new Juego();
	 * juego.tamanoDeMapa(10, 15);
	 * 
	 * juego.agregarJugador("AUTOBOTS");
	 * 
	 * juego.agregarJugador("ALGOFORMERS");//FALLA YA QUE POR DEFAULT ASIGNA A
	 * DECEPTICONS }
	 */

	// TESTS DE MARTIN
	@Test
	public void test01agregarAlgoformerHumanoideYMoverlo() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, HORIZ2 = 11, VERT1 = 10, VERT2 = 12;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		EstadoAlgoformer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1, DISTANCIA_ATK1, VELOCIDAD_DESP1);
		ArrayList<EstadoAlgoformer> estadosPosibles = new ArrayList<>();
		estadosPosibles.add(estadoHumanoide1);
		Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1, VIDA1, estadosPosibles);
		jug1.ubicarElemento(algof1, coord1);
		Assert.assertTrue(algof1.getUbicacion() == tablero1.devolverCasillero(coord1));
		jug1.mover(algof1, tablero1.devolverCasillero(coord2));
		Assert.assertFalse(algof1.getUbicacion() == tablero1.devolverCasillero(coord1));
		assertTrue(algof1.getUbicacion() == (tablero1.devolverCasillero(coord2)));
	}

	@Test
	public void test03agregarAlgoformerAlternoYMoverlo() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, HORIZ2 = 11, VERT1 = 10, VERT2 = 12;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Coordenada coord2 = new Coordenada(HORIZ2, VERT2);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		EstadoAlgoformer estadoAlterno = new EstadoHumanoide(ATAQUE1, DISTANCIA_ATK1, VELOCIDAD_DESP1);
		ArrayList<EstadoAlgoformer> estadosPosibles = new ArrayList<>();
		estadosPosibles.add(estadoAlterno);
		Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1, VIDA1, estadosPosibles);
		jug1.ubicarElemento(algof1, coord1);
		jug1.mover(algof1, tablero1.devolverCasillero(coord2));
		assertTrue(algof1.getUbicacion() == tablero1.devolverCasillero(coord2));
	}

	// TESTS DE JUAN
	@Test
	public void testSePuedeColocarUnTransformerEnUnCasillero() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, VERT1 = 10;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Tablero tablero = Tablero.getInstancia();
		EstadoAlgoformer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1, DISTANCIA_ATK1, VELOCIDAD_DESP1);
		ArrayList<EstadoAlgoformer> estadosPosibles = new ArrayList<>();
		estadosPosibles.add(estadoHumanoide1);
		Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1, VIDA1, estadosPosibles);
		tablero.ubicarElemento(algof1, coord1);
		Assert.assertTrue(tablero.devolverElemento(coord1) == algof1);
	}

	@Test
	public void AlgoformerSePuedeMoverUnCasillero() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 10, VERT1 = 10;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Tablero tablero = Tablero.getInstancia();
		EstadoAlgoformer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1, DISTANCIA_ATK1, VELOCIDAD_DESP1);
		ArrayList<EstadoAlgoformer> estadosPosibles = new ArrayList<>();
		estadosPosibles.add(estadoHumanoide1);
		Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1, VIDA1, estadosPosibles);
		tablero.ubicarElemento(algof1, coord1);
		Assert.assertTrue(tablero.devolverElemento(coord1) == algof1);
		algof1.mover(tablero.devolverCasillero(new Coordenada(10, 10)));
		Assert.assertTrue(algof1 == tablero.devolverElemento(new Coordenada(10, 10)));
	}

	@Test
	public void sePuedeVaciarUnCasillero() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;

		Casillero casillero = new Casillero(new TerrenoRocoso());
		EstadoAlgoformer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1, DISTANCIA_ATK1, VELOCIDAD_DESP1);
		ArrayList<EstadoAlgoformer> estadosPosibles = new ArrayList<>();
		estadosPosibles.add(estadoHumanoide1);
		Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1, VIDA1, estadosPosibles);
		casillero.ubicarElemento(algof1);
		Assert.assertTrue(casillero.devolverElemento() == algof1);
		casillero.removerElemento();
		Assert.assertFalse(casillero.devolverElemento() == algof1);
	}

	@Test
	public void pruebaListaCircularSeCreaVacia() {
		ArrayList<EstadoAlgoformer> lista = new ArrayList<EstadoAlgoformer>();
		ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
		Assert.assertTrue(listaCirc.isEmpty());
	}

	@Test
	public void pruebaListaCircularSeLlena() {
		ArrayList<EstadoAlgoformer> lista = new ArrayList<EstadoAlgoformer>();
		EstadoAlgoformer pruebaUno = new EstadoHumanoide(1, 1, 1);
		lista.add(pruebaUno);
		ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
		Assert.assertFalse(listaCirc.isEmpty());
	}

	@Test
	public void pruebaListaCircularEsCircular() {
		ArrayList<EstadoAlgoformer> lista = new ArrayList<EstadoAlgoformer>();
		EstadoAlgoformer pruebaUno = new EstadoHumanoide(1, 1, 1);
		lista.add(pruebaUno);
		EstadoAlgoformer pruebaDos = new EstadoHumanoide(2, 2, 2);
		lista.add(pruebaDos);
		ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
		Assert.assertTrue(listaCirc.get() == pruebaUno);
		Assert.assertTrue(listaCirc.get() == pruebaDos);
		Assert.assertTrue(listaCirc.get() == pruebaUno);
	}

	@After
	public void after(){
		Tablero tablero= Tablero.getInstancia();
		tablero.reiniciarTablero();
	}
}
