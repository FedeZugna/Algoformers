/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceraEntrega;

import model.algoformers.Algoformer;
import model.algoformers.Optimus;
import model.bonus.DobleCanion;
import model.bonus.Flash;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Martin
 */
public class BonusTests {
    
    public BonusTests(){}
    
    @Test
    public void DobleCanionDuplicaElDanio(){
        int danio_base, danio_bonificado;
        Algoformer optimus = new Optimus();
        danio_base = optimus.getAtaque();
        DobleCanion dobleCanion = new DobleCanion();
        optimus.capturarBonus(dobleCanion);
        danio_bonificado = optimus.getAtaque();
        Assert.assertTrue((2*danio_base)==danio_bonificado);
    }
    
    @Test
    public void DobleCanionDura3Turnos(){
        int danio_base, danio_bonificado;
        Algoformer optimus = new Optimus();
        danio_base = optimus.getAtaque();
        DobleCanion dobleCanion = new DobleCanion();
        optimus.capturarBonus(dobleCanion);
        dobleCanion.notificar();//el turno que pasa capturando
        dobleCanion.notificar();
        dobleCanion.notificar();
        dobleCanion.notificar();        
        danio_bonificado = optimus.getAtaque();
        Assert.assertTrue(danio_base==danio_bonificado);
    }
    
    @Test
    public void BurbujaInmaculadaAnulaDanioRecibido(){
    
    }
    
    @Test
    public void BurbujaInmaculadaDura2Turnos(){
    
    }

    @Test
    public void FlashTriplicaVelocidadDesplazamiento(){
        int velocidad_base, velocidad_bonificada;
        Algoformer optimus = new Optimus();
        velocidad_base = optimus.getVelocidad_despl();
        Flash flash = new Flash();
        optimus.capturarBonus(flash);
        velocidad_bonificada = optimus.getVelocidad_despl();
        Assert.assertTrue((3*velocidad_base)==velocidad_bonificada);
    }
    
    @Test
    public void FlashDura3Turnos(){
        int velocidad_base, velocidad_bonificada;
        Algoformer optimus = new Optimus();
        velocidad_base = optimus.getVelocidad_despl();
        Flash flash = new Flash();
        optimus.capturarBonus(flash);
        flash.notificar(); //el turno que gasta capturando
        flash.notificar();
        flash.notificar();
        flash.notificar();
        velocidad_bonificada = optimus.getVelocidad_despl();
        Assert.assertTrue(velocidad_base==velocidad_bonificada);
    }
}
