package business;

public class Client {

	private int id;
	
	private String name;
	
	private int age;
	
	private String email;
	
	private boolean isActive;
	
	private int currentAcountId;

	public Client(int id, String name, int age, String email, int currentAcountId, boolean isActive) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.currentAcountId = currentAcountId;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}

	public int getCurrentAcountId() {
		return this.currentAcountId;
	}

	public void setCurrentAcountId(int currentAcountId) {
		this.currentAcountId = currentAcountId;
	}

	@Override
	public String toString() {
		
		String str ="=========================" 
					+"Id: " + this.id + "\n"
					+ "Nome: " + this.name + "\n"
					+ "Email: " + this.email + "\n"
					+ "Idade: " + this.age + "\n"
					+ "Status: " + (isActive ?"Ativo":"Inativo") + "\n"
					+ "=========================";
		return str;
	}


}