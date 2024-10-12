package lucas.banks_transfer_system.financialInstituition;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class FinancialInstituition implements Serializable {
	@Id
	private Integer numberId;
	private String name;

	public FinancialInstituition() {
	}
	
	public FinancialInstituition(Integer numberId, String name) {
		this.numberId = numberId;
		this.name = name;
	}

	public Integer getNumberId() {
		return numberId;
	}

	public void setNumberId(Integer numberId) {
		this.numberId = numberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
