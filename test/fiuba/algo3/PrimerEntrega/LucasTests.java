package primerEntrega;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import model.*;

import org.junit.Assert;
import org.junit.Test;

public class LucasTests {

	@Test
	public void test01InicializarTableroConUnOptimus () {
		Tablero tablero= new Tablero (10, 10);
		Algoformer optimus= new Optimus();
		Interactuable algoformer;
		Coordenada coordenadaOcupada= new Coordenada(1, 1);

		tablero.ubicarElemento(optimus, coordenadaOcupada);
		algoformer= tablero.devolverElemeno(coordenadaOcupada);
		
		Assert.assertTrue (algoformer.getNombre()=="Optimus");
		Assert.assertTrue (algoformer.estaVivo());

	}
	
	@Test
	public void test02CrearJuegoYCreaUnMapa(){
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		
		Tablero tablero;
		tablero= juego.devolverTablero();
		
		Assert.assertTrue(tablero.devolverLargo()== 10);
		Assert.assertTrue(tablero.devolverAlto()== 15);
	}
	
	

	@Test
	public void test03CrearJuegoConUnSoloJugadorYEquipoAutobots(){
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		juego.agregarJugador("AUTOBOTS");
		
		ArrayList<Algoformer> equipo;
		equipo= juego.devolverEquipoDe("AUTOBOTS");
		
		Assert.assertTrue(equipo.size()== 3);
		Assert.assertTrue (equipo.get(0).getNombre()== "Optimus");
		Assert.assertTrue (equipo.get(1).getNombre()== "Bumblebee");
		Assert.assertTrue (equipo.get(2).getNombre()== "Ratchet");
	}
	
	@Test
	public void test04CrearJuegoConUnSoloJugadorYEquipoDecepticons(){
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		juego.agregarJugador("DECEPTICONS");
		
		ArrayList<Algoformer> equipo= new ArrayList<Algoformer>();
		equipo= juego.devolverEquipoDe("DECEPTICONS");
		
		Assert.assertTrue(equipo.size()== 3);
		Assert.assertTrue (equipo.get(0).getNombre()== "Megatron");
		Assert.assertTrue (equipo.get(1).getNombre()== "BoneCrusher");
		Assert.assertTrue (equipo.get(2).getNombre()== "Frenzy");
	}
	
	@Test
	public void test05InicializarTableroParaUnJugador(){
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		juego.agregarJugador("AUTOBOTS");
		juego.posicionarAutobots();
		
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre()== "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).getNombre()== "Bumblebee");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 3)).getNombre()== "Ratchet");
	}

	@Test
	public void test06CrearChispaEnMedioDelMapa(){		
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		
		Assert.assertTrue((juego.devolverElementoEnCoordenada(5, 7)).getNombre()== "Chispa");
	}


	@Test
	public void test07InicializarTableroParaUnJugadorD(){
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		
		juego.agregarJugador("DECEPTICONS");
		juego.posicionarDecepticons();
		Assert.assertTrue((juego.devolverElementoEnCoordenada(10, 15)).getNombre()== "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(10, 14)).getNombre()== "BoneCrusher");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(10, 13)).getNombre()== "Frenzy");
	}

	
//TESTS DE MARTIN	
	@Test
	public void test01agregarAlgoformerHumanoideYMoverlo(){
		String NOMBRE_ALGOF1 = "Autobot1";
	    int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	    int HORIZ1 = 10, HORIZ2 = 11,VERT1 = 10, VERT2 = 12;
	    Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	    Coordenada coord2 = new Coordenada(HORIZ2,VERT2);
	    Tablero tablero1 =  new Tablero(ANCHO,LARGO);
	    Jugador jug1 = new Jugador(tablero1,"sin equipo");
	    EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	    ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	    estadosPosibles.add(estadoHumanoide1);
	    Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	    jug1.ubicarElemento(algof1,coord1);
	    jug1.mover(algof1,coord2);                
	    assertTrue(algof1.getUbicacion().equals(coord2));
	}
	
	 @Test
	    public void test03agregarAlgoformerAlternoYMoverlo(){
	    	String NOMBRE_ALGOF1 = "Autobot1";
	        int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        int HORIZ1 = 10, HORIZ2 = 11,VERT1 = 10, VERT2 = 12;
	        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	        Coordenada coord2 = new Coordenada(HORIZ2,VERT2);
	        Tablero tablero1 =  new Tablero(ANCHO,LARGO);
	        Jugador jug1 = new Jugador(tablero1,"sin equipo");
	        EstadoAlgoFormer estadoAlterno = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	        estadosPosibles.add(estadoAlterno);
	        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	        jug1.ubicarElemento(algof1,coord1);
	        jug1.mover(algof1,coord2);                
	        assertTrue(algof1.getUbicacion().equals(coord2));
	    }
	 
	 
//TESTS DE JUAN
	 @Test
		public void testSePuedeColocarUnTransformerEnUnCasillero(){
			String NOMBRE_ALGOF1 = "Autobot1";
	        int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        int HORIZ1 = 10,VERT1 = 10;
	        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	        Tablero tablero =  new Tablero(ANCHO,LARGO);
	        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	        estadosPosibles.add(estadoHumanoide1);
	        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	        tablero.ubicarElemento(algof1,coord1);
	        Assert.assertTrue(tablero.devolverElemeno(coord1)==algof1);
	        
		}
	 
	 @Test
		public void AlgoformerSePuedeMoverUnCasillero(){
			String NOMBRE_ALGOF1 = "Autobot1";
	        int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        int HORIZ1 = 10,VERT1 = 10;
	        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	        Tablero tablero =  new Tablero(ANCHO,LARGO);
	        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	        estadosPosibles.add(estadoHumanoide1);
	        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	        tablero.ubicarElemento(algof1,coord1);
	        Assert.assertTrue(tablero.devolverElemeno(coord1)==algof1);
	        algof1.mover(tablero, new Coordenada(10,10));
	        Assert.assertTrue(algof1==tablero.devolverElemeno(new Coordenada(10,10)));
		}
	 
	 @Test
		public void sePuedeVaciarUnCasillero(){
			String NOMBRE_ALGOF1 = "Autobot1";
	        int  VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        
	        Casillero casillero =  new Casillero();
	        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	        estadosPosibles.add(estadoHumanoide1);
	        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	        casillero.ubicarElemento(algof1);
	        Assert.assertTrue(casillero.devolverElemento()==algof1);
	        casillero.removerElemento();
	        Assert.assertFalse(casillero.devolverElemento()==algof1);
		}
	 
	 @Test
		public void pruebaListaCircularSeCreaVacia(){
			ListaCircular lista = new ListaCircular();
			Assert.assertTrue(lista.isEmpty() );
		}
}
