package segundaEntrega;

import model.*;
import model.algoformers.*;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

public class AtaqueTest {

	// Pruebas para el AtaqueEstandar

	@Test
	public void test01AtaqueEstandarGetDanio() {

		int danio = 100;
		AtaqueEstandar ataque = new AtaqueEstandar(danio);

		Assert.assertTrue(ataque.getDanio() == danio);

	}

	@Test
	public void test02AtaqueEstandarSeAplicaSobreAlgoformer() {
		String NOMBRE_ALGOF1 = "Autobot1";
		int ANCHO = 100, LARGO = 100, VIDA1 = 10, ATAQUE1 = 1, DISTANCIA_ATK1 = 2, VELOCIDAD_DESP1 = 10;
		int HORIZ1 = 8, HORIZ2 = 11, VERT1 = 10, VERT2 = 12;
		int DANIO = 200;
		Coordenada coord1 = new Coordenada(HORIZ1, VERT1);
		Tablero tablero1 = Tablero.getInstancia();
		Jugador jug1 = new Jugador(tablero1, "sin equipo");
		Algoformer algof1 = new Megatron();
		jug1.ubicarElemento(algof1, coord1);

		int vidaInicial = algof1.getVida();
		AtaqueEstandar ataque = new AtaqueEstandar(DANIO);
		ataque.ataqueEjecutar(algof1);

		Assert.assertTrue(algof1.getVida() == vidaInicial - DANIO);
	}

	// Pruebas AtaquePorcentual

	@Test
	public void test03AtaquePorcentualGetDanio() {
		Algoformer algof1 = new Megatron();
		int vida1, vida2;
		int danio = algof1.getAtaque();
		int porcentajeDescuento = 10;
		vida1 = algof1.getVida();
		AtaquePorcentual ataque = new AtaquePorcentual(porcentajeDescuento);
		ataque.ataqueEjecutar(algof1);
		vida2 = algof1.getVida();
		Assert.assertTrue(vida2 == (vida1*(100-porcentajeDescuento)/100));
		//(VALOR)==(VALOR*(100+PORCENTAJE)/100))

	}

}