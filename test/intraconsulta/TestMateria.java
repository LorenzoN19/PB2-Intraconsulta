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

	@Test
	public void queDosMateriasConMismoNombreOMismoCodigoSeanConsideradasObjetosIguales() {
		String nombre = "pb2";
		Integer codigo = 2332;
		
		Materia materia = new Materia(nombre, codigo);
		Materia materiaConMismoNombre = new Materia(nombre, Integer.valueOf(3356));
		Materia materiaConMismoCodigo = new Materia("pb1", codigo);
		
		assertEquals(materia, materiaConMismoNombre);
		assertEquals(materia, materiaConMismoCodigo);
	}
}
