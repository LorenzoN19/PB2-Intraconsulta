package intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Cuatrimestre;
import enums.Turno;

public class TestAsigComisionAlumno {

	@Test
	public void queSePuedaInscribirUnAlumnoAUnaComision() {
		Integer id = 3242;
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Integer codigoComision = 3454;
		Comision comision = new Comision(codigoComision, aula, materia, cicloLectivo);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499);
		
		AsigComisionAlumno cursada = new AsigComisionAlumno(id, comision, alumno);
		
		assertNotNull(cursada);
	}
	
	@Test
	public void queDosAsignacionesConMismoIdSeanConsideradasObjetosIguales() {
		Integer id = 3242;
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Integer codigoComision = 3454;
		Comision comision = new Comision(codigoComision, aula, materia, cicloLectivo);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499);
		
		AsigComisionAlumno asignacion = new AsigComisionAlumno(id, comision, alumno);
		AsigComisionAlumno asignacion2 = new AsigComisionAlumno(id, comision, alumno);
		
		assertEquals(asignacion, asignacion2);
	}

}
