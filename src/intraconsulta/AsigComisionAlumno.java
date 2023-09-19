package intraconsulta;

import java.util.Objects;

public class AsigComisionAlumno {

	private Integer id;
	private Comision comision;
	private Alumno alumno;
	private Nota[] parciales;
	private Integer notaFinal;
	

	public AsigComisionAlumno(Integer id, Comision comision, Alumno alumno) {
		this.id = id;
		this.comision = comision;
		this.alumno = alumno;
	}

	public Integer getCodigo() {
		return id;
	}

	public void setCodigo(Integer codigo) {
		this.id = codigo;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Integer getNota() {
		return nota;
	}

	public void asignarNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, comision, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsigComisionAlumno other = (AsigComisionAlumno) obj;
		return  Objects.equals(id, other.id) || (Objects.equals(alumno, other.alumno) && Objects.equals(comision, other.comision));
	}

	
	
}
