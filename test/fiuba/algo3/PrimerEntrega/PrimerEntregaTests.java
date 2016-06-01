/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerEntrega;

import model.*;
//import controller.*;
import java.util.ArrayList;
import java.util.List;
//import view.*;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */ 
@SuppressWarnings("unused")
public class PrimerEntregaTests {
        
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
    public void test02transformarAlgoformerIdaYVuelta(){
    	String NOMBRE_ALGOF1 = "Autobot1";
        int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2,VELOCIDAD_DESP1 = 10;
        int HORIZ1 = 10, VERT1 = 10;
        
        Tablero tablero1 =  new Tablero(ANCHO,LARGO);
        Jugador jug1 = new Jugador(tablero1,"sin equipo");
        ArrayList<EstadoAlgoFormer> estadosPosibles = new ArrayList<>();
        estadosPosibles.add( new EstadoHumanoide(ATAQUE1,DISTANCIA_ATK1,VELOCIDAD_DESP1) );
        estadosPosibles.add( new EstadoAlterno(ATAQUE1+1,DISTANCIA_ATK1+1,VELOCIDAD_DESP1+1) );
        Algoformer algof1 = new AlgoformerGenerico(NOMBRE_ALGOF1,VIDA1,estadosPosibles);
        
        jug1.ubicarElemento(algof1,new Coordenada(HORIZ1,VERT1));
        jug1.OrdenaQueSeTranforme(algof1);
        //Assert.assertTrue(algof1.getAtaque()>ATAQUE1);
        System.out.println( algof1.getEstadoActual().getAtaque() );
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
    /*
    @Test
    public void test04InicializacionDeJuego(){
        int ANCHO = 100, LARGO = 100;
        Tablero tablero1 =  new Tablero(ANCHO,LARGO);
        //y ahora? u otra clase maestra que genere un juego?
    }
    
    @Test
    public void test05atacarEnemigoYVerificarDistanciaYDanio1(){
        String NOMBRE_ALGOF1 = "Autobot1", NOMBRE_ALGOF2 = "Decepticon1";
        int ANCHO = 100, LARGO = 100, VIDA = 10, ATAQUE = 1, DISTANCIA_ATK1 = 1,VELOCIDAD_DESP = 10;
        int DISTANCIA_ATK2 = 10;
        int HORIZ1 = 10, HORIZ2 = 13, VERT1 = 10, VERT2 = 13;
        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
        Coordenada coord2 = new Coordenada(HORIZ2,VERT2);
        Tablero tablero1 =  new Tablero(ANCHO,LARGO);
        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE,DISTANCIA_ATK1,VELOCIDAD_DESP);
        EstadoAlgoFormer estadoHumanoide2 = new EstadoHumanoide(ATAQUE,DISTANCIA_ATK2,VELOCIDAD_DESP);
        List<EstadoAlgoFormer> estadosPosibles1 = new ArrayList<>();
        estadosPosibles1.add(estadoHumanoide1);
        List<EstadoAlgoFormer> estadosPosibles2 = new ArrayList<>();
        estadosPosibles2.add(estadoHumanoide2);
        Algoformer algof1 = new Algoformer(NOMBRE_ALGOF1,VIDA,estadosPosibles1);
        Algoformer algof2 = new Algoformer(NOMBRE_ALGOF2,VIDA,estadosPosibles2);
        tablero1.ubicarElemento(algof1,coord1);
        tablero1.ubicarElemento(algof2,coord2);
        
        assertTrue(algof2.esAtaquePosible(coord1));
        
        //CON COMMAND
        /*
        Accion atacar1 = new AccionAtacar(coord1);
        algof2.ejecutar(atacar1);//MAL?
        atacar1.ejecutar(algof2);//BIEN?
        assertTrue(algof1.obtenerVida()< VIDA1);
        */
        
        //SIN COMMAND 
        /*
        algof2.atacar(coord1);
        assertTrue(algof1.obtenerVida()< VIDA);   
    }
    
    @Test (expected = AlcanceExcedidoException)
    public void test05atacarEnemigoYVerificarDistanciaYDanio2(){
        String NOMBRE_ALGOF1 = "Autobot1", NOMBRE_ALGOF2 = "Decepticon1";
        int ANCHO = 100, LARGO = 100, VIDA = 10, ATAQUE = 1, DISTANCIA_ATK1 = 1,VELOCIDAD_DESP = 10;
        int DISTANCIA_ATK2 = 10;
        int HORIZ1 = 10, HORIZ2 = 13, VERT1 = 10, VERT2 = 13;
        Coordenada coord1 = new Coordenada(HORIZ1,VERT1);
        Coordenada coord2 = new Coordenada(HORIZ2,VERT2);
        Tablero tablero1 =  new Tablero(ANCHO,LARGO);
        EstadoAlgoFormer estadoHumanoide1 = new EstadoHumanoide(ATAQUE,DISTANCIA_ATK1,VELOCIDAD_DESP);
        EstadoAlgoFormer estadoHumanoide2 = new EstadoHumanoide(ATAQUE,DISTANCIA_ATK2,VELOCIDAD_DESP);
        List<EstadoAlgoFormer> estadosPosibles1 = new ArrayList<>();
        estadosPosibles1.add(estadoHumanoide1);
        List<EstadoAlgoFormer> estadosPosibles2 = new ArrayList<>();
        estadosPosibles2.add(estadoHumanoide2);
        Algoformer algof1 = new Algoformer(NOMBRE_ALGOF1,VIDA,estadosPosibles1);
        Algoformer algof2 = new Algoformer(NOMBRE_ALGOF2,VIDA,estadosPosibles2);
        tablero1.ubicarElemento(algof1,coord1);
        tablero1.ubicarElemento(algof2,coord2);
        
        assertFalse(algof1.esAtaquePosible(coord2));
        
        //CON COMMAND
        /*
        Accion atacar1 = new AccionAtacar(coord2);
        algof1.ejecutar(atacar1);//MAL?
        atacar1.ejecutar(algof1);//BIEN?
        */
        
        //SIN COMMAND 
        /*
        algof1.atacar(coord2);       
    } 
} */
    
    }
