package br.com.caua.FipeTableConsultant.util;

import br.com.caua.FipeTableConsultant.model.Brand;
import br.com.caua.FipeTableConsultant.model.Model;
import br.com.caua.FipeTableConsultant.model.Vehicle;
import br.com.caua.FipeTableConsultant.model.Year;
import br.com.caua.FipeTableConsultant.model.modelResponse;
import br.com.caua.FipeTableConsultant.service.ApiConsumption;
import br.com.caua.FipeTableConsultant.service.ConvertData;
import lombok.Setter;

import java.util.*;

import static br.com.caua.FipeTableConsultant.model.baseURL.BASE_URL;

public class utils {
    static ConvertData convertData = new ConvertData();
    static ApiConsumption apiConsumption = new ApiConsumption();
    static Scanner scanner = new Scanner(System.in);
    private final static List<String> VALID_INPUT = new ArrayList<>(
            Arrays.asList("CARRO", "CAMINHAO", "CAMINHÃO", "MOTO"));

    @Setter
    private static Brand brand;
    @Setter
    private static Model model;
    private static String vehicleType;

    public static void showVehicletMenu() {
        System.out.println("""
                Escolha uma opção:
                Carro
                Moto
                Caminhão
                """);
    }

    public static String readValidInput() {
        var input = scanner.nextLine();
        if (input == null || input.isBlank()) {
            System.out.println("A opção não pode ser vazia!");
            return null;
        }
        return input;
    }

    public static String verifyTypeVehicle(String input) {
        if (!VALID_INPUT.contains(input.toUpperCase())) {
            throw new IllegalArgumentException("Opção inválida: " + input + ", tente novamente!");
        }
        return input;
    }

    private static String changeVehicleURL(String address) {
        String addressUpper = address.toUpperCase();
        if (addressUpper.contains("CARRO")) {
            return BASE_URL + "/carros/marcas";
        } else if (addressUpper.contains("MOTO")) {
            return BASE_URL + "/motos/marcas";
        } else {
            return BASE_URL + "/caminhoes/marcas";
        }
    }

    private static String changeModelURL() {
        String tipo = vehicleType.toUpperCase().contains("CARRO") ? "carros"
                : vehicleType.toUpperCase().contains("MOTO") ? "motos"
                : "caminhoes";
        return BASE_URL + "/" + tipo + "/marcas/" + brand.code() + "/modelos";
    }

    private static String changeValidYearsURL() {
        String tipo = vehicleType.toUpperCase().contains("CARRO") ? "carros"
                : vehicleType.toUpperCase().contains("MOTO") ? "motos"
                : "caminhoes";
        return BASE_URL + "/" + tipo + "/marcas/" + brand.code() + "/modelos/" + model.code() + "/anos";
    }

    private static String changeYearURL(String yearCode) {
        String tipo = vehicleType.toUpperCase().contains("CARRO") ? "carros"
                : vehicleType.toUpperCase().contains("MOTO") ? "motos"
                : "caminhoes";
        return BASE_URL + "/" + tipo + "/marcas/" + brand.code() + "/modelos/" + model.code() + "/anos/" + yearCode;
    }

    public static List<Brand> showVehicleBrand(String address) {
        vehicleType = address;
        String json = apiConsumption.getData(changeVehicleURL(address));
        var listBrand = convertData.getList(json, Brand.class);
        listBrand.forEach(System.out::println);
        return listBrand;
    }

    public static List<Model> showVehicleModel() {
        String json = apiConsumption.getData(changeModelURL());
        modelResponse response = convertData.getObject(json, modelResponse.class);
        response.models().forEach(System.out::println);
        return response.models();
    }

    public static List<Vehicle> showAllVehiclesByYear() {
        String json = apiConsumption.getData(changeValidYearsURL());
        List<Year> validYears = convertData.getList(json, Year.class);

        List<Vehicle> vehicles = new ArrayList<>();
        for (Year year : validYears) {
            String yearJson = apiConsumption.getData(changeYearURL(year.code()));
            Vehicle vehicle = convertData.getObject(yearJson, Vehicle.class);
            vehicles.add(vehicle);
        }
        vehicles.forEach(System.out::println);
        return vehicles;
    }
}