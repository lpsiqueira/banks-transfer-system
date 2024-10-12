package lucas.banks_transfer_system.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucas.banks_transfer_system.financialInstituition.FinancialInstituition;
import lucas.banks_transfer_system.financialInstituition.FinancialInstituitionRepository;

@RestController
@RequestMapping("/")
public class Main {
	private final FinancialInstituitionRepository financialInstituitionRepository;

	public Main(FinancialInstituitionRepository financialInstituitionRepository) {
		this.financialInstituitionRepository = financialInstituitionRepository;

		this.createFinancialInstituitions();
	}

	@GetMapping
	public String welcome() {
		return "Welcome to the banks transfer system";
	}

	public String createFinancialInstituitions() {
		List<FinancialInstituition> banks = new ArrayList<FinancialInstituition>();

		banks.add(new FinancialInstituition(1, "Java Bank"));
		banks.add(new FinancialInstituition(2, "Python Bank"));
		banks.add(new FinancialInstituition(3, "PHP Bank"));

		for (FinancialInstituition bank: banks) {
			this.financialInstituitionRepository.saveAndFlush(bank);
		}

		return "Banks created successfully";
	}
}
