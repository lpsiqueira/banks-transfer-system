package lucas.banks_transfer_system.financialInstituition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialInstituitionRepository extends JpaRepository<FinancialInstituition, Integer> {
	public FinancialInstituition findByNumberId(Integer id);
	public FinancialInstituition findByName(String name);
}
