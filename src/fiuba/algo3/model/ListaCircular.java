package model;

public class ListaCircular {
	ContListaCircular primero;
	ContListaCircular ultimo;
	ContListaCircular corriente;
	int posAbs = 0;

	public ListaCircular() {
	     this.primero = null;
	     this.ultimo = null;
	     this.corriente = null;
	}

	public boolean isEmpty() { return (primero == null); }

	public void add(Object val) {
		this.posAbs++;
		ContListaCircular nuevo = new ContListaCircular(val,this.posAbs);

	    nuevo.proximoEs(primero);
	    ultimo = nuevo;
	    if(isEmpty())
	    	primero = nuevo;
	    this.corriente=nuevo;
	}
	
	public EstadoAlgoformer get(){
		EstadoAlgoformer estadoActual = (EstadoAlgoformer) this.corriente.getDato();
		this.corriente = this.corriente.next();
		return estadoActual;
	}
	
	public EstadoAlgoformer get(int pos) throws Exception{
		ContListaCircular current = primero;
		int contador=1;
		while ((current.getPos()<pos) && (contador <= this.posAbs)){
			current=current.next();
		}
		if (current.getPos()<pos){
			throw new Exception();
		}
		return (EstadoAlgoformer) current.getDato();
	}

}
