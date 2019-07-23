package model.entities;

public class Pagamento {
	
	private Double pagamentoBasico;
	private Double taxa;
	
	public Pagamento() {
		
	}

	public Pagamento(Double pagamentoBasico, Double taxa) {
		this.pagamentoBasico = pagamentoBasico;
		this.taxa = taxa;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	
	public Double getPagamentoTotal() {
		return getPagamentoBasico() + getTaxa();
	}	
	

}
