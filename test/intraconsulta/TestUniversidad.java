package intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnaMateria() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		
		unlam.registrarMateria(pb2);
		Materia materiaObtenida = unlam.getMaterias().get(0);
		
		assertEquals(pb2, materiaObtenida);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnaMateriaYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		Materia repetidaPorNombre = new Materia(nombre, Integer.valueOf(335));
		Materia repetidaPorCodigo = new Materia("bdd", codigo);
		
		boolean resultado = unlam.registrarMateria(pb2);
		assertTrue(resultado);
		
		resultado = unlam.registrarMateria(repetidaPorNombre);
		assertFalse(resultado);

		resultado = unlam.registrarMateria(repetidaPorCodigo);
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		unlam.registrarMateria(pb2);
		
		unlam.agregarMateriaCorrelativa(pb2, pb1);
		Materia correlativaObtenida = unlam.getMaterias().get(0).getCorrelativas().get(0);
		
		assertEquals(pb1, correlativaObtenida);
	}
	
	@Test
	public void queNoSePuedaAgregarUnaCorrelativaYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		unlam.registrarMateria(pb2);
		
		boolean resultado = unlam.agregarMateriaCorrelativa(pb2, pb1);
		assertTrue(resultado);
		
		resultado = unlam.agregarMateriaCorrelativa(pb2, pb1);
		assertFalse(resultado);
	}

}
