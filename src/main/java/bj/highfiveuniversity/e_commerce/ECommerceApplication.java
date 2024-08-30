package bj.highfiveuniversity.e_commerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.highfiveuniversity.e_commerce.models.User;
import bj.highfiveuniversity.e_commerce.repository.UserRepository;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			// Sauvegarder John Doe dans la base de donnée
			User johndoe = new User(null,
					"John Doe",
					"johndoe@gmail.com",
					"password",
					LocalDateTime.now(),
					LocalDateTime.now(),
					new ArrayList<>());
			userRepository.save(johndoe);

		};
	}

}
