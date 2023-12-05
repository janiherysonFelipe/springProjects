package imd.ufrn.universidade_ufrn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UniversidadeUfrnApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadeUfrnApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("imd@2023"));
		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}

}
