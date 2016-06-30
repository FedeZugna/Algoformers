package primerEntrega;

import model.excepciones.CasilleroOcupadoException;
import java.util.ArrayList;

import model.*;
import model.superficies.*;
import model.algoformers.*; 
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LucasTests {

	@Before
	public void before(){
		Tablero.getInstancia().reiniciarTablero();
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

		Assert.assertTrue(Tablero.getInstancia().devolverLargo() == 15);
		Assert.assertTrue(Tablero.getInstancia().devolverAlto() == 10);
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
//		juego.agregarJugador("AUTOBOTS");
//		juego.posicionarAutobots();

		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre() == "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).getNombre() == "Bumblebee");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 3)).getNombre() == "Ratchet");
	}

	@Test
	public void test06CrearChispaEnMedioDelMapa() {
		Juego juego = new Juego();
//		juego.posicionarChispaEnElMedio();
		int x = Tablero.LIMITELARGO / 2;
		int y = Tablero.LIMITEALTO / 2;

		Assert.assertTrue((juego.devolverElementoEnCoordenada(x, y)).getNombre() == "Chispa");
	}

	@Test
	public void test07InicializarTableroParaUnJugadorD() {
		Juego juego = new Juego();

//		juego.agregarJugador("DECEPTICONS");
//		juego.posicionarDecepticons();
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO -1, Tablero.LIMITEALTO-1))
				.getNombre() == "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO -1, Tablero.LIMITEALTO - 2))
				.getNombre() == "Bonecrusher");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO -1, Tablero.LIMITEALTO - 3))
				.getNombre() == "Frenzy");
	}

	@Test
	public void test08InicializarJuegoCompleto() {
		Juego juego = new Juego();
//		juego.inicializarTablero();

		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO / 2, Tablero.LIMITEALTO / 2))
				.getNombre() == "Chispa");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre() == "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO -1, Tablero.LIMITEALTO -1))
				.getNombre() == "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).estaVivo());
	}

	@Test
	public void test09AutobotsSeCombinanEnUnSuperion() {
		// crea el terreno
		TerrenoRocoso terreno = new TerrenoRocoso();
		Nube cielo= new Nube();
		// crea las coordenadas
		Coordenada coordenada1 = new Coordenada(1, 1);
		Coordenada coordenada2 = new Coordenada(1, 2);
		Coordenada coordenada3 = new Coordenada(1, 3);
		// crea los casilleros y les da una ubicacion
		Casillero casillero1 = new Casillero(terreno, cielo);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2 = new Casillero(terreno, cielo);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3 = new Casillero(terreno, cielo);
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
		tablero.ubicarElemento(optimus, coordenada1);
		tablero.ubicarElemento(bumblebee, coordenada2);
		tablero.ubicarElemento(ratchet, coordenada3);
		// combina a los algoformers
		jugador.combinarAlgoformers(optimus, bumblebee, ratchet);
		Assert.assertTrue(listaDeAlgoformers.get(3).getNombre() == "Superion");
		Assert.assertTrue(listaDeAlgoformers.get(3).getVida() == 1000);
		Assert.assertTrue(listaDeAlgoformers.get(3).getUbicacion().getUbicacion().getLargo() == 1);
		Assert.assertTrue(listaDeAlgoformers.get(3).getUbicacion().getUbicacion().getAlto() == 1);

		Assert.assertTrue(casillero2.devolverElemento() == null);
		Assert.assertTrue(casillero3.devolverElemento() == null);
	}

	@Test
	public void test10DecepticonsSeCombinanEnUnMenasor() {
		// crea el terreno
		TerrenoRocoso terreno = new TerrenoRocoso();
		Nube cielo= new Nube();
		// crea las coordenadas
		Coordenada coordenada1 = new Coordenada(1, 4);
		Coordenada coordenada2 = new Coordenada(1, 5);
		Coordenada coordenada3 = new Coordenada(1, 3);
		// crea los casilleros y les da una ubicacion
		Casillero casillero1 = new Casillero(terreno, cielo);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2 = new Casillero(terreno, cielo);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3 = new Casillero(terreno, cielo);
		casillero3.setUbicacion(coordenada3);
		// crea el jugador
		Tablero tablero = Tablero.getInstancia();
		Jugador jugador = new Jugador(tablero, "DECEPTICONS");
		ArrayList<Algoformer> listaDeAlgoformers = jugador.devolverEquipo();
		// para que sea mas comodo de leer
		Algoformer megatron = listaDeAlgoformers.get(0);
		Algoformer bonecrusher = listaDeAlgoformers.get(1);
		Algoformer frenzy = listaDeAlgoformers.get(2);
		// ubica a los algoformers
		tablero.ubicarElemento(megatron, coordenada1);
		tablero.ubicarElemento(bonecrusher, coordenada2);
		tablero.ubicarElemento(frenzy, coordenada3);
		// combina a los algoformers
		jugador.combinarAlgoformers(listaDeAlgoformers.get(0), listaDeAlgoformers.get(1), listaDeAlgoformers.get(2));
		Assert.assertTrue(listaDeAlgoformers.get(3).getNombre() == "Menasor");
		Assert.assertTrue(listaDeAlgoformers.get(3).getVida() == 1150);
	}
	
	@Test
	public void test11SuperionSeDescombina () {
		//crea el terreno
		TerrenoRocoso terreno= new TerrenoRocoso();
		Nube cielo= new Nube();
		//crea las coordenadas
		Coordenada coordenada1= new Coordenada(1,1);
		Coordenada coordenada2= new Coordenada(1,2);
		Coordenada coordenada3= new Coordenada(1,3);
		//crea los casilleros y les da una ubicacion
		Casillero casillero1= new Casillero(terreno, cielo);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2= new Casillero(terreno, cielo);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3= new Casillero(terreno, cielo);
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
		tablero.ubicarElemento(optimus, coordenada1);
		tablero.ubicarElemento(bumblebee, coordenada2);
		tablero.ubicarElemento(ratchet, coordenada3);
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
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getAlto()== 1);
	}
	
	@Test(expected=CasilleroOcupadoException.class)
	public void test12SeIntentaPosicionarAlgoformerEnCasilleroOcupadoLanzaExcepcion() {
		//crea el terreno
		TerrenoRocoso terreno= new TerrenoRocoso();
		Nube cielo= new Nube();
		//crea las coordenadas
		Coordenada coordenada1= new Coordenada(1,1);
		Coordenada coordenada2= new Coordenada(1,1);
		//crea los casilleros y les da una ubicacion
		Casillero casillero1= new Casillero(terreno, cielo);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2= new Casillero(terreno, cielo);
		casillero2.setUbicacion(coordenada2);
		//crea el tablero
		Tablero tablero= Tablero.getInstancia();
		//crea dos algoformers distintos
		Optimus optimus= new Optimus();
		Megatron megatron= new Megatron();
		//posiciona
		tablero.ubicarElemento(optimus, coordenada1);
		Assert.assertTrue(tablero.devolverElemento(coordenada1).getNombre()== "Optimus");
		tablero.ubicarElemento(megatron, coordenada2);
	}

	@Test
	public void test13SuperionSeDescombinaEnLaEsquinaYNoRompeElPrograma () {
		//crea el terreno
		TerrenoRocoso terreno= new TerrenoRocoso();
		Nube cielo= new Nube();
		//crea las coordenadas
		Coordenada coordenada1= new Coordenada(10,1);
		Coordenada coordenada2= new Coordenada(10,2);
		Coordenada coordenada3= new Coordenada(10,3);
		//crea los casilleros y les da una ubicacion
		Casillero casillero1= new Casillero(terreno, cielo);
		casillero1.setUbicacion(coordenada1);
		Casillero casillero2= new Casillero(terreno, cielo);
		casillero2.setUbicacion(coordenada2);
		Casillero casillero3= new Casillero(terreno, cielo);
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
		tablero.ubicarElemento(optimus, coordenada1);
		tablero.ubicarElemento(bumblebee, coordenada2);
		tablero.ubicarElemento(ratchet, coordenada3);
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
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getLargo()== 10);
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getLargo()== 11);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getLargo()== 12);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getAlto()== 1);
	}
	
	@Test 
	public void test14SuperionSeDescombinaEnLaEsquinaConCasillerosVecinosOcupados () {
		//crea las coordenadas
		Coordenada coordenada1= new Coordenada(6,1);
		Coordenada coordenada2= new Coordenada(6,2);
		Coordenada coordenada3= new Coordenada(6,3);
		Coordenada coordenada4= new Coordenada(7,1);
		Coordenada coordenada5= new Coordenada(8,1);
		Coordenada coordenada6= new Coordenada(9,1);
		Coordenada coordenada7= new Coordenada(1,1);
		//crea el jugador
		Tablero tablero =  Tablero.getInstancia();
		Jugador jugador = new Jugador(tablero, "AUTOBOTS");
		ArrayList<Algoformer> listaDeAlgoformers= jugador.devolverEquipo();
		Megatron megatron= new Megatron();
		Bonecrusher bonecrusher= new Bonecrusher();
		Frenzy frenzy= new Frenzy();
		Chispa chispa= new Chispa();
		//para que sea mas comodo de leer
		Algoformer optimus= listaDeAlgoformers.get(0);
		Algoformer bumblebee= listaDeAlgoformers.get(1);
		Algoformer ratchet= listaDeAlgoformers.get(2);
		//ubica a los algoformers
		tablero.ubicarElemento(optimus, coordenada1);
		tablero.ubicarElemento(bumblebee, coordenada2);
		tablero.ubicarElemento(ratchet, coordenada3);
		tablero.ubicarElemento(megatron, coordenada4);
		tablero.ubicarElemento(bonecrusher, coordenada5);
		tablero.ubicarElemento(frenzy, coordenada6);
		tablero.ubicarElemento(chispa, coordenada7);
		//combina a los algoformers
		jugador.combinarAlgoformers(optimus, bumblebee, ratchet);
		//separa los algoformers
		jugador.separarAlgoformers();
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getLargo()== 6);
		Assert.assertTrue(optimus.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getLargo()== 10);
		Assert.assertTrue(bumblebee.getUbicacion().getUbicacion().getAlto()== 1);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getLargo()== 11);
		Assert.assertTrue(ratchet.getUbicacion().getUbicacion().getAlto()== 1);
	}
	
	@Test
	public void test15PasarTurno() {
		Juego juego= new Juego();

		Assert.assertTrue(juego.pasarTurno().devolverEquipo().get(0).getNombre()== "Megatron");
		Assert.assertTrue(juego.pasarTurno().devolverEquipo().get(0).getNombre()== "Optimus");
		Assert.assertTrue(juego.pasarTurno().devolverEquipo().get(0).getNombre()== "Megatron");
		Assert.assertFalse(juego.pasarTurno().devolverEquipo().get(0).getNombre()== "Megatron");
		
	}

/*
 *	 @Test(expected=NombreDeEquipoNoExisteException.class) public void
 *	 test0XSeIngresaUnNombreDeEquipoInvalido() { Juego juego= new Juego();
 *	 	juego.tamanoDeMapa(10, 15);
 * 
 *		 juego.agregarJugador("AUTOBOTS");
 * 
 * 		juego.agregarJugador("ALGOFORMERS");//FALLA YA QUE POR DEFAULT ASIGNA A
 * 												DECEPTICONS
 * 	}
*/

	// TESTS DE JUAN
	


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
	}
}
