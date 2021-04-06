package business;

import java.util.List;

public class AccountManager {

	private List<CurrentAccount> bankAccounts;

	public AccountManager(List<CurrentAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<CurrentAccount> getBankAccounts() {
		return bankAccounts;
	}

	public CurrentAccount findAccount(int accountId) {

		for (CurrentAccount currentAccount : bankAccounts) {
			if(currentAccount.getId() == accountId) {
				return currentAccount;
			}
		}
		return null;
	}
	
	public void add(CurrentAccount currentAccount) {
		this.bankAccounts.add(currentAccount);
	}

	public boolean removeAccount(int currentAccountId) {
		
		boolean isRemove = false;
		
		for (CurrentAccount currentAccount : bankAccounts) {
			if(currentAccount.getId() == currentAccountId){
				bankAccounts.remove(currentAccount);
				isRemove = true;
				break;
			}
		}
		
		return isRemove;
	}

	public boolean isActiveAccount(int accountId) {
		
		boolean isActive = false;
		
		for (CurrentAccount currentAccount : bankAccounts) {
			if(currentAccount.getId() == accountId)
				if(currentAccount.isActive()){
					isActive = true;
					break;
				}
		}
		
		return isActive;
	}

	public boolean transferValue(int originAccountId, double value, int targetAccountId) {
		
		boolean sucess = false;
		
		CurrentAccount contaOrigem = findAccount(originAccountId);
		CurrentAccount contaDestino = findAccount(targetAccountId);

		//TODO - Analisar validação
//		if(contaOrigem.getSaldo() >= value){
			contaDestino.setBalance(contaDestino.getBalance() + value);
			contaOrigem.setBalance(contaOrigem.getBalance() - value);
			sucess = true;
//		}
	
		return sucess;
	}
	
}
