package lucas.banks_transfer_system.personalAccountInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredPersonalKeyRepository extends JpaRepository<RegisteredPersonalKey, PersonalKey> {
	public RegisteredPersonalKey findByPersonalKey(PersonalKey personalKey);
}
