package lucas.banks_transfer_system.personnalKey;

import java.io.Serializable;

public class PersonnalInfo implements Serializable {
	private String name;
	private String cpf;
	private int bank;
	private int agencia;
	private int account;
	
	public PersonnalInfo() {
	}

	public PersonnalInfo(String name, String cPF, int bank, int agencia, int account) {
		this.name = name;
		this.cpf = cPF;
		this.bank = bank;
		this.agencia = agencia;
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + bank;
		result = prime * result + agencia;
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
		PersonnalInfo other = (PersonnalInfo) obj;
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
		if (agencia != other.agencia)
			return false;
		if (account != other.account)
			return false;
		return true;
	}
}
