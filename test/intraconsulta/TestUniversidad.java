package intraconsulta;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUniversidad {
	
	// MATERIA //
	
	
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
		unlam.registrarMateria(pb2);
		
		boolean resultado = unlam.registrarMateria(repetidaPorNombre);
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
	
	
	// ALUMNO // 
	
	
	@Test
	public void queSePuedaRegistrarUnAlumno() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		Alumno alumno = new Alumno(nombre, apellido, dni);
		
		unlam.registrarAlumno(alumno);
		Alumno alumnoObtenido = unlam.getAlumnos().get(0);
		
		assertEquals(alumno, alumnoObtenido);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAlumnoYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		Alumno alumno1 = new Alumno(nombre, apellido, dni);
		Alumno alumno2 = new Alumno("Juan", "Perez", dni);
		
		boolean resultado = unlam.registrarAlumno(alumno1);
		assertTrue(resultado);
		
		resultado = unlam.registrarAlumno(alumno2);
		assertFalse(resultado);
	}
	
	
	// AULA // 
	
	@Test
	public void queSePuedaRegistrarUnAula() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		
		unlam.registrarAula(aula);
		Aula aulaObtenida = unlam.getAulas().get(0);
		
		assertEquals(aula, aulaObtenida);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAulaYaExistente() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		Aula aula2 = new Aula(numero, Integer.valueOf(50));
		unlam.registrarAula(aula);

		boolean resultado = unlam.registrarAula(aula2);
		
		assertFalse(resultado);	
	}
	
	
}
