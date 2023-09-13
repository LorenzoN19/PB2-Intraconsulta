package intraconsulta;

import static org.junit.Assert.*;
import org.junit.Test;
import enums.*;

public class TestComision {

	@Test
	public void queSePuedaCrearUnaComision() {
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Integer codigo = 3454;
		
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo);
		
		assertNotNull(comision);
	}

	@Test
	public void queDosComisionesConMismoCodigoSeanConsideradasObjetosIguales() {
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Integer codigo = 3454;
		
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo);
		Comision comision2 = new Comision(codigo, aula, materia, cicloLectivo);
		
		assertEquals(comision2, comision);
	}

}
