package lucas.banks_transfer_system.transaction;

import org.hibernate.type.descriptor.java.UUIDJavaType;
import java.time.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lucas.banks_transfer_system.personalAccountInfo.*;

@Entity
public class Transaction {
	@Id
	private UUIDJavaType id;
	private LocalDateTime transactionTimeStamp;
	private float value;
	private PersonalAccount payer; 
	private PersonalAccount payee;

	public Transaction() {
	}

	public Transaction(UUIDJavaType id, LocalDateTime transactionTimeStamp, float value, PersonalAccount payer,
			PersonalAccount payee) {
		this.id = id;
		this.transactionTimeStamp = transactionTimeStamp;
		this.value = value;
		this.payer = payer;
		this.payee = payee;
	}

	public UUIDJavaType getId() {
		return id;
	}

	public void setId(UUIDJavaType id) {
		this.id = id;
	}

	public LocalDateTime getTransactionTimeStamp() {
		return transactionTimeStamp;
	}

	public void setTransactionTimeStamp(LocalDateTime transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public PersonalAccount getPayer() {
		return payer;
	}

	public void setPayer(PersonalAccount payer) {
		this.payer = payer;
	}

	public PersonalAccount getPayee() {
		return payee;
	}

	public void setPayee(PersonalAccount payee) {
		this.payee = payee;
	}
}
