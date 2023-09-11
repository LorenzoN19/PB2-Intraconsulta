package intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSePuedaCrearUnAula() {
		Integer numero = 2355, capacidadTotal = 80;
		
		Aula aula = new Aula(numero, capacidadTotal);
		
		assertNotNull(aula);
	}

	@Test
	public void queDosAulasConMismoNumeroSeanConsideradasObjetosIguales() {
		Integer numero = 2355, capacidadTotal = 80;
		
		Aula aula = new Aula(numero, capacidadTotal);
		Aula aula2 = new Aula(numero, Integer.valueOf(50));
		
		assertEquals(aula, aula2);
	}
	
	

}
