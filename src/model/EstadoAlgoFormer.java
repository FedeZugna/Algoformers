/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class EstadoAlgoFormer {
    
    private int ataque;
    private int distancia_ataque;
    private int velocidad_despl;

    public EstadoAlgoFormer(int ataque, int distancia_ataque, int velocidad_despl) {
        this.ataque = ataque;
        this.distancia_ataque = distancia_ataque;
        this.velocidad_despl = velocidad_despl;
    }
    
    //SIN COMMAND
    boolean esMovimientoPosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean esAtaquePosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
