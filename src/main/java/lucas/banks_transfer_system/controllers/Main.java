package lucas.banks_transfer_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Main {

	@GetMapping
	public String welcome() {
		return "Welcome to the banks transfer system";
	}
}
