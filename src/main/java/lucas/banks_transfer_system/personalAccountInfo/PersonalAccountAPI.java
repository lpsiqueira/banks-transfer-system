package lucas.banks_transfer_system.personalAccountInfo;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import lucas.banks_transfer_system.externalAPIs.ExternalAPIs;

@Component
public class PersonalAccountAPI implements ExternalAPIs<PersonalAccount, RegisteredPersonalKey> {
	private List<PersonalAccount> accounts;

	//Caso essa classe ou qualquer outra classe @Component precise de alguma outra dependencia, é necessário adicionar @Inject no método (constructor) onde a dependencia será injetada e armazenada em alguma propriedade da classe
	public PersonalAccountAPI(){}

	@Override
	public Boolean authenticate() {
		return true;
	}

	@Override
	public PersonalAccount getData(RegisteredPersonalKey filterPersonalKey) {
		this.setAccounts(this.createSomeAccounts());

		PersonalAccount personalKeyAccount = new PersonalAccount();

		for(PersonalAccount account: this.accounts) {
			if(account.getBank() == filterPersonalKey.getFinancialInstituition().getNumberId() && account.getAccount() == filterPersonalKey.getBankAccount()){
				personalKeyAccount = account;
			}
		}

		return personalKeyAccount;
	}

	public List<PersonalAccount> createSomeAccounts() {
		this.accounts = new ArrayList<PersonalAccount>();

		accounts.add(
			new PersonalAccount("Tiquinho Soares", "12345678909", 1, 1)
		);
		accounts.add(
			new PersonalAccount("Arthur Jorge", "11845678909", 1, 2)
		);
		accounts.add(
			new PersonalAccount("Junior Santos", "12340438909", 2, 1)
		);
		accounts.add(
			new PersonalAccount("Luiz Henrique", "98440438909", 3, 1)
		);

		return accounts;
	}

	public void setAccounts(List<PersonalAccount> accounts) {
		this.accounts = accounts;
	}

}
