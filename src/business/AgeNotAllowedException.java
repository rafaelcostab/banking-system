package business;

public class AgeNotAllowedException extends Exception {

	public static String MESSAGE_AGE_NOT_ALLOWED = "O cliente deve ter idade entre 18 e 65 anos!";
	
	public AgeNotAllowedException(String message) {
		super(message);
	}

}
