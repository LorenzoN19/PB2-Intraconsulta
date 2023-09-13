package intraconsulta;

import java.util.Objects;

public class Comision {

	private Integer codigo;
	private Aula aula;
	private Materia materia;
	private CicloLectivo cicloLectivo;

	public Comision(Integer codigo, Aula aula, Materia materia, CicloLectivo cicloLectivo) {
		this.codigo = codigo;
		this.aula = aula;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
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
		return Objects.equals(codigo, other.codigo);
	}
	
}
