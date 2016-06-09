/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class StatContainer {
    private LinkedList<StatModifier> modificadores;
    private final int stat_base;

    public StatContainer(int stat_base) {
        this.stat_base = stat_base;
        this.modificadores = new LinkedList<>();
    }
    
    public void agregarModificador(StatModifier modificador){
        modificador.cambiarDuenio(this);
        this.modificadores.add(modificador);
    }
    
    public int devolverStat(){
        int stat = this.stat_base;
        Iterator<StatModifier> iterador = this.modificadores.iterator();
        while (iterador.hasNext()){
            stat = iterador.next().aplicarModificador(stat);
        }
        return stat;
    }
    
    public void quitarModificador(StatModifier modificador){
        this.modificadores.remove(modificador);
    }

    
    
    
}
