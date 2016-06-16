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

import org.junit.Assert;
/**
 *
 * @author Martin
 */

public class AplicarEfectosDeSuperficiesTest {
    
    public AplicarEfectosDeSuperficiesTest() {
    }
    
    //NOTA: Sabemos que aplicar efecto afecta Algoformer sin depender de su estado, pero probamos en ambos para garantizarlo.
    
    //    TERRENO
    
    @Test
    public void RocosoConHumanoideNoAfecta(){
        Algoformer optimus1 = new Optimus();
        Algoformer optimus2 = new Optimus();
        Superficie rocoso1 = new TerrenoRocoso();
        rocoso1.aplicarEfectosSuperficie(optimus1);
        Assert.assertTrue(optimus1.getVelocidad_despl() == optimus2.getVelocidad_despl());
        Assert.assertTrue(optimus1.getAtaque() == optimus2.getAtaque());
        Assert.assertTrue(optimus1.getVida() == optimus2.getVida());
    }
    
    @Test
    public void RocosoConAlternoNoAfecta(){
        Algoformer optimus1 = new Optimus();
        optimus1.transformar();
        Algoformer optimus2 = new Optimus();
        optimus2.transformar();
        Superficie rocoso1 = new TerrenoRocoso();
        rocoso1.aplicarEfectosSuperficie(optimus1);
        Assert.assertTrue(optimus1.getVelocidad_despl() == optimus2.getVelocidad_despl());
        Assert.assertTrue(optimus1.getAtaque() == optimus2.getAtaque());
        Assert.assertTrue(optimus1.getVida() == optimus2.getVida());
    }

    @Test
    public void EspinosoConHumanoideAplicaDanio(){
        Algoformer optimus1 = new Optimus();
        Algoformer optimus2 = new Optimus();
        Superficie espinoso1 = new TerrenoDeEspinas();
        espinoso1.aplicarEfectosSuperficie(optimus1);
        Assert.assertTrue(optimus1.getVelocidad_despl() == optimus2.getVelocidad_despl());
        Assert.assertTrue(optimus1.getAtaque() == optimus2.getAtaque());
        Assert.assertTrue(optimus1.getVida() == (optimus2.getVida() - optimus2.getVida()*0.05));
    }

 	@Test
    public void EspinosoConAlternoAplicaDanio(){
        Algoformer optimus1 = new Optimus();
        optimus1.transformar();
        Algoformer optimus2 = new Optimus();
        optimus2.transformar();
        Superficie espinoso1 = new TerrenoDeEspinas();
        espinoso1.aplicarEfectosSuperficie(optimus1);
        Assert.assertTrue(optimus1.getVelocidad_despl() == optimus2.getVelocidad_despl());
        Assert.assertTrue(optimus1.getAtaque() == optimus2.getAtaque());
        Assert.assertTrue(optimus1.getVida() == (optimus2.getVida() - optimus2.getVida()*0.05));
    }

    @Test
    public void PantanosoConAlternoNoAfectaStats(){
        Algoformer optimus1 = new Optimus();
        optimus1.transformar();
        Algoformer optimus2 = new Optimus();
        optimus2.transformar();
        Superficie pantanoso1 = new TerrenoPantanoso();
        pantanoso1.aplicarEfectosSuperficie(optimus1);
        Assert.assertTrue(optimus1.getVelocidad_despl() == optimus2.getVelocidad_despl());
        Assert.assertTrue(optimus1.getVida() == optimus2.getVida());
        Assert.assertTrue(optimus1.getAtaque() == optimus2.getAtaque());
       
    }
    
    //    ESPACIO AEREO


    @Test
    public void NubeConAlternoNoAfectaStats(){
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie nube1 = new Nube();
        nube1.aplicarEfectosSuperficie(ratchet1);
        
        Assert.assertTrue(ratchet1.getVelocidad_despl() == ratchet2.getVelocidad_despl());
        Assert.assertTrue(ratchet1.getAtaque() == ratchet2.getAtaque());
        Assert.assertTrue(ratchet1.getVida() == ratchet2.getVida());
     }

    @Test
    public void NebulosaConAlternoBajaVelocidad(){
        //Tal vez para este haga falta meter todo en un contexto de tablero (a confirmar)
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie nebulosa1 = new NebulosaDeAndromeda();
        nebulosa1.aplicarEfectosSuperficie(ratchet1);
        Assert.assertTrue(ratchet1.getVelocidad_despl() == 0);
        Assert.assertTrue(ratchet1.getAtaque() == ratchet2.getAtaque());
        Assert.assertTrue(ratchet1.getVida() == ratchet2.getVida());

    }

/*
    @Test
    public void EfectoNebulosaDura3Turnos(){
        //Tal vez para este haga falta meter todo en un contexto de tablero (a confirmar)
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie nebulosa1 = new NebulosaDeAndromeda();
        nebulosa1.aplicarEfectosSuperficie(ratchet1);
        Assert.assertTrue(ratchet1.getVelocidad_despl() == 0);
        //pasarTurno
        Assert.assertTrue(ratchet1.getVelocidad_despl() == 0);
        //pasarTurno
        Assert.assertTrue(ratchet1.getVelocidad_despl() == 0);
        //pasarTurno
        Assert.assertTrue(ratchet1.getVelocidad_despl() == ratchet2.getVelocidad_despl());
    }
    
    @Test
    public void TormentaConAlternoBajaAtaque(){
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie tormenta1 = new TormentaPsionica();
        tormenta1.aplicarEfectosSuperficie(ratchet1);
        Assert.assertTrue(ratchet1.getVelocidad_despl() == 0);
        Assert.assertTrue(ratchet1.getAtaque() == ratchet2.getAtaque() - ratchet2.getAtaque()*0.4);
        Assert.assertTrue(ratchet1.getVida() == ratchet2.getVida());
    }
    */
}
