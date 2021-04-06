package business;

import java.util.List;

public class ClientManager {

	private List<Client> bankClients;

	public ClientManager(List<Client> bankClients) {
		this.bankClients = bankClients;
	}

	public List<Client> getBankClients() {
		return bankClients;
	}
	
	public Client findClient(int clientId) {

		for (Client client : bankClients) {
			if(client.getId() == clientId)
				return client;
		}
		return null;
	}

	public void addClient(Client client) {
		if(!bankClients.contains(client)) {
			bankClients.add(client);
		}
	}

	public boolean removeClient(int clientId) {
		boolean isRemove = false;

		for (Client client : bankClients){
			if (client.getId() == clientId){
				bankClients.remove(client);
				isRemove = true;
				break;
			}
		}

		return isRemove;
	}

	public boolean isClientActive(int clientId) {
		boolean isActive = false;
		
		for (Client client : bankClients) {
			if(client.getId() == clientId && client.isActive()) {
				isActive = true;
				break;
			}
		}
		
		return isActive;
	}
	
	public void clear() {
		this.bankClients.clear();
	}
	
	public boolean validateAge(int age) throws AgeNotAllowedException {
		if(age < 18 || age > 65) {
			throw new AgeNotAllowedException(AgeNotAllowedException.MSG_IDADE_INVALIDA);
		}
		return true;
	}
	
}
