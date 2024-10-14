package lucas.banks_transfer_system.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucas.banks_transfer_system.financialInstituition.FinancialInstituition;
import lucas.banks_transfer_system.financialInstituition.FinancialInstituitionRepository;
import lucas.banks_transfer_system.personalAccountInfo.*;
import lucas.banks_transfer_system.exceptions.repository.*;

@RestController
@RequestMapping("personal_key")
public class PersonalKeyController {
	public final RegisteredPersonalKeyRepository registeredPersonalKeyRepository;
	public final FinancialInstituitionRepository financialInstituitionRepository;

	PersonalKeyController(
		RegisteredPersonalKeyRepository registeredPersonalKeyRepository, 
		FinancialInstituitionRepository financialInstituitionRepository
	) {
		this.registeredPersonalKeyRepository = registeredPersonalKeyRepository;
		this.financialInstituitionRepository = financialInstituitionRepository;

	}
	

	@GetMapping("")
	public RegisteredPersonalKey getRegisteredPersonalKey(@RequestBody PersonalKey personalKey) throws EntityNotFoundException {
		RegisteredPersonalKey registeredPersonalKey = this.registeredPersonalKeyRepository.findByPersonalKey(personalKey);

		if (registeredPersonalKey == null) {
			throw new EntityNotFoundException("Personal Key not found.");
		}

		return registeredPersonalKey;
	}


	public record RegisterPersonalKeyRequestBody (Integer bankId, PersonalKey personalKey, int bankAccount) {};

	@PostMapping("")
	public String registerPersonalKey(@RequestBody RegisterPersonalKeyRequestBody requestBody) throws TableConstraintException, EntityNotFoundException {
		RegisteredPersonalKey registeredPersonalKey = this.registeredPersonalKeyRepository.findByPersonalKey(requestBody.personalKey());

		if (registeredPersonalKey != null) {
			throw new TableConstraintException("Personal Key already exists.");
		}

		FinancialInstituition financialInstituition = this.financialInstituitionRepository.findByNumberId(requestBody.bankId());

		if (financialInstituition == null) {
			throw new EntityNotFoundException("Financial Instituition not found.");
		}

		registeredPersonalKey = new RegisteredPersonalKey(
			requestBody.personalKey(), 
			financialInstituition,
			requestBody.bankAccount()
		);

		this.registeredPersonalKeyRepository.saveAndFlush(registeredPersonalKey);

		return "Personal Key registered successfully";
	}

	@DeleteMapping("")
	public String deletePersonalkey(@RequestBody RegisterPersonalKeyRequestBody requestBody) throws EntityNotFoundException {
		RegisteredPersonalKey registeredPersonalKey = this.registeredPersonalKeyRepository.findByPersonalKey(requestBody.personalKey());

		if (registeredPersonalKey == null) {
			throw new EntityNotFoundException("Personal Key not found.");
		}

		this.registeredPersonalKeyRepository.delete(registeredPersonalKey);

		return "Personal Key deleted successfully.";
	}

}
