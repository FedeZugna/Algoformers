/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaEntrega;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

/**
 *
 * @author Martin
 */
public class StatModifierTests {
    
    public StatModifierTests() {
    }
    
    @Test
    public void ModificadorPorcentualPermanenteAplicaPorcentajePositivo(){
        int VALOR = 15, PORCENTAJE = 10;
        StatModifier porcentual = new ModificadorPorcentualPermanente(PORCENTAJE);
        assertTrue(porcentual.aplicarModificador(VALOR)==(VALOR*(100+PORCENTAJE)/100));
    }
    
    @Test
    public void ModificadorPorcentualPermanenteAplicaPorcentajeNegativo(){
        int VALOR = 15, PORCENTAJE = -10;
        StatModifier porcentual = new ModificadorPorcentualPermanente(PORCENTAJE);
        assertTrue(porcentual.aplicarModificador(VALOR)==(VALOR*(100+PORCENTAJE)/100));
    }
    
    @Test (expected = NoPuedeMoverseException.class)
    public void InmobilizadorLevantaNoPuedeMoverseException(){
        int VALOR = 15, DURACION = 50;
        StatModifier inmobilizador = new Inmobilizador(DURACION);
        inmobilizador.aplicarModificador(VALOR);
    }
    
    /*
    @Test
    public void InmobilizadorSeDestruyePasadaSuDuracion(){
        int VALOR = 15, DURACION = 1;
        StatContainer contenedor = new StatContainer(VALOR);
        StatModifierConDuracion inmobilizador = new Inmobilizador(DURACION);
        inmobilizador.notificar();
        assertTrue(contenedor.devolverStat()==VALOR);
    }
*/
}
