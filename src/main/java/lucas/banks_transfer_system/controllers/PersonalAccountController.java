package lucas.banks_transfer_system.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucas.banks_transfer_system.exceptions.repository.EntityNotFoundException;
import lucas.banks_transfer_system.externalAPIs.ExternalAPIs;
import lucas.banks_transfer_system.personalAccountInfo.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("personal_account")
public class PersonalAccountController {
	private final RegisteredPersonalKeyRepository registeredPersonalKeyRepository;
	private final PersonalKeyController personalKeyController;
	private final ExternalAPIs<PersonalAccount, RegisteredPersonalKey> personalAccountAPI;

	public PersonalAccountController(
		RegisteredPersonalKeyRepository registeredPersonalKeyRepository, 
		PersonalKeyController personalKeyController,
		PersonalAccountAPI personalAccountAPI
	) {
		this.registeredPersonalKeyRepository = registeredPersonalKeyRepository;
		this.personalKeyController = personalKeyController;
		this.personalAccountAPI = personalAccountAPI;
	}

	@GetMapping("")
	public PersonalAccount getPersonalAccount(@RequestBody PersonalKey personalKey) throws EntityNotFoundException {
		System.out.println("Personal key: " + personalKey.toString());
		RegisteredPersonalKey registeredPersonalKey = this.personalKeyController.getRegisteredPersonalKey(personalKey);

		registeredPersonalKey.getBankAccount();
		//Logica para pegar as informações na tabela de info de conexão com a API do banco
		//Entidade com as informações de conexão com a API do banco
		//this.personalAccountAPI.setConectionConfiguration();

		if ( ! this.personalAccountAPI.authenticate()) {
			//
		}

		PersonalAccount personalAccountRetrieved = this.personalAccountAPI.getData(registeredPersonalKey);
		return personalAccountRetrieved;		
	}
	
}
