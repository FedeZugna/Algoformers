/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Coordenada {

	private final int largo;
	private final int alto;

	public Coordenada(int x, int y) {
		this.largo = x;
		this.alto = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Coordenada other = (Coordenada) obj;
		if (this.largo != other.largo) {
			return false;
		}
		if (this.alto != other.alto) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + this.largo;
		hash = 79 * hash + this.alto;
		return hash;
	}

	@Override
	public String toString() {
		return "Coordenada{" + "x=" + this.largo + ", y=" + this.alto + '}';
	}

	public int getLargo() {
		return this.largo;
	}

	public int getAlto() {
		return this.alto;
	}

	public boolean esAlcanzable(Coordenada destino, int alcance) {

		if (destino.getLargo() - this.getLargo() >= alcance) {
			return false;
		}
		if (destino.getAlto() - this.getAlto() >= alcance) {
			return false;
		}
		return true;
	}
	
}
