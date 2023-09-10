package intraconsulta;

import static org.junit.Assert.*;
import org.junit.Test;
import enums.*;

public class TestCicloLectivo {

	@Test
	public void queSePuedaDeclararUnCicloLectivo() {
		Cuatrimestre cuatrimestre = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Turno turno = Turno.MAÑANA;
		
		CicloLectivo cicloLectivo = new CicloLectivo(cuatrimestre, turno);
		
		assertNotNull(cicloLectivo);
	}

}
