package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.AlugueisCarro;
import model.entities.Veiculo;
import model.services.ServicoAluguel;
import model.services.TaxaServicoBrasil;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entrar dados do carro ");
		System.out.println("Modelo Carro: ");
		String modeloCarro = teclado.nextLine();
		System.out.println("Data retirar (dd/MM/yyyy hh:ss)");
		Date inicio = sdf.parse(teclado.nextLine());
		System.out.println("Retorno (dd/MM/yyyy  hh:ss)");
		Date fim =  sdf.parse(teclado.nextLine());
		
		AlugueisCarro alugueis = new AlugueisCarro(inicio, fim, new Veiculo(modeloCarro));
		System.out.println("Digite preco por hora: ");
		double precoHora = teclado.nextDouble();
		System.out.println("Digite preco por dia: ");
		double precoDia = teclado.nextDouble();
		
		ServicoAluguel  servicoAluguel = new ServicoAluguel(precoDia, precoHora, new TaxaServicoBrasil());
		
		servicoAluguel.processoPagamento(alugueis);
		
		System.out.println("Pagamento: ");
		System.out.println("Pagamento Base: " + String.format("%.2f",alugueis.getPagamento().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f",alugueis.getPagamento().getTaxa()));
		System.out.println("Pagamento: " + String.format("%.2f",alugueis.getPagamento().getPagamentoTotal()));
		
		
		teclado.close();
		
		
		
		

	}

}
