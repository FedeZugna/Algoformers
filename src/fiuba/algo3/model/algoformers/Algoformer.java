/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.algoformers;

import model.excepciones.NoPuedeMoverseException;
import model.excepciones.AlcanceExcedidoException;
import java.util.ArrayList;


import model.*;

import model.bonus.*;
import model.superficies.*;

public class Algoformer implements Interactuable {
	protected EstadoAlgoformer estadoActual;
	protected ListaCircularEstatica estados;
	protected Casillero ubicacion;
	protected String nombre;
	protected int vida;
	protected int movimientosRestantes;
    protected Stat armadura;
	private String rutaImgAlt;
	private String rutaImgHum;
	
	public void inicializarAlgoformer(String nombre, int vidaPropia, int ataqueHumanoide, int distanciaAtaqueHumanoide,
		int velocidadHumanoide, int ataqueAlterno, int distanciaAtaqueAlterno, int velocidadAlterno, String rutaHumanoide, String rutaAlterno) {
		this.nombre = nombre;
		this.vida = vidaPropia;
		EstadoAlgoformer estadoHumanoide = new EstadoHumanoide(ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide);
		EstadoAlgoformer estadoAlterno = new EstadoAlterno(ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
		ArrayList<EstadoAlgoformer> lista = new ArrayList<EstadoAlgoformer>();
		lista.add(estadoHumanoide);
		lista.add(estadoAlterno);
		ListaCircularEstatica estados = new ListaCircularEstatica(lista);
		this.estados = estados;
		this.estadoActual = this.estados.get();
		this.movimientosRestantes = estadoActual.getVelocidadDespl();
                this.armadura = new Stat(0);
        this.rutaImgHum= rutaHumanoide;
        this.rutaImgAlt= rutaAlterno;
	}

	@Override
	public Casillero getUbicacion() {
		return this.ubicacion;
	}

	public EstadoAlgoformer getEstadoActual() {
		return this.estadoActual;
	}

	public void ubicarEn(Casillero cas1) {
		this.ubicacion = cas1;
	}

	public void recibirAtaque(int danio) {
                this.armadura.cambiarValorBase(danio);
                int danio_efectivo = this.armadura.devolverStat();
		this.vida -= danio_efectivo;
		if (this.vida < 0) {
			this.morir(); // para avisarle al Tablero que lo borre, etc
		}
	}

	public void morir() {
		this.vida = 0;
		this.ubicacion.removerElemento();//
		// avisar a la vista que mate al transformer
	}

	@Override
	public boolean estaVivo() {
		return (this.vida > 0);
	}

	public void mover(Casillero destino) {		
		int pasosAMoverse = this.estadoActual.devolverPasosPara(destino);
		if ((this.movimientosRestantes - pasosAMoverse)<0){
			throw new NoPuedeMoverseException();
		}
		this.ubicacion.removerElemento(); //eliminar esta linea si se usa el "cambiar" de jugador
		destino.ubicarElemento(this);
		this.ubicacion = destino;
		this.movimientosRestantes -= pasosAMoverse;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	public void transformar() {
		this.estadoActual = this.estados.get();
		this.movimientosRestantes = this.estadoActual.getVelocidadDespl();
	}

	public int getAtaque() {
		return this.estadoActual.getAtaque();
	}

	public ListaCircularEstatica getEstados() {
		return this.estados;
	}

	public void atacar(Algoformer enemigo) {
		if (!esAtaquePosible(enemigo.getUbicacion().getUbicacion())) {
			throw new AlcanceExcedidoException();
		}
		enemigo.recibirAtaque(this.getAtaque());

	}

	public boolean esMovimientoPosible(Coordenada coordObjetivo) {
		Coordenada coordOrigen = this.getUbicacion().getUbicacion();
		return this.getEstadoActual().esMovimientoPosible(coordOrigen, coordObjetivo);
	}

	public boolean esAtaquePosible(Coordenada coordObjetivo) {
		Coordenada coordOrigen = this.getUbicacion().getUbicacion();
		return this.getEstadoActual().esAtaquePosible(coordOrigen, coordObjetivo);
	}

	private boolean esCombinacionPosible(Coordenada coordenadaAmiga) {
		Coordenada coordenadaOrigen = this.getUbicacion().getUbicacion();
		return this.getEstadoActual().esCombinacionPosible(coordenadaOrigen, coordenadaAmiga);
	}

	public int getVida() {
		return this.vida;
	}

	public int devolverPasosPara(Superficie terreno) {
		return this.estadoActual.devolverPasosPara(terreno);
	}

	public int getVelocidad_despl() {
		return this.estadoActual.getVelocidadDespl();
	}

	public boolean esCombinableCon(Algoformer algoformerACombinar) {
		if (!esCombinacionPosible(algoformerACombinar.getUbicacion().getUbicacion())) {
			throw new AlcanceExcedidoException();
		}
		return true;
	}
	
	public void setVidaAlSeparar(int vidaACambiar) {
		this.vida= vidaACambiar;
	}

	public int getMovimientosRestantes() {
		return this.movimientosRestantes;
	}
	
	public int getAlcance() {
		return estadoActual.getDistanciaAtaque();
	}
	
	public void aplicarseEfectosSuperficie(Superficie superficie){
		superficie.aplicarEfectosSuperficieAlgoformer(this);
	}
	
	public void capturarBonus(Bonus bonus){
		bonus.serCapturadoPor(this);
	}

	@Override
	public void setUbicacion(Casillero ubicacion) {
		// TODO Auto-generated method stub
		
	}
  
    public void agregarModificadorArmadura(StatModifier modificador){
        this.armadura.agregarModificador(modificador);
    }
    
    public void agregarModificadorAtaque(StatModifier modificador){
        this.estadoActual.agregarModificadorAtaque(modificador);
    }
    
    public void agregarModificadorDistanciaAtaque(StatModifier modificador){
        this.estadoActual.agregarModificadorDistanciaAtaque(modificador);
    }
    
    public void agregarModificadorVelocidadDesplazamiento(StatModifier modificador){
        this.estadoActual.agregarModificadorVelocidadDesplazamiento(modificador);
    }

	@Override
	public String devuelveNombreCont() {
		return estadoActual.devuelveRutaImg(this);
	}

	public String devuelveNombreContAlterno() {
		return this.rutaImgAlt;
	}

	public String devuelveNombreContHumanoide() {
		return this.rutaImgHum;
	}
}
