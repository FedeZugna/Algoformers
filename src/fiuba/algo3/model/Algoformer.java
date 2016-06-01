/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Algoformer implements Interactuable{
    protected EstadoAlgoFormer estadoActual;
    protected ListaCircular estados; //A reemplazar si el Estado se ocupa de esto
    protected Coordenada ubicacion; //El bicho tiene que saber donde esta parado
    protected String nombre;
    protected int vida;
    
    
    @Override
    public void inicializarAlgoformer (String nombre, int vidaPropia, int ataqueHumanoide, int distanciaAtaqueHumanoide, int velocidadHumanoide, int ataqueAlterno, int distanciaAtaqueAlterno, int velocidadAlterno) {
    	
    	this.nombre= nombre;
    	this.vida= vidaPropia;
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide);//ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;
	    this.estadoActual = this.estados.get();
    }
    
    @Override
    public Coordenada getUbicacion(){
        return this.ubicacion;
    }
    
    @Override
    public EstadoAlgoFormer getEstadoActual(){ //por ahora private
        return this.estadoActual;
    }
    
    @Override
    public boolean esMovimientoPosible(Coordenada coordObjetivo){
        Coordenada coordOrigen = this.getUbicacion();
        return this.getEstadoActual().esMovimientoPosible(coordOrigen,coordObjetivo);
    }
    
    @Override
    public boolean esAtaquePosible(Coordenada coordObjetivo){
        Coordenada coordOrigen = this.getUbicacion();
        return this.getEstadoActual().esAtaquePosible(coordOrigen,coordObjetivo);
    }
    
    @Override
    public void recibirAtaque(int danio){
        this.vida -= danio;
        if (this.vida <0){
            this.morir(); //para avisarle al Tablero que lo borre, etc
            }
    }

    @Override
	public void morir() {
		this.vida= 0;
		//avisar a la vista que mate al transformer
	}
    
    @Override
	public boolean estaVivo() {
		return (this.vida>0);
	}
    
    @Override
	public void mover(Tablero tablero, Coordenada destino) {
		this.ubicacion=destino;
	}

    @Override
	public String getNombre() {
		return this.nombre;
	}
    
    @Override
	public void transformar(){
		this.estadoActual = this.estados.get();
	}

    @Override
	public int getAtaque() {
		return this.estadoActual.getAtaque();
	}

    @Override
	public ListaCircular getEstados() {
		return this.estados;
	}
}
