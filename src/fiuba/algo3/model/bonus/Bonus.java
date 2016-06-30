package model.bonus;

import model.excepciones.AccionInvalidaException;
import model.*;
import model.algoformers.Algoformer;
import model.superficies.Superficie;

public abstract class Bonus extends StatModifierConDuracion implements Notificable, Interactuable {
	
	private String nombre;
	private Casillero ubicacion;
	private Algoformer duenio;
	private String rutaImg = "file:src/fotos/pueba1.png";
	
	
    public Bonus(int duracion) {
        super(duracion);
    }
	
	
	@Override
	public Casillero getUbicacion() {
		return this.ubicacion;
	}

	@Override
	public void setUbicacion(Casillero ubicacion) {
		this.ubicacion = ubicacion;
		
	}
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void ubicarEn(Casillero casillero) {
		this.ubicacion = casillero;
	}
	
	public boolean fueUbicadoEn(Casillero casillero){
		return this.ubicacion == casillero;
	}

	public void cambiarDuenio(Algoformer duenio){
		this.duenio = duenio;
	}
        /*
	public void destruir() {
		this.duenio.quitarBonus(this);
	}
	*/
	@Override
	public boolean estaVivo() {
		throw new AccionInvalidaException();
	}
	
	@Override
	public void aplicarseEfectosSuperficie(Superficie superficie) {
		
	}
	
    public void serCapturadoPor(Algoformer a){
    	this.cambiarDuenio(a);
        Tablero.getInstancia().agregarNotificable(this);
        //System.out.println("HOLIS");
        
    }
    @Override
    public String devuelveNombreCont() {
    	return rutaImg;
    }
}
