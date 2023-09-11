package intraconsulta;

import static org.junit.Assert.*;
import org.junit.Test;
import enums.*;

public class TestCicloLectivo {

	@Test
	public void queSePuedaDeclararUnCicloLectivo() {
		Turno turno = Turno.MAÑANA;
		Cuatrimestre cuatrimestre = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Integer año = 2023;
		
		CicloLectivo cicloLectivo = new CicloLectivo(turno, cuatrimestre, año);
		
		assertNotNull(cicloLectivo);
	}

}
