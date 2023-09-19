package intraconsulta;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestNota {

	@Test
	public void queSePuedaCrearUnaNota() {
		Integer valor = 8;
		
		Nota nota = new Nota(valor);
		
		assertNotNull(nota);
	}
	
	@Test
	public void queElValorDeUnaNotaNoPuedaSerMenorQueUnoNiMayorQueDiez() {
		Integer valor=12, valor2=-1, valorPorDefault=0;
		
		Nota nota = new Nota(valor);
		Nota nota2 = new Nota(valor2);
		
		assertEquals(valorPorDefault, nota.getValor());
		assertEquals(valorPorDefault, nota2.getValor());
	}
}
