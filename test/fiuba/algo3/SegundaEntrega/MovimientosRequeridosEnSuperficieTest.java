/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaEntrega;

import model.*;
import model.superficies.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class MovimientosRequeridosEnSuperficieTest {
    
    public MovimientosRequeridosEnSuperficieTest() {
    }
    
    @Test
    public void CantidadDeMovimientosEnRocosoEsIgualAlternoVsHumanoide(){
        Superficie rocoso1 = new TerrenoRocoso();
        assertTrue(rocoso1.getPasos_alterno()==rocoso1.getPasos_humanoide());
    }
    
    @Test
    public void CantidadDeMovimientosPantanosoEsDobleDeRocosoEnAlterno(){
        Superficie rocoso1 = new TerrenoRocoso();
        Superficie pantanoso1 = new TerrenoPantanoso();
        assertTrue((2*rocoso1.getPasos_alterno())== (pantanoso1.getPasos_alterno()));
    }
    
    @Test (expected = NoPuedeMoverseException.class)
    public void PantanosoNoPuedeMoverseEnHumanoide(){
        Superficie pantanoso1 = new TerrenoPantanoso();
        pantanoso1.getPasos_humanoide();
    }
    
    @Test
    public void CantidadDeMovimientosEnEspinasEsIgualAlternoVsHumanoide(){
        Superficie espinoso1 = new TerrenoDeEspinas();
        assertTrue(espinoso1.getPasos_alterno()==espinoso1.getPasos_humanoide());
    }
    
    /*
    Chequeo de supuesto "donde no especificado la cantidad de movimientos es igual
    a Rocoso/Nube
    */
    
    @Test
    public void CantidadDeMovimientosEnEspinasEsIgualARocoso(){
        Superficie espinoso1 = new TerrenoDeEspinas();
        Superficie rocoso1 = new TerrenoRocoso();
        assertTrue(espinoso1.getPasos_alterno()==rocoso1.getPasos_humanoide());
    }
    
    @Test
    public void CantidadDeMovimientosEnNubeEsIgualANebulosa(){
        Superficie nube1 = new Nube();
        Superficie nebulosa1 = new NebulosaDeAndromeda();
        assertTrue(nube1.getPasos_alterno()==nebulosa1.getPasos_alterno());
    }
    
    @Test
    public void CantidadDeMovimientosEnNubeEsIgualATormenta(){
        Superficie nube1 = new Nube();
        Superficie tormenta1 = new TormentaPsionica();
        assertTrue(nube1.getPasos_alterno()==tormenta1.getPasos_alterno());
    }
    
    @Test (expected = NoPuedeMoverseException.class)
    public void HumanoideNoPuedePasarNube(){
        Superficie nube1 = new Nube();
        nube1.getPasos_humanoide();
    }
    
    
    @Test (expected = NoPuedeMoverseException.class)
    public void HumanoideNoPuedePasarNebulosa(){
        Superficie nebulosa1 = new NebulosaDeAndromeda();
        nebulosa1.getPasos_humanoide();
    }
    
    @Test (expected = NoPuedeMoverseException.class)
    public void HumanoideNoPuedePasarTormenta(){
        Superficie tormenta1 = new TormentaPsionica();
        tormenta1.getPasos_humanoide();
    }
}
