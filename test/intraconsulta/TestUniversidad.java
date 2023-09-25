package intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import enums.*;

public class TestUniversidad {
	
// MATERIA //
	
	@Test
	public void queSePuedaRegistrarUnaMateria() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		
		unlam.agregarMateria(pb2);
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
		unlam.agregarMateria(pb2);
		
		boolean resultado = unlam.agregarMateria(repetidaPorNombre);
		assertFalse(resultado);

		resultado = unlam.agregarMateria(repetidaPorCodigo);
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Universidad unlam = new Universidad();
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		Materia pb2 = new Materia("pb2", Integer.valueOf(2331));
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		
		unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		Materia materiaObtenida = unlam.traerMateria(pb2.getId());
		Materia correlativaObtenida = materiaObtenida.getCorrelativas().get(0);
		
		assertEquals(pb1, correlativaObtenida);
	}
	
	@Test
	public void queNoSePuedaAgregarUnaCorrelativaYaExistente() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", Integer.valueOf(2331));
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb1);
		
		boolean resultado = unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		assertTrue(resultado);
		
		resultado = unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativa() {
		Universidad unlam = new Universidad();
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		Materia pb2 = new Materia("pb2", Integer.valueOf(2331));
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		
		unlam.eliminarCorrelativad(pb2.getId(), pb1.getId());
		
		assertEquals(0, pb2.getCorrelativas().size());
	}
	
// ALUMNO // 
	
	@Test
	public void queSePuedaRegistrarUnAlumno() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Alumno alumno = new Alumno(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		
		unlam.agregarAlumno(alumno);
		Alumno alumnoObtenido = unlam.getAlumnos().get(0);
		
		assertEquals(alumno, alumnoObtenido);	
	}
	
	@Test
	public void queNoSePuedanRegistrarDosAlumnosConUnMismoDNI() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		Alumno alumno2 = new Alumno("Juan", "Perez", dni, fechaDeNacimiento, fechaDeIngreso);
		
		boolean resultado = unlam.agregarAlumno(alumno1);
		assertTrue(resultado);
		
		resultado = unlam.agregarAlumno(alumno2);
		assertFalse(resultado);
	}
	
// PROFESOR // 
	
	@Test
	public void queSePuedaRegistrarUnProfesor() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Profesor profesor = new Profesor(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		
		unlam.agregarProfesor(profesor);
		Profesor profesorObtenido = unlam.getProfesores().get(0);
		
		assertEquals(profesor, profesorObtenido);	
	}
	
	@Test
	public void queNoSePuedanRegistrarDosProfesoresConUnMismoDNI() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Profesor profesor = new Profesor(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		Profesor profesor2 = new Profesor("Juan", "Perez", dni, fechaDeNacimiento, fechaDeIngreso);
		
		boolean resultado = unlam.agregarProfesor(profesor);
		assertTrue(resultado);
		
		resultado = unlam.agregarProfesor(profesor2);
		assertFalse(resultado);
	}
	
// AULA // 
	
	@Test
	public void queSePuedaRegistrarUnAula() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		
		unlam.agregarAula(aula);
		Aula aulaObtenida = unlam.getAulas().get(0);
		
		assertEquals(aula, aulaObtenida);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAulaYaExistente() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		Aula aula2 = new Aula(numero, Integer.valueOf(50));
		unlam.agregarAula(aula);

		boolean resultado = unlam.agregarAula(aula2);
		
		assertFalse(resultado);	
	}
	
