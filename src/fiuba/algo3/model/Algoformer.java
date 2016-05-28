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
    
    /*
     public Algoformer(String nombre, int vida, ListaCircular estados){
        this.nombre = nombre;
        this.vida = vida;
        this.estadoActual = estados.get(0);//El primer estado del iterable será el de invocacion
        this.estados = new ListaCircular();
    }
     */
    
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

	private void morir() {
		this.vida= 0;
		//avisar a la vista que mate al transformer
	}
	public boolean estaVivo() {
		return (this.vida>0);
	}
	public void mover(Tablero tablero, Coordenada destino) {
		this.notificarCambios(tablero,destino);
		this.ubicacion=destino;
	}

	private void notificarCambios(Tablero tablero, Coordenada destino) {
		tablero.cambiar(this,this.ubicacion,destino);
	}
}
