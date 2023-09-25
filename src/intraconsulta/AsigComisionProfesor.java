package intraconsulta;

import java.util.Objects;

public class AsigComisionProfesor {

	private Integer id;
	private Comision comision;
	private Profesor profesor;

	public AsigComisionProfesor(Integer id, Comision comision, Profesor profesor) {
		this.id = id;
		this.comision = comision;
		this.profesor = profesor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comision, id, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsigComisionProfesor other = (AsigComisionProfesor) obj;
		return Objects.equals(id, other.id) || (Objects.equals(comision, other.comision) 
				&& Objects.equals(profesor, other.profesor));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

}
