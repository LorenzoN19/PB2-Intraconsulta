package intraconsulta;

import java.util.Objects;

import enums.DiaDeCursada;
import enums.Turno;

public class Comision {

	private Integer id;
	private Aula aula;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Turno turno;
	private DiaDeCursada dia;

	public Comision(Integer id, Aula aula, Materia materia, CicloLectivo cicloLectivo, Turno turno, DiaDeCursada dia) {
		this.id = id;
		this.aula = aula;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.turno = turno;
		this.dia = dia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public DiaDeCursada getDia() {
		return dia;
	}

	public void setDia(DiaDeCursada dia) {
		this.dia = dia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cicloLectivo, id, materia, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(id, other.id) || (Objects.equals(cicloLectivo, other.cicloLectivo)
				&& Objects.equals(materia, other.materia) && turno == other.turno);
	}

	
	
}
