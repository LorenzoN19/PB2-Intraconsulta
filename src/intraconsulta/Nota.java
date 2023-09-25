package intraconsulta;

import enums.TipoDeNota;

public class Nota {
	private TipoDeNota tipo;
	private Integer valor=0;

	public Nota(TipoDeNota tipo, Integer valor) {
		this.setTipo(tipo);
		setValor(valor);
	}
	
	public Nota(TipoDeNota tipo) {
		this.setTipo(tipo);
	}
	
	public Integer getValor() {
		return valor;
	}
	
	public boolean setValor(Integer valor) {
		if(valor>=1 && valor <=10) {
			this.valor = valor;
			return true;
		}
		return false;
	}

	public TipoDeNota getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeNota tipo) {
		this.tipo = tipo;
	}
}
