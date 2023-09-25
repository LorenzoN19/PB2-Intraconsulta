package intraconsulta;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void queSePuedaCrearUnCicloLectivo() {
		Integer id = 1;
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		
		CicloLectivo cicloLectivo = new CicloLectivo(id, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
			
		assertNotNull(cicloLectivo);
	}

	@Test
	public void queDosCiclosLectivosConMismoIdSeanConsideradosObjetosIguales() {
		Integer id = 1;
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		
		CicloLectivo cicloLectivo = new CicloLectivo(id, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		CicloLectivo cicloLectivo2 = new CicloLectivo(id, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
			
		assertEquals(cicloLectivo, cicloLectivo2);
	}
}
