package intraconsulta;

import java.util.Objects;

import enums.TipoDeNota;

public class AsigComisionAlumno {

	private Integer id;
	private Comision comision;
	private Alumno alumno;
	private Nota primerParcial;
	private Nota segundoParcial;
	private Nota recupPrimero;
	private Nota recupSegundo;
	private Nota notaFinal;
	private boolean pendienteDeFinal;
	private Integer llamadosRestantesAFinal;

	public AsigComisionAlumno(Integer id, Comision comision, Alumno alumno) {
		this.id = id;
		this.comision = comision;
		this.alumno = alumno;
		primerParcial = new Nota(TipoDeNota.PRIMER_PARCIAL);
		segundoParcial = new Nota(TipoDeNota.SEGUNDO_PARCIAL);
		recupPrimero = new Nota(TipoDeNota.REC_PRIMERO);
		recupSegundo = new Nota(TipoDeNota.REC_SEGUNDO);
		notaFinal = new Nota(TipoDeNota.NOTA_FINAL);
		pendienteDeFinal = false;
		llamadosRestantesAFinal = 3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer codigo) {
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

	public Nota getPrimerParcial() {
		return primerParcial;
	}

	public boolean calificarPrimerParcial(Integer nota) {
		return primerParcial.setValor(nota);
	}

	public Nota getSegundoParcial() {
		return segundoParcial;
	}

	public boolean calificarSegundoParcial(Integer nota) {
		if (primerParcial.getValor() == 0) {
			return false;
		}
		boolean puedeAsignarse = segundoParcial.setValor(nota);
		if (!puedeAsignarse) {
			return false;
		}
		boolean promociona = primerParcial.getValor() >= 7 && nota >= 7;
		boolean vaAFinal = primerParcial.getValor() >= 4 && nota >= 4;
		if (promociona) {
			Integer valor = (getPrimerParcial().getValor() + nota) / 2;
			notaFinal.setValor(valor);
		} else if (vaAFinal) {
			setPendienteDeFinal(true);
		}
		return true;
	}

	public Nota getRecupPrimero() {
		return recupPrimero;
	}

	public boolean calificarRecupPrimero(Integer nota) {
		if (primerParcial.getValor() == 0 || primerParcial.getValor() >= 7) {
			return false;
		}
		if (segundoParcial.getValor() == 0 || recupSegundo.getValor() > 0) {
			return false;
		}
		boolean puedeAsignarse = recupPrimero.setValor(nota);
		if (!puedeAsignarse) {
			return false;
		}
		boolean promociona = segundoParcial.getValor() >= 7 && nota >= 7;
		boolean vaAFinal = segundoParcial.getValor() >= 4 && nota >= 4;
		if (promociona) {
			Integer valor = (segundoParcial.getValor() + nota) / 2;
			notaFinal.setValor(valor);
		} else if (vaAFinal) {
			setPendienteDeFinal(true);
		}
		return true;
	}

	public Nota getRecupSegundo() {
		return recupSegundo;
	}

	public boolean calificarRecupSegundo(Integer nota) {
		if (segundoParcial.getValor() == 0 || segundoParcial.getValor() >= 7) {
			return false;
		}
		if (primerParcial.getValor() == 0 || recupPrimero.getValor() > 0) {
			return false;
		}
		boolean puedeAsignarse = recupSegundo.setValor(nota);
		if (!puedeAsignarse) {
			return false;
		}
		boolean promociona = primerParcial.getValor() >= 7 && nota >= 7;
		boolean vaAFinal = primerParcial.getValor() >= 4 && nota >= 4;
		if (promociona) {
			Integer valor = (primerParcial.getValor() + nota) / 2;
			notaFinal.setValor(valor);
		} else if (vaAFinal) {
			setPendienteDeFinal(true);
		}
		return true;
	}

	public Nota getNotaFinal() {
		return notaFinal;
	}

	public boolean calificarNotaFinal(Integer nota) {
		if (!pendienteDeFinal || llamadosRestantesAFinal==0) {
			return false;
		}
		boolean puedeAsignarse = notaFinal.setValor(nota);
		if(!puedeAsignarse) {
			return false;
		} 
		boolean aprobado = nota >= 4;
		if(aprobado) {
			setPendienteDeFinal(false);			
		} else {
			setLlamadosRestantesAFinal(getLlamadosRestantesAFinal()-1); ;
		}
		return true;
	}

	public boolean isPendienteDeFinal() {
		return pendienteDeFinal;
	}

	public void setPendienteDeFinal(boolean pendienteDeFinal) {
		this.pendienteDeFinal = pendienteDeFinal;
	}

	public Integer getLlamadosRestantesAFinal() {
		return llamadosRestantesAFinal;
	}

	public void setLlamadosRestantesAFinal(Integer llamadosRestantesAFinal) {
		this.llamadosRestantesAFinal = llamadosRestantesAFinal;
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
		return Objects.equals(id, other.id)
				|| (Objects.equals(alumno, other.alumno) && Objects.equals(comision, other.comision));
	}

}
