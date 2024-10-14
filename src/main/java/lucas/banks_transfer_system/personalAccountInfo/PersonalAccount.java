package lucas.banks_transfer_system.personalAccountInfo;

import java.io.Serializable;

public class PersonalAccount implements Serializable {
	private String name;
	private String cpf;
	private int bank;
	private int account;
	
	public PersonalAccount() {
	}

	public PersonalAccount(String name, String cpf, int bank, int account) {
		this.name = name;
		this.cpf = cpf;
		this.bank = bank;
		this.account = account;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public int getBank() {
		return bank;
	}

	public int getAccount() {
		return account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + bank;
		result = prime * result + account;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalAccount other = (PersonalAccount) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (bank != other.bank)
			return false;
		if (account != other.account)
			return false;
		return true;
	}
}
