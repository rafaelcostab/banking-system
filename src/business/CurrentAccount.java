package business;

public class CurrentAccount {
	
	private int id;
	
	private double balance;
	
	private boolean isActive;

	public CurrentAccount(int id, double balance, boolean isActive) {
		this.id = id;
		this.balance = balance;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}
	
	@Override
	public String toString() {
		
		String str = "========================="
					+ "\nId:\t\t" + this.id
					+ "\nSaldo:\t" + this.balance
					+ "\nStatus:\t" + (isActive ? "Ativa" : "Inativa")
					+ "\n=========================";
		return str;
	}
	
}
