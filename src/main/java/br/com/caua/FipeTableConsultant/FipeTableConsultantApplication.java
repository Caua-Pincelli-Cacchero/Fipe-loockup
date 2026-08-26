package br.com.caua.FipeTableConsultant;

import br.com.caua.FipeTableConsultant.util.utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static br.com.caua.FipeTableConsultant.util.utils.*;

@SpringBootApplication
public class FipeTableConsultantApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(FipeTableConsultantApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		utils utils = new utils();
		showVehicletMenu();

		while(!utils.verifyInputNullOrBlank()) {
			verifyTypeVehicle();
		}

		showMarkMenu();


	}
}
