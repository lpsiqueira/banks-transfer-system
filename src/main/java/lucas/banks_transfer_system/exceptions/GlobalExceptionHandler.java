package lucas.banks_transfer_system.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lucas.banks_transfer_system.exceptions.repository.*;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(TableConstraintException.class)
	public ResponseEntity<String> handleExistingRepositoryEntity(TableConstraintException e) {
		return ResponseEntity.status(400).body(e.getMessage());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
		return ResponseEntity.status(400).body(e.getMessage());
	}
}
