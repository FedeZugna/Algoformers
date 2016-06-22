/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaEntrega;

import model.bonus.Stat;
import model.bonus.ModificadorPorcentualPermanente;
import model.bonus.StatModifier;
import org.junit.Test;
import model.algoformers.*;
import model.bonus.Inmobilizador;
import model.excepciones.NoPuedeMoverseException;
import static org.junit.Assert.*;


/**
 *
 * @author Martin
 */
public class StatTests {
    
    public StatTests() {
    }
    
    @Test
    public void StatContainerVacioDevuelveElStatBase(){
        int STAT_BASE = 10;
        Stat stat1 = new Stat(STAT_BASE);
        assertTrue(stat1.devolverStat()==STAT_BASE);
    }
    
    @Test
    public void StatContainerAceptaModificadoresYAfectanAlResultado(){
        int STAT_BASE = 10, PORCENTAJE = 20;
        Stat stat1 = new Stat(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE);
        stat1.agregarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE)/100));
    }
    
    @Test
    public void StatContainerQuitaModificadoresYVuelveAResultadoOriginal(){
        int STAT_BASE = 10, PORCENTAJE = 20;
        Stat stat1 = new Stat(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE);
        stat1.agregarModificador(porcentual1);
        stat1.quitarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==STAT_BASE);
    }
    
    @Test
    public void StatContainerNoAgrega2VecesElMismoModificador(){
        int STAT_BASE = 10, PORCENTAJE = 20;
        Stat stat1 = new Stat(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE);
        stat1.agregarModificador(porcentual1);
        stat1.agregarModificador(porcentual1);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE)/100));
    }
    
    @Test
    public void StatContainerNoStackeaModificadoresDelMismoTipo(){
        int STAT_BASE = 10, PORCENTAJE1 = 20, PORCENTAJE2 = 30;
        Stat stat1 = new Stat(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE1);
        StatModifier porcentual2 = new ModificadorPorcentualPermanente(PORCENTAJE2);
        stat1.agregarModificador(porcentual1);
        stat1.agregarModificador(porcentual2);
        assertTrue(stat1.devolverStat()==(STAT_BASE*(100+PORCENTAJE1)/100));
    }
    
    @Test
    public void QuitarModificadoresNoAfectaLosRestantes(){
        int STAT_BASE = 10, PORCENTAJE1 = 20, DURACION = 30;
        Stat stat1 = new Stat(STAT_BASE);
        StatModifier porcentual1 = new ModificadorPorcentualPermanente(PORCENTAJE1);
        StatModifier inmobilizador = new Inmobilizador(DURACION);
        stat1.agregarModificador(porcentual1);
        stat1.agregarModificador(inmobilizador);
        stat1.quitarModificador(porcentual1);
        assertTrue(0==stat1.devolverStat());
    }
}
