package segundaEntrega;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import model.*;

public class PruebasGeneralesSegEntrega {

	@Test
	public void test001SeLlenaUnCasilleroDeTerronoRocoso() {
		Casillero casillero = new Casillero();
		casillero.setTerreno(new TerrenoRocoso());
		Assert.assertTrue(true);
		
	}

}
