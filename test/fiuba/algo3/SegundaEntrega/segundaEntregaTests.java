/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaEntrega;

import model.excepciones.NoPuedeMoverseException;
import model.*;
import model.algoformers.*;
import model.superficies.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Martin
 */
public class segundaEntregaTests {
    
    public segundaEntregaTests(){}
    
    @Before
	public void before(){
		Tablero tablero= Tablero.getInstancia();
		tablero.reiniciarTablero();
	}
	
        @Test (expected = NoPuedeMoverseException.class)
	public void AlgoformerHumanoideNoPuedeCaminarEnPantano() {
		
		Coordenada coord1 = new Coordenada(9, 10);
                Coordenada coord2 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = tablero.devolverCasillero(coord2);
                cas1.setTerreno(new TerrenoPantanoso());
		
		algof1.mover(cas1);
                //no va a poder moverse
	}
	
	
        @Test
        public void AlgoformerAlternoPuedeCaminarEnPantano() {
                Coordenada coord1 = new Coordenada(9, 10);
                Coordenada coord2 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = tablero.devolverCasillero(coord2);
                cas1.setTerreno(new TerrenoPantanoso());
		
                algof1.transformar();
		algof1.mover(cas1);
                Assert.assertTrue(algof1.getUbicacion()==cas1);
        
        }
	
	
        @Test
        public void AlgoformerHumanoidePuedeCaminarRoca(){
            
                Coordenada coord1 = new Coordenada(9, 10);
                Coordenada coord2 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = tablero.devolverCasillero(coord2);
                cas1.setTerreno(new TerrenoRocoso());
		
		algof1.mover(cas1);
                Assert.assertTrue(algof1.getUbicacion()==cas1);     
        
        } 
	
        @Test 
	public void AlgoformerAlternoPuedeCaminarRoca(){
                Coordenada coord1 = new Coordenada(9, 10);
                Coordenada coord2 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = tablero.devolverCasillero(coord2);
                cas1.setTerreno(new TerrenoRocoso());
		
                algof1.transformar();
		algof1.mover(cas1);
                Assert.assertTrue(algof1.getUbicacion()==cas1); 
        }
	
	
        @Test
        public void AlgoformerAlternoAereoPuedePasarPorNube(){
                
                Coordenada coord1 = new Coordenada(9, 10);
                Coordenada coord2 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Megatron();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = tablero.devolverCasillero(coord2);
                cas1.setEspacioAereo(new Nube());
		
                algof1.transformar();
		algof1.mover(cas1);
                Assert.assertTrue(algof1.getUbicacion()==cas1); 
        } 
        
        

	@After
	public void after(){
		Tablero tablero= Tablero.getInstancia();
		tablero.reiniciarTablero();
	}	

}
