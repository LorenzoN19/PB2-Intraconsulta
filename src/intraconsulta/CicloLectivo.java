package intraconsulta;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	private Integer id;
	private LocalDate inicioInscripcion;
	private LocalDate finInscripcion;
	private LocalDate inicioCicloLec;
	private LocalDate finCicloLec;

	public CicloLectivo(Integer id, LocalDate inicioInscripcion, LocalDate finInscripcion, LocalDate inicioCicloLec,
			LocalDate finCicloLec) {
		this.id = id;
		this.inicioInscripcion = inicioInscripcion;
		this.finInscripcion = finInscripcion;
		this.inicioCicloLec = inicioCicloLec;
		this.finCicloLec = finCicloLec;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getInicioInscripcion() {
		return inicioInscripcion;
	}

	public void setInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.inicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFinInscripcion() {
		return finInscripcion;
	}

	public void setFinInscripcion(LocalDate fechaFinInscripcion) {
		this.finInscripcion = fechaFinInscripcion;
	}

	public LocalDate getInicioCicloLec() {
		return inicioCicloLec;
	}

	public void setInicioCicloLec(LocalDate fechaInicioCicLec) {
		this.inicioCicloLec = fechaInicioCicLec;
	}

	public LocalDate getFinCicloLec() {
		return finCicloLec;
	}

	public void setFinCicloLec(LocalDate fechaFinCicLec) {
		this.finCicloLec = fechaFinCicLec;
	}

	@Override
	public int hashCode() {
		return Objects.hash(finCicloLec, finInscripcion, id, inicioCicloLec, inicioInscripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CicloLectivo other = (CicloLectivo) obj;
		return Objects.equals(id, other.id) || Objects.equals(finCicloLec, other.finCicloLec)
				|| Objects.equals(finInscripcion, other.finInscripcion)
				|| Objects.equals(inicioCicloLec, other.inicioCicloLec)
				|| Objects.equals(inicioInscripcion, other.inicioInscripcion);
	}

}
