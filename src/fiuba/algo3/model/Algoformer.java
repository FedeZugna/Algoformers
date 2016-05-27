/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Algoformer {
    private EstadoAlgoFormer estadoActual;
    private List<EstadoAlgoFormer> estados; //A reemplazar si el Estado se ocupa de esto
    private Coordenada ubicacion; //El bicho tiene que saber donde esta parado
    private String nombre;
    private int vida;
    
    public Algoformer(String nombre, int vida, List<EstadoAlgoFormer> estados){
        this.nombre = nombre;
        this.vida = vida;
        this.estadoActual = estados.get(0);//El primer estado del iterable será el de invocacion
        this.estados = new ArrayList<>(estados);
    }
    
    public Coordenada getUbicacion(){
        return this.ubicacion;
    }
    
    private EstadoAlgoFormer getEstadoActual(){ //por ahora private
        return this.estadoActual;
    }
    
    //COMMAND
    /*
    ?
    */
    
    //SIN COMMAND?
    public boolean esMovimientoPosible(Coordenada coordObjetivo){
        Coordenada coordOrigen = this.getUbicacion();
        return this.getEstadoActual().esMovimientoPosible(coordOrigen,coordObjetivo);
    }
    
    public boolean esAtaquePosible(Coordenada coordObjetivo){
        Coordenada coordOrigen = this.getUbicacion();
        return this.getEstadoActual().esAtaquePosible(coordOrigen,coordObjetivo);
    }
    
    public void recibirAtaque(int danio){
        this.vida -= danio;
        if (this.vida <0){
            this.morir(); //para avisarle al Tablero que lo borre, etc
            }
    }
}
