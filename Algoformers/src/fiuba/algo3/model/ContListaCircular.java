package model;

public class ContListaCircular {
	private Object dato;
	private ContListaCircular next;
	private int pos;

	public ContListaCircular(Object val, int pos) {
		dato = val;
		next = null;
		this.pos = pos;
	}

	public void proximoEs(ContListaCircular este) {
		this.next = este;
	}

	public ContListaCircular next() {
		return this.next;
	}

	public int getPos() {
		return this.pos;
	}

	public Object getDato() {
		return this.dato;
	}

}
