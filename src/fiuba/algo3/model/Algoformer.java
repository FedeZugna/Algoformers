/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Algoformer {
    protected EstadoAlgoFormer estadoActual;
    protected ListaCircular estados; //A reemplazar si el Estado se ocupa de esto
    protected Coordenada ubicacion; //El bicho tiene que saber donde esta parado
    protected String nombre;
    protected int vida;
    
    public Coordenada getUbicacion(){
        return this.ubicacion;
    }
    
    private EstadoAlgoFormer getEstadoActual(){ //por ahora private
        return this.estadoActual;
    }
    
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

	private void morir() {
		this.vida= 0;
		//avisar a la vista que mate al transformer
	}
	public boolean estaVivo() {
		return (this.vida>0);
	}
	public void mover(Tablero tablero, Coordenada destino) {
		this.ubicacion=destino;
	}
}
