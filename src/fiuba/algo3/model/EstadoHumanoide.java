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
public class EstadoHumanoide extends EstadoAlgoformer {
    
	
    public EstadoHumanoide(int ataque, int distancia_ataque, int velocidad_despl) {
        super(ataque, distancia_ataque, velocidad_despl);
    }

	@Override
	public int devolverPasosPara(Terreno terreno) {
		return terreno.getPasos_humanoide();
	}
    
}
