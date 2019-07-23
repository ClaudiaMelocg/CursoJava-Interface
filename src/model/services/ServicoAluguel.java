package model.services;

import model.entities.AlugueisCarro;
import model.entities.Pagamento;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	
	private TaxaServico taxaServico;
	
	
	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServico taxaServico) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	
		
	public Double getPrecoPorDia() {
		return precoPorDia;
	}


	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}


	public Double getPrecoPorHora() {
		return precoPorHora;
	}



	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}


	public TaxaServico getTaxaServico() {
		return taxaServico;
	}





	public void setTaxaServico(TaxaServico taxaServico) {
		this.taxaServico = taxaServico;
	}





	public void processoPagamento(AlugueisCarro alugueis) {
		long t1 = alugueis.getInicio().getTime();
		long t2 = alugueis.getFim().getTime();
		double horas = (double) (t2-t1) / 100 / 60 / 60;
		
		double precoBase;
		if(horas <= 12.0) {
			precoBase = Math.ceil(horas) * precoPorHora;
		}
		else {
			precoBase = Math.ceil(horas) / 24 * precoPorDia;
		}
		
		
		double taxa = taxaServico.taxa(precoBase);
		alugueis.setPagamento(new Pagamento(precoBase, taxa));
	}
	
	
	

}
