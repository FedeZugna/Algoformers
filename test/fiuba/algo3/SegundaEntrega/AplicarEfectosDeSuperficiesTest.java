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

public class AplicarEfectosDeSuperficiesTest {
    
    public AplicarEfectosDeSuperficiesTest() {
    }
    /*
    //NOTA: Sabemos que aplicar efecto afecta Algoformer sin depender de su estado, pero probamos en ambos para garantizarlo.
    
    //    TERRENO
    
    
    public void RocosoConHumanoideNoAfecta(){
        Algoformer optimus1 = new Optimus();
        Algoformer optimus2 = new Optimus();
        Superficie rocoso1 = new TerrenoRocoso();
        rocoso1.aplicarEfectoSuperficie(optimus1);
        //probar velocidad igual en ambos
        //probar ataque igual en ambos
        //probar vida igual en ambos
    }
    
    public void RocosoConAlternoNoAfecta(){
        Algoformer optimus1 = new Optimus();
        optimus1.transformar();
        Algoformer optimus2 = new Optimus();
        optimus2.transformar();
        Superficie rocoso1 = new TerrenoRocoso();
        rocoso1.aplicarEfectoSuperficie(optimus1);
        //probar velocidad igual en ambos
        //probar ataque igual en ambos
        //probar vida igual en ambos
    }
    
    public void EspinosoConHumanoideAplicaDanio(){
        Algoformer optimus1 = new Optimus();
        Algoformer optimus2 = new Optimus();
        Superficie espinoso1 = new TerrenoDeEspinas();
        espinoso1.aplicarEfectoSuperficie(optimus1);
        //probar velocidad igual en ambos
        //probar ataque igual en ambos
        //probar vida menor en optimus1
    }
    
    public void EspinosoConAlternoAplicaDanio(){
        Algoformer optimus1 = new Optimus();
        optimus1.transformar();
        Algoformer optimus2 = new Optimus();
        optimus2.transformar();
        Superficie espinoso1 = new TerrenoDeEspinas();
        espinoso1.aplicarEfectoSuperficie(optimus1);
        //probar velocidad igual en ambos
        //probar ataque igual en ambos
        //probar vida menor en optimus1
    }
    
    public void PantanosoConAlternoNoAfectaStats(){
        Algoformer optimus1 = new Optimus();
        optimus1.transformar();
        Algoformer optimus2 = new Optimus();
        optimus2.transformar();
        Superficie pantanoso1 = new TerrenoPantanoso();
        pantanoso1.aplicarEfectoSuperficie(optimus1);
        //probar velocidad igual en ambos
        //probar ataque igual en ambos
        //probar vida igual en ambos
    }
    
    //    ESPACIO AEREO
    
    public void NubeConAlternoNoAfectaStats(){
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie nube1 = new Nube();
        nube1.aplicarEfectoSuperficie(ratchet1);
        //probar velocidad igual en ambos
        //probar ataque igual en ambos
        //probar vida igual en ambos
    }
    
    public void NebulosaConAlternoBajaVelocidad(){
        //Tal vez para este haga falta meter todo en un contexto de tablero (a confirmar)
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie nebulosa1 = new NebulosaDeAndromeda();
        nebulosa1.aplicarEfectoSuperficie(ratchet1);
        //probar velocidad1 = 0
        //probar ataque igual en ambos
        //probar vida igual en ambos
    }
    
    public void EfectoNebulosaDura3Turnos(){
        //Tal vez para este haga falta meter todo en un contexto de tablero (a confirmar)
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie nebulosa1 = new NebulosaDeAndromeda();
        nebulosa1.aplicarEfectoSuperficie(ratchet1);
        //probar velocidad1 = 0
        //pasarTurno
        //probar velocidad1 = 0
        //pasarTurno
        //probar velocidad1 = 0
        //pasarTurno
        //probar velocidad igual en ambos
    }
    public void TormentaConAlternoBajaAtaque(){
        Algoformer ratchet1 = new Ratchet();
        ratchet1.transformar();
        Algoformer ratchet2 = new Ratchet();
        ratchet2.transformar();
        Superficie tormenta1 = new TormentaPsionica();
        tormenta1.aplicarEfectoSuperficie(ratchet1);
        //probar velocidad igual en ambos
        //probar ataque1 = 60% ataque2
        //probar vida igual en ambos
    }
    */
}
