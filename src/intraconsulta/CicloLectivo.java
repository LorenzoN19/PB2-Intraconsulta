package intraconsulta;

import enums.Cuatrimestre;
import enums.Turno;

public class CicloLectivo {

	private Cuatrimestre cuatrimestre;
	private Turno turno;

	public CicloLectivo(Cuatrimestre cuatrimestre, Turno turno) {
		this.cuatrimestre = cuatrimestre;
		this.turno = turno;
	}

	public Cuatrimestre getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Cuatrimestre cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
