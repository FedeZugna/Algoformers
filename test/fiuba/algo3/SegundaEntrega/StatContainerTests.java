/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaEntrega;

import org.junit.Test;
import model.algoformers.*;
import static org.junit.Assert.*;
import model.*;

/**
 *
 * @author Martin
 */
public class StatContainerTests {
    
    public StatContainerTests() {
    }
    
    @Test
    public void StatContainerVacioDevuelveElStatBase(){
        int STAT_BASE = 10;
        StatContainer stat1 = new StatContainer(STAT_BASE);
        assertTrue(stat1.devolverStat()==STAT_BASE);
    }
    
    @Test
    public void StatContainerAceptaModificadoresYAfectanAlResultado(){
        int STAT_BASE = 10, PORCENTAJE = 20;
        StatContainer stat1 = new StatContainer(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE);
        stat1.agregarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE)/100));
    }
    
    @Test
    public void StatContainerQuitaModificadoresYVuelveAResultadoOriginal(){
        int STAT_BASE = 10, PORCENTAJE = 20;
        StatContainer stat1 = new StatContainer(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE);
        stat1.agregarModificador(porcentual1);
        stat1.quitarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==STAT_BASE);
    }
    
    @Test
    public void StatContainerNoAgrega2VecesElMismoModificador(){
        int STAT_BASE = 10, PORCENTAJE = 20;
        StatContainer stat1 = new StatContainer(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE);
        stat1.agregarModificador(porcentual1);
        stat1.agregarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE)/100));
    }
    
    @Test
    public void StatContainerStackeaModificadores(){
        int STAT_BASE = 10, PORCENTAJE1 = 20, PORCENTAJE2 = 30;
        StatContainer stat1 = new StatContainer(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE1);
        StatModifier porcentual2 = new ModificadorPorcentualPermanente(PORCENTAJE2);
        stat1.agregarModificador(porcentual1);
        stat1.agregarModificador(porcentual2);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE1)/100*(100+PORCENTAJE2)/100));
    }
    
    @Test
    public void QuitarModificadoresNoAfectaLosRestantes(){
        int STAT_BASE = 10, PORCENTAJE1 = 20, PORCENTAJE2 = 30;
        StatContainer stat1 = new StatContainer(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE1);
        StatModifier porcentual2 = new ModificadorPorcentualPermanente(PORCENTAJE2);
        stat1.agregarModificador(porcentual1);
        stat1.agregarModificador(porcentual2);
        stat1.quitarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE2)/100));
    }
}
