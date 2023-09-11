package intraconsulta;

import java.util.Objects;

public class Aula {

	private Integer numero;
	private Integer capacidadTotal;

	public Aula(Integer numero, Integer capacidadTotal) {
		this.numero = numero;
		this.capacidadTotal = capacidadTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidadTotal() {
		return capacidadTotal;
	}

	public void setCapacidadTotal(Integer capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(numero, other.numero);
	}

}
