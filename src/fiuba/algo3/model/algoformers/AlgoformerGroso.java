package model.algoformers;

public abstract class AlgoformerGroso extends Algoformer{
	
	protected int vidaDe1;
	protected int vidaDe2;
	protected int vidaDe3;
	protected int correspondenciaDe1;
	protected int correspondenciaDe2;
	protected int correspondenciaDe3;
	
	protected void calcularCorrespondenciaDeVidaDeCadaUno() {
		this.correspondenciaDe1= vidaDe1*100/vida;
		this.correspondenciaDe2= vidaDe2*100/vida;
		this.correspondenciaDe3= vidaDe3*100/vida;
	}	
	
	public int getVida1() {
		return (this.getVida()*correspondenciaDe1/100);
	}
	
	public int getVida2() {
		return (this.getVida()*correspondenciaDe2/100);
	}
	
	public int getVida3() {
		return (this.getVida()*correspondenciaDe3/100);
	}
}
