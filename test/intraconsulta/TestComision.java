package intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import enums.*;

public class TestComision {

	@Test
	public void queSePuedaCrearUnaComision() {
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		Integer codigo = 3454;
		
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		
		assertNotNull(comision);
	}

	@Test
	public void queDosComisionesConMismoCodigoSeanConsideradasObjetosIguales() {
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		Integer codigo = 3454;
		
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		Comision comision2 = new Comision(codigo, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		
		assertEquals(comision2, comision);
	}

	@Test
	public void queDosComisionesDeUnaMismaMateriaEnUnMismoTurnoYCicloLectivoSeanConsideradasObjetosIguales() {
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		
		Comision comision = new Comision(3454, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		Comision comision2 = new Comision(1223, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		
		assertEquals(comision2, comision);
	}

}
