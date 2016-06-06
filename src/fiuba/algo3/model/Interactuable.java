package model;

public interface Interactuable {
	    
	 public Casillero getUbicacion();
	    	    	    	    	 	
	 public String getNombre();
	 
	 public boolean estaVivo();

	public void fueUbicadoEn(Casillero casillero);
}
