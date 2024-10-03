package lucas.banks_transfer_system.personalAccountInfo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lucas.banks_transfer_system.financialInstituition.*;

@Entity
public class RegisteredPersonalKey {
	
	@EmbeddedId
	private PersonalKey personnalKey;
	private FinancialInstituition financialInstituition;
	private int bankAccount;
	
	public RegisteredPersonalKey() {
	}
	
	public RegisteredPersonalKey(PersonalKey personnalKey, FinancialInstituition financialInstituition,
			int bankAccount) {
		this.personnalKey = personnalKey;
		this.financialInstituition = financialInstituition;
		this.bankAccount = bankAccount;
	}

	public PersonalKey getPersonnalKey() {
		return personnalKey;
	}

	public void setPersonnalKey(PersonalKey personnalKey) {
		this.personnalKey = personnalKey;
	}

	public FinancialInstituition getFinancialInstituition() {
		return financialInstituition;
	}

	public void setFinancialInstituition(FinancialInstituition financialInstituition) {
		this.financialInstituition = financialInstituition;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}	
}
