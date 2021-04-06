package business;

public class CurrentAcount {
	
	private int id;
	
	private double balance;
	
	private boolean isActive;

	public CurrentAcount(int id, double balance, boolean isActive) {
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
					+ "Id: " + this.id + "\n"
					+ "Saldo: " + this.balance + "\n"
					+ "Status: " + (isActive ?"Ativa":"Inativa") + "\n"
					+ "=========================";
		return str;
	}
	
}
