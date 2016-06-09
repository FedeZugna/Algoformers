package segundaEntrega;

import model.*;
import model.superficies.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PruebasGeneralesSegEntrega {

	@Test (expected = NoPuedeMoverseException.class)
	public void AlgoformerHumanoideNoPuedeCaminarEnPantano() {
		
		Coordenada coord1 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = new Casillero(new TerrenoPantanoso());
		cas1.setUbicacion(new Coordenada (10,11));
		
		algof1.mover(cas1);
	}
	
	@Test 
	public void AlgoformerAlternoPuedeCaminarEnPantano() {
		
		Coordenada coord1 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = new Casillero(new TerrenoPantanoso());
		cas1.setUbicacion(new Coordenada (10,11));
		algof1.transformar();
		algof1.mover(cas1);	}
	
	@Test 
	public void AlgoformerHumanoidePuedeCaminarRoca() {
		
		Coordenada coord1 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = new Casillero(new TerrenoRocoso());
		cas1.setUbicacion(new Coordenada (10,11));
		
		algof1.mover(cas1);
	}
	
	@Test 
	public void AlgoformerAlternoPuedeCaminarRoca() {
		
		Coordenada coord1 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Optimus();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = new Casillero(new TerrenoRocoso());
		cas1.setUbicacion(new Coordenada (10,11));
		algof1.transformar();
		algof1.mover(cas1);
	}
	
	@Test 
	public void AlgoformerAlternoPuedePasarPorNube() {
		
		Coordenada coord1 = new Coordenada(10, 10);
		Tablero tablero = Tablero.getInstancia();
		
		Algoformer algof1 = new Megatron();
		tablero.ubicarElemento(algof1, coord1);
		Casillero cas1 = tablero.devolverCasillero(new Coordenada (10,11));
		cas1.setEspacioAereo(new Nube());
		algof1.transformar();
		algof1.mover(cas1);
	}
	
	
	
	
}
