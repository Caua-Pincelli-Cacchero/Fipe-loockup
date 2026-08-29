package br.com.caua.FipeTableConsultant;

import br.com.caua.FipeTableConsultant.model.Brand;
import br.com.caua.FipeTableConsultant.model.Model;
import br.com.caua.FipeTableConsultant.model.Vehicle;
import br.com.caua.FipeTableConsultant.util.utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FipeTableConsultantApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeTableConsultantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		utils.showVehicletMenu();
		String vehicleType = null;
		while (vehicleType == null) {
			String input = utils.readValidInput();
			if (input == null) continue;
			try {
				vehicleType = utils.verifyTypeVehicle(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		List<Brand> brands = utils.showVehicleBrand(vehicleType);

		System.out.println("Selecione a marca do seu veiculo:");
		String selectedBrand = null;
		while (selectedBrand == null) {
			try {
				selectedBrand = utils.readValidInput();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		final String finalSelectedBrand = selectedBrand;

		Brand chosenBrand = brands.stream()
				.filter(b -> b.name().equalsIgnoreCase(finalSelectedBrand))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Marca não encontrada: " + finalSelectedBrand));

		utils.setBrand(chosenBrand);

		List<Model> vehicles = utils.showVehicleModel();
		vehicles.forEach(v -> System.out.println(v.name()));
	}
}