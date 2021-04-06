package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static ClientManager gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		
		inicializaSistemaBancario(); // criando algumas contas e clientes fict�cios
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		while (continua){
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			// Consultar por um cliente
			case 1:
				System.out.print("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Client client = gerClientes.findClient(idCliente);
				
				if(client != null)
					System.out.println(client.toString());
				else
					System.out.println("Cliente n�o encontrado!");
				
				pulalinha();
				break;

			// Consultar por uma conta corrente
			case 2:
				System.out.print("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				CurrentAcount conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta n�o encontrado!");
				
				pulalinha();
				break;

			// Ativar um cliente
			case 3:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente2 = sc.nextInt();
				Client client2 = gerClientes.findClient(idCliente2);
				
				if(client2 != null){
					client2.setActive(true);
					System.out.println("Cliente ativado com sucesso!");
				}
				else
					System.out.println("Cliente n�o encontrado!");
			
				pulalinha();
				break;
				
			// Desativar um cliente
			case 4:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente3 = sc.nextInt();
				Client client3 = gerClientes.findClient(idCliente3);
				
				if(client3 != null){
					client3.setActive(false);
					System.out.println("Cliente desativado com sucesso!");
				}
				else
					System.out.println("Cliente n�o encontrado!");
				
				pulalinha();
				break;
			
			// Sair
			case 5:
				continua = false;
				System.out.println("################# Sistema encerrado #################");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
				
			} 
			
		}
	
		
	}

	private static void pulalinha() {
		System.out.println("\n");
	}

	/**
	 * Imprime menu de op��es do nosso sistema banc�rio
	 */
	private static void printMenu() {
		
		System.out.println("O que voc� deseja fazer? \n");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Sair");
		System.out.println();
		
	}

	/**
	 * M�todo que cria e insere algumas contas e clientes no sistema do banco,
	 * apenas para realiza��o de testes manuais atrav�s do m�todo main acima.
	 */
	private static void inicializaSistemaBancario() {
		// criando lista vazia de contas e clientes
		List<CurrentAcount> contasDoBanco = new ArrayList<>();
		List<Client> clientesDoBanco = new ArrayList<>();
		
		// criando e inserindo duas contas na lista de contas correntes do banco
		CurrentAcount conta01 = new CurrentAcount(1, 0, true);
		CurrentAcount conta02 = new CurrentAcount(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		// criando dois clientes e associando as contas criadas acima a eles
		Client client01 = new Client(1, "Gustavo Farias", 31, "gugafarias@gmail.com", conta01.getId(), true);
		Client client02 = new Client(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", conta02.getId(), true);
		// inserindo os clientes criados na lista de clientes do banco
		clientesDoBanco.add(client01);
		clientesDoBanco.add(client02);
		
		gerClientes = new ClientManager(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);
		
	}
	
}

