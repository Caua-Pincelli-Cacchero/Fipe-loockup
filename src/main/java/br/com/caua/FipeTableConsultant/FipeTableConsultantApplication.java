package br.com.caua.FipeTableConsultant;

import br.com.caua.FipeTableConsultant.util.main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeTableConsultantApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(FipeTableConsultantApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		main.showMenu();
	}
}
