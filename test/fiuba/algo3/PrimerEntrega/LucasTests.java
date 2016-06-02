package primerEntrega;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import model.*;

import org.junit.Assert;
import org.junit.Test;

public class LucasTests {

	@Test
	public void test01InicializarTableroConUnOptimus () {
		Tablero tablero= Tablero.getInstancia();
		Algoformer optimus= new Optimus();
		Interactuable algoformer;
		Coordenada coordenadaOcupada= new Coordenada(1, 1);

		tablero.ubicarElemento(optimus, coordenadaOcupada);
		algoformer= tablero.devolverElemento(coordenadaOcupada);
		
		Assert.assertTrue (algoformer.getNombre()=="Optimus");
		Assert.assertTrue (algoformer.estaVivo());

	}
	
	@Test
	public void test02CrearJuegoYCreaUnMapa(){
				
		Assert.assertTrue(Tablero.getInstancia().devolverLargo()== 20);
		Assert.assertTrue(Tablero.getInstancia().devolverAlto()== 20);
	}
	
	

	@Test
	public void test03CrearJuegoConUnSoloJugadorYEquipoAutobots(){
		Juego juego= new Juego();
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
		juego.agregarJugador("AUTOBOTS");
		juego.posicionarAutobots();
		
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre()== "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).getNombre()== "Bumblebee");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 3)).getNombre()== "Ratchet");
	}

	@Test
	public void test06CrearChispaEnMedioDelMapa(){		
		Juego juego= new Juego();
		juego.posicionarChispaEnElMedio();
		int x= Tablero.LIMITELARGO /2; 
		int y= Tablero.LIMITEALTO/2;
		
		Assert.assertTrue((juego.devolverElementoEnCoordenada(x, y)).getNombre()== "Chispa");
	}


	@Test
	public void test07InicializarTableroParaUnJugadorD(){
		Juego juego= new Juego();
		
		juego.agregarJugador("DECEPTICONS");
		juego.posicionarDecepticons();
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO)).getNombre()== "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO-1)).getNombre()== "BoneCrusher");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO-2)).getNombre()== "Frenzy");
	}
	
	@Test
	public void test08InicializarJuegoCompleto() {
		Juego juego= new Juego();
		juego.inicializarTablero();
				
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO/2, Tablero.LIMITEALTO/2)).getNombre()== "Chispa");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 1)).getNombre()== "Optimus");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(Tablero.LIMITELARGO, Tablero.LIMITEALTO)).getNombre()== "Megatron");
		Assert.assertTrue((juego.devolverElementoEnCoordenada(1, 2)).estaVivo());
	}
	
/*
	@Test(expected=NombreDeEquipoNoExisteException.class)
	public void test09SeIngresaUnNombreDeEquipoInvalido() {
		Juego juego= new Juego();
		juego.tamanoDeMapa(10, 15);
		
		juego.agregarJugador("AUTOBOTS");
		
		juego.agregarJugador("ALGOFORMERS");//FALLA YA QUE POR DEFAULT ASIGNA A DECEPTICONS
	}
*/
	
//TESTS DE MARTIN	
	@Test
	public void test01agregarAlgoformerHumanoideYMoverlo(){
		String NOMBRE_ALGOF1 = "Autobot1";
	    int  VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	    int HORIZ1 = 10, HORIZ2 = 11,VERT1 = 10, VERT2 = 12;
	    Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	    Coordenada coord2 = new Coordenada(HORIZ2,VERT2);
	    Tablero tablero1 =  Tablero.getInstancia();
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
	        int  VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        int HORIZ1 = 10, HORIZ2 = 11,VERT1 = 10, VERT2 = 12;
	        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	        Coordenada coord2 = new Coordenada(HORIZ2,VERT2);
	        Tablero tablero1 =  Tablero.getInstancia();
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
	        int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        int HORIZ1 = 10,VERT1 = 10;
	        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	        Tablero tablero =  Tablero.getInstancia();
	        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	        estadosPosibles.add(estadoHumanoide1);
	        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	        tablero.ubicarElemento(algof1,coord1);
	        Assert.assertTrue(tablero.devolverElemento(coord1)==algof1);
	        
		}
	 
	 @Test
		public void AlgoformerSePuedeMoverUnCasillero(){
			String NOMBRE_ALGOF1 = "Autobot1";
	        int VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
	        int HORIZ1 = 10,VERT1 = 10;
	        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
	        Tablero tablero =  Tablero.getInstancia();
	        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1);
	        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
	        estadosPosibles.add(estadoHumanoide1);
	        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
	        tablero.ubicarElemento(algof1,coord1);
	        Assert.assertTrue(tablero.devolverElemento(coord1)==algof1);
	        algof1.mover(tablero, new Coordenada(10,10));
	        Assert.assertTrue(algof1==tablero.devolverElemento(new Coordenada(10,10)));
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
		 	ArrayList<EstadoAlgoFormer> lista = new ArrayList<EstadoAlgoFormer>();
		 	ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
			Assert.assertTrue(listaCirc.isEmpty() );
		}
	 
	 @Test
	 public void pruebaListaCircularSeLlena(){
		 	ArrayList<EstadoAlgoFormer> lista = new ArrayList<EstadoAlgoFormer>();
		 	EstadoAlgoFormer pruebaUno = new EstadoAlgoFormer(1,1,1);
		 	lista.add(pruebaUno);
		 	ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
			Assert.assertFalse(listaCirc.isEmpty() );
		}
	 
	 @Test
	 public void pruebaListaCircularEsCircular(){
		 	ArrayList<EstadoAlgoFormer> lista = new ArrayList<EstadoAlgoFormer>();
		 	EstadoAlgoFormer pruebaUno = new EstadoAlgoFormer(1,1,1);
		 	lista.add(pruebaUno);
		 	EstadoAlgoFormer pruebaDos = new EstadoAlgoFormer(2,2,2);
		 	lista.add(pruebaDos);
		 	ListaCircularEstatica listaCirc = new ListaCircularEstatica(lista);
			Assert.assertTrue(listaCirc.get()==pruebaUno);
			Assert.assertTrue(listaCirc.get()==pruebaDos);
			Assert.assertTrue(listaCirc.get()==pruebaUno);
		} 
	 	
// Pruebas Nicolas
	 
	 
	 	
	 
}
