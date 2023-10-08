package ola.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DemoApplication {
	@Value("${application.name}")
	public String appNome;

	@GetMapping("/hello")
	public String olaMundo(){
		return appNome;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}



//@Autowired
//@Qualifier("appNamw")