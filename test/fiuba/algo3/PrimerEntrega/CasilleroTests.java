package primerEntrega;

import model.excepciones.CasilleroOcupadoException;
import org.junit.Assert;

import org.junit.Test;

import model.*;
import model.algoformers.*;
import model.superficies.*;

public class CasilleroTests {

	@Test
	public void test01CasilleroSeCreaVacio() {
		Casillero cas = new Casillero(new TerrenoRocoso(), new Nube());
		Assert.assertFalse(cas.casilleroOcupado());
	}

	@Test
	public void test02CasilleroSeLlenaCorrectamente() {
		Casillero cas = new Casillero(new TerrenoRocoso(), new Nube());
		Assert.assertFalse(cas.casilleroOcupado());
		Algoformer algo1 = new Optimus();
		cas.ubicarElemento(algo1);
		Assert.assertTrue(cas.casilleroOcupado());
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test03SiSeQuiereUbicarEnCasilleroUbicadoArrojaExcepcion() {
		Casillero cas = new Casillero(new TerrenoRocoso(), new Nube());
		Assert.assertFalse(cas.casilleroOcupado());
		Algoformer algo1 = new Optimus();
		cas.ubicarElemento(algo1);
		Assert.assertTrue(algo1.getUbicacion() == cas);
		cas.ubicarElemento(algo1);
	}

	@Test
	public void test04CasilleroSeVaciaCorrectamente() {
		Casillero cas = new Casillero(new TerrenoRocoso(), new Nube());
		Assert.assertFalse(cas.casilleroOcupado());
		Algoformer algo1 = new Optimus();
		cas.ubicarElemento(algo1);
		Assert.assertTrue(cas.casilleroOcupado());
		cas.removerElemento();
		Assert.assertFalse(cas.casilleroOcupado());
	}
}
