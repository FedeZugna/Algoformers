/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Algoformer implements Interactuable{
    protected EstadoAlgoformer estadoActual;
    protected ListaCircularEstatica estados;
    protected Coordenada ubicacion; 
    protected String nombre;
    protected int vida;
    
    
   public void inicializarAlgoformer(String nombre, int vidaPropia, int ataqueHumanoide, int distanciaAtaqueHumanoide, int velocidadHumanoide, int ataqueAlterno, int distanciaAtaqueAlterno, int velocidadAlterno ) {
	   this.nombre=nombre;
	   this.vida=vidaPropia;
	   EstadoAlgoformer estadoHumanoide = new EstadoHumanoide (ataqueHumanoide,distanciaAtaqueHumanoide,velocidadHumanoide);
	   EstadoAlgoformer estadoAlterno = new EstadoAlterno(ataqueAlterno,distanciaAtaqueAlterno,velocidadAlterno);
	   ArrayList<EstadoAlgoformer> lista = new ArrayList<EstadoAlgoformer>();
	   lista.add(estadoHumanoide);
	   lista.add(estadoAlterno);
	   ListaCircularEstatica estados = new ListaCircularEstatica(lista);
	   this.estados = estados;
	   this.estadoActual = this.estados.get();
   }
    
    
    @Override
    public Coordenada getUbicacion(){
        return this.ubicacion;
    }
    
    public EstadoAlgoformer getEstadoActual(){
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
    
	public void fueUbicadoEn(Coordenada coord1){
		this.ubicacion = coord1;
	};

    
    public void recibirAtaque(int danio){
        this.vida -= danio;
        if (this.vida <0){
            this.morir(); //para avisarle al Tablero que lo borre, etc
            }
    }

	public void morir() {
		this.vida = 0;
		//avisar a la vista que mate al transformer
	}
    
	@Override
	public boolean estaVivo() {
		return (this.vida>0);
	}
    
	public void mover(Tablero tablero, Coordenada destino) {
		this.ubicacion=destino;
		
	}

    @Override
	public String getNombre() {
		return this.nombre;
	}
    
	public void transformar(){
		this.estadoActual = this.estados.get();
	}

	public int getAtaque() {
		return this.estadoActual.getAtaque();
	}

	public ListaCircularEstatica getEstados() {
		return this.estados;
	}

	public void atacar(Algoformer enemigo){
		if(!esAtaquePosible(enemigo.getUbicacion())){
			throw new AlcanceExcedidoException();
		}
		enemigo.recibirAtaque(this.getAtaque());
		
	}

	public int getVida() {
		return this.vida;
	}
}
