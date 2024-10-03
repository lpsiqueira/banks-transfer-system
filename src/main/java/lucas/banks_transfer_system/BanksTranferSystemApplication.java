package lucas.banks_transfer_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication/* (exclude = {DataSourceAutoConfiguration.class}) */

public class BanksTranferSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanksTranferSystemApplication.class, args);
	}

}