// CICLO LECTIVO //
	
	@Test
	public void queSePuedaRegistrarUnCicloLectivo() {
		Universidad unlam = new Universidad();
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		
		unlam.agregarCicloLectivo(cicloLectivo);
		
		assertEquals(cicloLectivo, unlam.getCiclosLectivos().get(0));
	}
	
	@Test
	public void queNoSePuedanRegistrarDosCiclosLectivosConMismoId() {
		Universidad unlam = new Universidad();
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		CicloLectivo cicloLectivo2 = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		
		boolean resultado = unlam.agregarCicloLectivo(cicloLectivo2);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queNoSePuedanRegistrarDosCiclosLectivosSuperpuestos() {
		Universidad unlam = new Universidad();
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		LocalDate fechaSuperpuesta = LocalDate.of(2023, 5, 10);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		CicloLectivo cicloLectivo2 = new CicloLectivo(10, fechaSuperpuesta, fechaSuperpuesta, fechaSuperpuesta, fechaSuperpuesta);
		unlam.agregarCicloLectivo(cicloLectivo);
		
		boolean resultado = unlam.agregarCicloLectivo(cicloLectivo2);
		
		assertFalse(resultado);
	}
	
	
// COMISION //
	
	@Test
	public void queSePuedaRegistrarUnaComision() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		Comision comision = new Comision(3454, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
				
		unlam.agregarComision(comision);
		
		assertEquals(comision, unlam.getComisiones().get(0));
	}
	
	@Test
	public void queNoPuedaRegistrarUnaComisionYaExistente() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		Integer codigo = 3454;
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		Comision comision2 = new Comision(codigo, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
				
		boolean resultado = unlam.agregarComision(comision2);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queNoSePuedanRegistrarDosComisionesDeUnaMismaMateriaEnUnMismoTurnoYCicloLectivo() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		Comision comision = new Comision(3454, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		Comision comision2 = new Comision(1223, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		
		
		boolean resultado = unlam.agregarComision(comision2);
		
		assertFalse(resultado);
	}
	
// COMISION-ALUMNO //
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnaComisionQueNoRequieraCorrelativas() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		assertEquals(0, unlam.getAsignacionesAlumno().size());

		unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		
		assertEquals(1, unlam.getAsignacionesAlumno().size());
	}

	@Test
	public void queUnAlumnoNoSePuedaInscribirDosVecesAUnaMismaComision() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
					
		unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		boolean resultado = unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queSeLePuedaAsignarLaNotaAUnAlumnoEnUnaComision() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb2);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comision = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		
		Nota nota = new Nota(TipoDeNota.PRIMER_PARCIAL, 7);
		Nota nota2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 7);
		unlam.registrarNota(comision.getId(), alumno.getDni(), nota);
		unlam.registrarNota(comision.getId(), alumno.getDni(), nota2);
		AsigComisionAlumno asignacion = unlam.buscarAsignacionAlumno(comision.getId(), alumno.getDni());
		
		assertEquals(Integer.valueOf(7), asignacion.getNotaFinal().getValor());
	}
	
	@Test
	public void queNoSeLePuedaAsignarLaNotaFinalAUnAlumnoEnUnaComisionSiNoAproboAmbosParciales() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb2);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comision = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		unlam.agregarComision(comision);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		Nota nota = new Nota(TipoDeNota.PRIMER_PARCIAL, 3);
		Nota nota2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 10);
		Nota notaFinal = new Nota(TipoDeNota.NOTA_FINAL, 8);
		unlam.registrarNota(comision.getId(), alumno.getDni(), nota);
		unlam.registrarNota(comision.getId(), alumno.getDni(), nota2);
				
		boolean resultado = unlam.registrarNota(comision.getId(), alumno.getDni(), notaFinal);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queUnAlumnoNoPuedaRendirDosRecuperatorios() {
		Universidad unlam = new Universidad();
		Materia pb = new Materia("pb", 2100);
		unlam.agregarMateria(pb);
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb2);
		unlam.agregarCorrelatividad(pb2.getId(), pb.getId());
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comisionPb = new Comision(4553, aula, pb, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comisionPb);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionPb.getId(), fechaInscripcion);
		Nota parcial1 = new Nota(TipoDeNota.PRIMER_PARCIAL, 5);
		Nota parcial2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 5);
		Nota recup1 = new Nota(TipoDeNota.REC_PRIMERO, 9);		
		Nota recup2 = new Nota(TipoDeNota.REC_SEGUNDO, 9);
		unlam.registrarNota(comisionPb.getId(), alumno.getDni(), parcial1);
		unlam.registrarNota(comisionPb.getId(), alumno.getDni(), parcial2);
		
		boolean resultado = unlam.registrarNota(comisionPb.getId(), alumno.getDni(), recup1);
		assertTrue(resultado);
		resultado = unlam.registrarNota(comisionPb.getId(), alumno.getDni(), recup2);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnaComisionSiAproboLasCorrelativas() {
		Universidad unlam = new Universidad();
		Materia pb = new Materia("pb", 2100);
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb);
		unlam.agregarMateria(pb2);
		unlam.agregarCorrelatividad(pb2.getId(), pb.getId());
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comisionPb = new Comision(4553, aula, pb, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		Comision comisionPb2 = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.JUEVES);
		unlam.agregarComision(comisionPb);
		unlam.agregarComision(comisionPb2);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionPb.getId(), fechaInscripcion);
		Nota parcial1 = new Nota(TipoDeNota.PRIMER_PARCIAL, 10);
		Nota parcial2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 10);
		unlam.registrarNota(comisionPb.getId(), alumno.getDni(), parcial1);
		unlam.registrarNota(comisionPb.getId(), alumno.getDni(), parcial2);
				
		boolean resultado = unlam.inscribirAlumnoAComision(alumno.getDni(), comisionPb2.getId(), fechaInscripcion);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queNoSePuedaInscribirUnAlumnoAUnaComisionSiNoAproboLasCorrelativas() {
		Universidad unlam = new Universidad();
		Materia pb = new Materia("pb", 2100);
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb);
		unlam.agregarMateria(pb2);
		unlam.agregarCorrelatividad(pb2.getId(), pb.getId());
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comision = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);		
		
		boolean resultado = unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaObtenerLaNotaFinalDeUnAlumnoEnUnaComision() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb2);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comision = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comision.getId(), fechaInscripcion);
		Nota nota = new Nota(TipoDeNota.PRIMER_PARCIAL, 7);
		Nota nota2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 7);
		unlam.registrarNota(comision.getId(), alumno.getDni(), nota);
		unlam.registrarNota(comision.getId(), alumno.getDni(), nota2);
		
		Integer notaFinal = unlam.obtenerNota(alumno.getDni(), pb2.getId());
		
		assertEquals(Integer.valueOf(7), notaFinal);
	}
	
	@Test
	public void queSePuedaObtenerElArregloDeMateriasAprobadasPorUnAlumno() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("Programacion Basica 2", 2300);
		unlam.agregarMateria(pb2);
		Materia ingles = new Materia("Ingles Tecnico", 4410);
		unlam.agregarMateria(ingles);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comisionPb2 = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comisionPb2);
		Comision comisionIng = new Comision(1331, aula, ingles, cicloLectivo, Turno.MAÑANA, DiaDeCursada.SABADO);
		unlam.agregarComision(comisionIng);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionPb2.getId(), fechaInscripcion);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionIng.getId(), fechaInscripcion);
		Nota nota = new Nota(TipoDeNota.PRIMER_PARCIAL, 7);
		Nota nota2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 7);
		unlam.registrarNota(comisionPb2.getId(), alumno.getDni(), nota);
		unlam.registrarNota(comisionPb2.getId(), alumno.getDni(), nota2);
		unlam.registrarNota(comisionIng.getId(), alumno.getDni(), nota);
		unlam.registrarNota(comisionIng.getId(), alumno.getDni(), nota2);
		
		ArrayList<Materia> materiasAprobadas = unlam.obtenerMateriasAprobadas(alumno.getDni());
		Integer valorEsperado = 2;
		
		assertEquals(valorEsperado, Integer.valueOf(materiasAprobadas.size()));
	}

	@Test
	public void queSePuedaObtenerElPromedioDeUnAlumno() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("Programacion Basica 2", 2300);
		unlam.agregarMateria(pb2);
		Materia ingles = new Materia("Ingles Tecnico", 4410);
		unlam.agregarMateria(ingles);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comisionPb2 = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comisionPb2);
		Comision comisionIng = new Comision(1331, aula, ingles, cicloLectivo, Turno.MAÑANA, DiaDeCursada.SABADO);
		unlam.agregarComision(comisionIng);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionPb2.getId(), fechaInscripcion);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionIng.getId(), fechaInscripcion);
		Nota nota1Pb2 = new Nota(TipoDeNota.PRIMER_PARCIAL, 7);
		Nota nota2Pb2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 8);
		Nota nota1Ing = new Nota(TipoDeNota.PRIMER_PARCIAL, 5);
		Nota nota2Ing = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 7);
		Nota nota3Ing = new Nota(TipoDeNota.NOTA_FINAL, 4);
		unlam.registrarNota(comisionPb2.getId(), alumno.getDni(), nota1Pb2);
		unlam.registrarNota(comisionPb2.getId(), alumno.getDni(), nota2Pb2);
		unlam.registrarNota(comisionIng.getId(), alumno.getDni(), nota1Ing);
		unlam.registrarNota(comisionIng.getId(), alumno.getDni(), nota2Ing);
		unlam.registrarNota(comisionIng.getId(), alumno.getDni(), nota3Ing);
		
		Integer notaFinalPb2 = unlam.obtenerNota(alumno.getDni(), pb2.getId());
		Integer notaFinalIng = unlam.obtenerNota(alumno.getDni(), ingles.getId());
		Double valorEsperado = (notaFinalPb2 + notaFinalIng) / 2.0;
		
		Double promedio = unlam.calcularPromedio(alumno.getDni());
		assertEquals(valorEsperado, promedio);
	}

	@Test
	public void queSePuedaObtenerElArregloDeMateriasQueFaltanCursarParaUnAlumno() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		unlam.agregarMateria(pb2);
		Materia informatica = new Materia("Informatica General", 4410);
		unlam.agregarMateria(informatica);
		Materia web = new Materia("Programacion Web 1", 2615);
		unlam.agregarMateria(web);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno);
		Comision comisionPb2 = new Comision(2233, aula, pb2, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comisionPb2);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 7);
		unlam.inscribirAlumnoAComision(alumno.getDni(), comisionPb2.getId(), fechaInscripcion);
		Nota nota = new Nota(TipoDeNota.PRIMER_PARCIAL, 7);
		Nota nota2 = new Nota(TipoDeNota.SEGUNDO_PARCIAL, 7);
		unlam.registrarNota(comisionPb2.getId(), alumno.getDni(), nota);
		unlam.registrarNota(comisionPb2.getId(), alumno.getDni(), nota2);
		
		ArrayList<Materia> materiasNoCursadas = unlam.obtenerMateriasNoCursadas(alumno.getDni());
		Integer valorEsperado = 2;
		
		assertEquals(valorEsperado, Integer.valueOf(materiasNoCursadas.size()));
	}

	// COMISION-PROFESOR //
	
	@Test
	public void queSePuedaAsignarUnProfesorAUnaComisionConAlMenosUnInscripto() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("Programacion Basica 2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Profesor profesor = new Profesor("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarProfesor(profesor);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		Alumno alumno1 = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno1);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 10);
		unlam.inscribirAlumnoAComision(alumno1.getDni(), comision.getId(), fechaInscripcion);

		boolean resultado = unlam.asignarProfesorAComision(profesor.getDni(), comision.getId());
		
		assertTrue(resultado);
	}
	
	@Test
	public void queNoSePuedaAsignarUnProfesorAUnaComisionSinInscriptos() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("Programacion Basica 2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Profesor profesor = new Profesor("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarProfesor(profesor);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		
		boolean resultado = unlam.asignarProfesorAComision(profesor.getDni(), comision.getId());
		
		assertFalse(resultado);
	}
	
	@Test
	public void queCadaVeinteInscriptosSePuedaAsignarOtroProfesor() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("Programacion Basica 2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Profesor profesor1 = new Profesor("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarProfesor(profesor1);
		Profesor profesor2 = new Profesor("Lorenzo", "Noceda", 2323242, fechaNac, fechaIng);
		unlam.agregarProfesor(profesor2);		
		Comision comision = new Comision(2233, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		Alumno alumno1 = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno1);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 10);
		unlam.inscribirAlumnoAComision(alumno1.getDni(), comision.getId(), fechaInscripcion);
		
		boolean resultado = unlam.asignarProfesorAComision(profesor1.getDni(), comision.getId());
		assertTrue(resultado);
		
		resultado = unlam.asignarProfesorAComision(profesor2.getDni(), comision.getId());
		assertFalse(resultado);
		
		Alumno alumno2 = new Alumno("Lorenzo", "Noceda", 12, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno2);
		unlam.inscribirAlumnoAComision(alumno2.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno3 = new Alumno("Lorenzo", "Noceda", 424, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno3);
		unlam.inscribirAlumnoAComision(alumno3.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno4 = new Alumno("Lorenzo", "Noceda", 4545, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno4);
		unlam.inscribirAlumnoAComision(alumno4.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno5 = new Alumno("Lorenzo", "Noceda", 7567, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno5);
		unlam.inscribirAlumnoAComision(alumno5.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno6 = new Alumno("Lorenzo", "Noceda", 8678, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno6);
		unlam.inscribirAlumnoAComision(alumno6.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno7 = new Alumno("Lorenzo", "Noceda", 989, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno7);
		unlam.inscribirAlumnoAComision(alumno7.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno8 = new Alumno("Lorenzo", "Noceda", 32, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno8);
		unlam.inscribirAlumnoAComision(alumno8.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno9 = new Alumno("Lorenzo", "Noceda", 345, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno9);
		unlam.inscribirAlumnoAComision(alumno9.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno10 = new Alumno("Lorenzo", "Noceda", 787, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno10);
		unlam.inscribirAlumnoAComision(alumno10.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno11 = new Alumno("Lorenzo", "Noceda", 434354, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno11);
		unlam.inscribirAlumnoAComision(alumno11.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno12 = new Alumno("Lorenzo", "Noceda", 65654654, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno12);
		unlam.inscribirAlumnoAComision(alumno12.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno13 = new Alumno("Lorenzo", "Noceda", 4564632, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno13);
		unlam.inscribirAlumnoAComision(alumno13.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno14 = new Alumno("Lorenzo", "Noceda", 12132, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno14);
		unlam.inscribirAlumnoAComision(alumno14.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno15 = new Alumno("Lorenzo", "Noceda", 2353, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno15);
		unlam.inscribirAlumnoAComision(alumno15.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno16 = new Alumno("Lorenzo", "Noceda", 45634, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno16);
		unlam.inscribirAlumnoAComision(alumno16.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno17 = new Alumno("Lorenzo", "Noceda", 56857, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno17);
		unlam.inscribirAlumnoAComision(alumno17.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno18 = new Alumno("Lorenzo", "Noceda", 689876, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno18);
		unlam.inscribirAlumnoAComision(alumno18.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno19 = new Alumno("Lorenzo", "Noceda", 78978, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno19);
		unlam.inscribirAlumnoAComision(alumno19.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno20 = new Alumno("Lorenzo", "Noceda", 5676, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno20);
		unlam.inscribirAlumnoAComision(alumno20.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno21 = new Alumno("Lorenzo", "Noceda", 32423, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno21);
		unlam.inscribirAlumnoAComision(alumno21.getDni(), comision.getId(), fechaInscripcion);

		resultado = unlam.asignarProfesorAComision(profesor2.getDni(), comision.getId());
		
		assertTrue(resultado);
	}
	
	@Test
	public void queNoSePuedaAgregarDosVecesElMismoProfesor() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("Programacion Basica 2", 2300);
		unlam.agregarMateria(materia);
		Aula aula = new Aula(15, 90);
		unlam.agregarAula(aula);
		LocalDate inicioInscripcion = LocalDate.of(2023, 3, 3);
		LocalDate finInscripcion = LocalDate.of(2023, 3, 13);
		LocalDate inicioCicloLec = LocalDate.of(2023, 3, 27);
		LocalDate finCicloLec = LocalDate.of(2023, 7, 27);
		CicloLectivo cicloLectivo = new CicloLectivo(1, inicioInscripcion, finInscripcion, inicioCicloLec, finCicloLec);
		unlam.agregarCicloLectivo(cicloLectivo);
		LocalDate fechaNac = LocalDate.of(2001, 11, 19);
		LocalDate fechaIng = LocalDate.of(2023, 3, 7);
		Profesor profesor1 = new Profesor("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarProfesor(profesor1);
		Profesor profesor2 = new Profesor("Lorenzo", "Noceda", 2323242, fechaNac, fechaIng);
		unlam.agregarProfesor(profesor2);		
		Comision comision = new Comision(2233, aula, materia, cicloLectivo, Turno.MAÑANA, DiaDeCursada.MARTES);
		unlam.agregarComision(comision);
		Alumno alumno1 = new Alumno("Lorenzo", "Noceda", 43469499, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno1);
		LocalDate fechaInscripcion = LocalDate.of(2023, 3, 10);
		unlam.inscribirAlumnoAComision(alumno1.getDni(), comision.getId(), fechaInscripcion);
		
		boolean resultado = unlam.asignarProfesorAComision(profesor1.getDni(), comision.getId());
		assertTrue(resultado);
		
		resultado = unlam.asignarProfesorAComision(profesor2.getDni(), comision.getId());
		assertFalse(resultado);
		
		Alumno alumno2 = new Alumno("Lorenzo", "Noceda", 12, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno2);
		unlam.inscribirAlumnoAComision(alumno2.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno3 = new Alumno("Lorenzo", "Noceda", 424, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno3);
		unlam.inscribirAlumnoAComision(alumno3.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno4 = new Alumno("Lorenzo", "Noceda", 4545, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno4);
		unlam.inscribirAlumnoAComision(alumno4.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno5 = new Alumno("Lorenzo", "Noceda", 7567, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno5);
		unlam.inscribirAlumnoAComision(alumno5.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno6 = new Alumno("Lorenzo", "Noceda", 8678, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno6);
		unlam.inscribirAlumnoAComision(alumno6.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno7 = new Alumno("Lorenzo", "Noceda", 989, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno7);
		unlam.inscribirAlumnoAComision(alumno7.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno8 = new Alumno("Lorenzo", "Noceda", 32, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno8);
		unlam.inscribirAlumnoAComision(alumno8.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno9 = new Alumno("Lorenzo", "Noceda", 345, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno9);
		unlam.inscribirAlumnoAComision(alumno9.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno10 = new Alumno("Lorenzo", "Noceda", 787, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno10);
		unlam.inscribirAlumnoAComision(alumno10.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno11 = new Alumno("Lorenzo", "Noceda", 434354, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno11);
		unlam.inscribirAlumnoAComision(alumno11.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno12 = new Alumno("Lorenzo", "Noceda", 65654654, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno12);
		unlam.inscribirAlumnoAComision(alumno12.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno13 = new Alumno("Lorenzo", "Noceda", 4564632, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno13);
		unlam.inscribirAlumnoAComision(alumno13.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno14 = new Alumno("Lorenzo", "Noceda", 12132, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno14);
		unlam.inscribirAlumnoAComision(alumno14.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno15 = new Alumno("Lorenzo", "Noceda", 2353, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno15);
		unlam.inscribirAlumnoAComision(alumno15.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno16 = new Alumno("Lorenzo", "Noceda", 45634, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno16);
		unlam.inscribirAlumnoAComision(alumno16.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno17 = new Alumno("Lorenzo", "Noceda", 56857, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno17);
		unlam.inscribirAlumnoAComision(alumno17.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno18 = new Alumno("Lorenzo", "Noceda", 689876, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno18);
		unlam.inscribirAlumnoAComision(alumno18.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno19 = new Alumno("Lorenzo", "Noceda", 78978, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno19);
		unlam.inscribirAlumnoAComision(alumno19.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno20 = new Alumno("Lorenzo", "Noceda", 5676, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno20);
		unlam.inscribirAlumnoAComision(alumno20.getDni(), comision.getId(), fechaInscripcion);
		Alumno alumno21 = new Alumno("Lorenzo", "Noceda", 32423, fechaNac, fechaIng);
		unlam.agregarAlumno(alumno21);
		unlam.inscribirAlumnoAComision(alumno21.getDni(), comision.getId(), fechaInscripcion);
		
		resultado = unlam.asignarProfesorAComision(profesor1.getDni(), comision.getId());
		
		assertFalse(resultado);
	}
	
}
