package intraconsulta;

import static org.junit.Assert.*;
import org.junit.Test;

import enums.TipoDeNota;

public class TestNota {

	@Test
	public void queSePuedaCrearUnaNota() {
		Integer valor = 8;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		
		Nota nota = new Nota(tipo, valor);
		
		assertNotNull(nota);
	}
	
	@Test
	public void queElValorDeUnaNotaNoPuedaSerMenorQueUnoNiMayorQueDiez() {
		Integer valor=12, valor2=-1, valorPorDefault=0;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;

		Nota nota = new Nota(tipo, valor);
		Nota nota2 = new Nota(tipo, valor2);
		
		assertEquals(valorPorDefault, nota.getValor());
		assertEquals(valorPorDefault, nota2.getValor());
	}
}
