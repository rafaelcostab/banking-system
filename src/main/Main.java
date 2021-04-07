package main;

import business.AccountManager;
import business.Client;
import business.ClientManager;
import business.CurrentAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static ClientManager clientManager;
	static AccountManager accountManager;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		startBankingSystem();
		boolean continua = true;

		do {
			printMenu();
			System.out.print("Digite a opcao desejada: ");
			int option = sc.nextInt();

			switch (option) {
				case 1:
					findClientById();
				break;

				case 2:
					findAccountById();
					break;
				case 3:
					activateClient();
					break;
				case 4:
					inactivateClientById();
					break;
				case 5:
					continua = false;
					System.out.println("################# Sistema encerrado #################");
					break;
				default:
					System.out.println("default\n");
				break;
			}
		} while (continua);
	}

	private static void inactivateClientById() {
		System.out.print("Digite o ID do cliente: ");
		int clientId = sc.nextInt();
		Client client = clientManager.find(clientId);

		if (client != null) {
			client.setActive(false);
			System.out.println("Cliente desativado com sucesso!");
		} else {
			System.out.println("Cliente nao encontrado!");
		}
	}

	private static void activateClient() {
		System.out.print("Digite o ID do cliente: ");
		int clientId = sc.nextInt();
		Client client = clientManager.find(clientId);

		if(client != null){
			client.setActive(true);
			System.out.println("Cliente ativado com sucesso!");
		} else {
			System.out.println("Cliente nao encontrado!");
		}
	}

	private static void findAccountById() {
		System.out.print("Digite o ID da conta: ");
		int accountId = sc.nextInt();

		CurrentAccount account = accountManager.findAccount(accountId);

		if(account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("Conta nao encontrado!");
		}
	}

	private static void findClientById() {
		System.out.print("Digite o ID do cliente: ");
		int clientId = sc.nextInt();

		Client client = clientManager.find(clientId);

		if(client != null) {
			System.out.println(client.toString());
		} else {
			System.out.println("Cliente nao encontrado!");
		}
	}

	private static void skipLine() {
		System.out.println("\n");
	}

	private static void printMenu() {
		System.out.println("\n**Menu**");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Sair");
	}

	private static void startBankingSystem() {
		System.out.println("## Banking System ##");

		List<CurrentAccount> currentAccounts = new ArrayList<>();
		List<Client> clients = new ArrayList<>();

		CurrentAccount account01 = new CurrentAccount(1, 0, true);
		CurrentAccount account02 = new CurrentAccount(2, 0, true);
		currentAccounts.add(account01);
		currentAccounts.add(account02);

		Client client01 = new Client(1, "Gustavo Farias", 31, "gugafarias@gmail.com", account01.getId(), true);
		Client client02 = new Client(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", account02.getId(), true);
		clients.add(client01);
		clients.add(client02);
		
		clientManager = new ClientManager(clients);
		accountManager = new AccountManager(currentAccounts);

	}
}

