package intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedaCrearUnaMateria() {
		String nombre = "pb2";
		Integer codigo = 2233;
		Materia materia1 = new Materia(nombre, codigo);
		
		assertNotNull(materia1);
	}

}
