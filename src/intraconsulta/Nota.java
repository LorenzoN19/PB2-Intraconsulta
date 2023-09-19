package intraconsulta;

public class Nota {
	private Integer valor=0;

	public Nota(Integer valor) {
		if(valor>=1 && valor <=10)
			this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
	
	public void setValor(Integer valor) {
		if(valor>=1 && valor <=10)
			this.valor = valor;
	}
}
