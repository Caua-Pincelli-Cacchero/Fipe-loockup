package br.com.caua.FipeTableConsultant;

import br.com.caua.FipeTableConsultant.util.utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeTableConsultantApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeTableConsultantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		utils.showVehicletMenu();

		String tipo = null;
		while (tipo == null) {
			String input = utils.readValidInput();
			if (input == null) continue;
			try {
				tipo = utils.verifyTypeVehicle(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		utils.getVehicleData(tipo);

		utils.showMarkMenu();
		String marcaEscolhida = null;
		while (marcaEscolhida == null) {
			marcaEscolhida = utils.readValidInput();
		}

	}
}