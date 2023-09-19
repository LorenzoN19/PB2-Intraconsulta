package intraconsulta;

import enums.Cuatrimestre;
import enums.Turno;

public class CicloLectivo {

	private Turno turno;
	private Cuatrimestre cuatrimestre;
	private Integer año;

	public CicloLectivo(Turno turno, Cuatrimestre cuatrimestre, Integer año) {
		this.turno = turno;	
		this.cuatrimestre = cuatrimestre;
		this.año = año;
	}

	public Turno getTurno() {
		return turno;
	}
	
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Cuatrimestre getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Cuatrimestre cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

}
