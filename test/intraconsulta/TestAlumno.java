package intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSePuedaCrearUnAlumno() {
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		
		Alumno alumno = new Alumno(nombre, apellido, dni);
		
		assertNotNull(alumno);
	}
	
	@Test
	public void queDosAlumnosConMismoDNISeanConsideradosObjetosIguales() {
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		
		Alumno alumno = new Alumno(nombre, apellido, dni);
		Alumno alumnoConMismoDni = new Alumno("Juan", "Perez", dni);
		
		assertEquals(alumno, alumnoConMismoDni);
	}

}
