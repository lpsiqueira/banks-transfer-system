package lucas.banks_transfer_system.personnalKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lucas.banks_transfer_system.financialInstituition.*;

@Entity
public class RegisteredPersonnalKey {
	
	@EmbeddedId
	private PersonnalKey personnalKey;
	private FinancialInstituition financialInstituition;
	private int bankAccount;
	
	public RegisteredPersonnalKey() {
	}
	
	public RegisteredPersonnalKey(PersonnalKey personnalKey, FinancialInstituition financialInstituition,
			int bankAccount) {
		this.personnalKey = personnalKey;
		//this.financialInstituition = financialInstituition;
		this.bankAccount = bankAccount;
	}

	public PersonnalKey getPersonnalKey() {
		return personnalKey;
	}

	public void setPersonnalKey(PersonnalKey personnalKey) {
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
