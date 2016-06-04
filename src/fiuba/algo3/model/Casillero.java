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
public class Casillero {
    //private TerrenoAire aire;
    //private TerrenoTierra tierra;
//    private Object ocupante;      //Object hasta definir clase de interactuables 
    //debiera ser un algoformer o un "interactuable"? En este tp solo se
                                 //usan algoformers para ocupar casilleros
                                 //LA CHISPA ES OTRO INTERACTUABLE
	private Terreno terreno;
	//private superficieAire;
	private Interactuable ocupante;
	
	
    public Casillero(/*TerrenoAire aire, TerrenoTierra tierra*/) {
        /*this.aire = aire;
        this.tierra = tierra;*/
    	//        this.ocupante = new CasilleroVacio();
    	//this.ocupante= null;
    }
    public void setTerreno(Terreno superficie) {
    	this.terreno = superficie;
    }
    
    public void ubicarElemento(Interactuable ocupanteAAgregar){
        //si esta ocupado resolver
        this.ocupante = ocupanteAAgregar;
    }

	public Interactuable devolverElemento() {
		return this.ocupante;
		
	}
    
	public void removerElemento() {
		ocupante= null;
		//		this.ocupante = new CasilleroVacio();	
	}
    /*
    public bool/void? accederCasillero(Algoformer algof){
        ->si esta ocupado no dejar entrar
        ->aplicar condiciones de terreno
        //RECORDAR LIMPIAR EL OTRO CASILLERO
    }
    */

}
