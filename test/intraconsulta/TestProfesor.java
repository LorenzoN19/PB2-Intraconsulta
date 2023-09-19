package intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void queSePuedaCrearUnProfesor() {
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		
		Profesor profesor = new Profesor(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		
		assertNotNull(profesor);
	}
	
	@Test
	public void queDosProfesoresConMismoDNISeanConsideradosObjetosIguales() {
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		
		Profesor profesor = new Profesor(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		Profesor profesorConMismoDni = new Profesor("Juan", "Perez", dni, fechaDeNacimiento, fechaDeIngreso);
		
		assertEquals(profesor, profesorConMismoDni);
	}

}
