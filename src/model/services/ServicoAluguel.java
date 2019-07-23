package model.services;

import model.entities.AlugueisCarro;
import model.entities.Pagamento;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	private TaxaServicoBrasil taxaServico;
	
	
	

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServicoBrasil taxaServico) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
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
