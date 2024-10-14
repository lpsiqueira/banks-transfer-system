package lucas.banks_transfer_system.exceptions.apis;

public class ServiceUnavailableException extends Exception {
	public ServiceUnavailableException (String msg) {
		super(msg);
	}
}
