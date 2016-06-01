package model;

public interface Interactuable {

	 public void inicializarAlgoformer (String nombre, int vidaPropia, int ataqueHumanoide, int distanciaAtaqueHumanoide, int velocidadHumanoide, int ataqueAlterno, int distanciaAtaqueAlterno, int velocidadAlterno);
	    
	 public Coordenada getUbicacion();
	    
	 public EstadoAlgoFormer getEstadoActual();
	    
	 public boolean esMovimientoPosible(Coordenada coordObjetivo);
	    
	 public boolean esAtaquePosible(Coordenada coordObjetivo);
	    
	 public void recibirAtaque(int danio);

	 public void morir();
	 
	 public boolean estaVivo();
	
	 public void mover(Tablero tablero, Coordenada destino);

	 public String getNombre();
	
	 public void transformar();

	 public int getAtaque();
	 
	 public ListaCircular getEstados();
	
}
