package br.com.caua.FipeTableConsultant.util;

import br.com.caua.FipeTableConsultant.model.Brand;
import br.com.caua.FipeTableConsultant.model.Model;
import br.com.caua.FipeTableConsultant.model.modelResponse;
import br.com.caua.FipeTableConsultant.service.ApiConsumption;
import br.com.caua.FipeTableConsultant.service.ConvertData;

import java.util.*;

import static br.com.caua.FipeTableConsultant.model.baseURL.BASE_URL;

public class utils {
    static ConvertData convertData = new ConvertData();
    static ApiConsumption apiConsumption = new ApiConsumption();
    static Scanner scanner = new Scanner(System.in);
    private final static List<String> VALID_INPUT = new ArrayList<>(
            Arrays.asList("CARRO", "CAMINHAO", "CAMINHÃO", "MOTO"));

    private static Brand brand;
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

    public static void setBrand(Brand chosenBrand) {
        brand = chosenBrand;
    }
}