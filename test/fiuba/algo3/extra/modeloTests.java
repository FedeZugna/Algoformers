/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;


import model.*;
import model.algoformers.*;
import model.superficies.*;
import model.bonus.*;
import model.excepciones.*;

import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Martin
 */
public class modeloTests {
    public modeloTests(){}
    
    @Before
	public void before(){
		Tablero.getInstancia().reiniciarTablero();
	}
    
    @Test
    public void inicializacionNoDevuelveExcepciones(){
        Juego juego = new Juego();
    }
}
