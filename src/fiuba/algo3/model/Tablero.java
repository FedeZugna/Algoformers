/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Martin
 */
public class Tablero {
   
    private HashMap<Coordenada,Casillero> casilleros;
    
    public void Tablero(int ancho, int largo){
        /*for x in ancho{for y in largo{new Coordenada(x,y)}}? 
        o hago un método static de Coordenada que devuelva un List<Coordenada>
        List<Coordenada> coordenadas =/* O LO SACO DE ACA O LO SIGUIENTE VA EN UN FOR ANIDADO
        for (Coordenada coordenada : coordenadas){
            
        }*/
    }

    public void ubicarElemento(Algoformer algof1, Coordenada coord1) {
        this.casilleros.get(coord1).ubicarElemento(algof1);
    }
    
    
}
