package br.com.caua.FipeTableConsultant.util;

import br.com.caua.FipeTableConsultant.model.Brand;
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

    public static void showVehicletMenu() {
        System.out.println("""
                Escolha uma opção:
                Carro
                Moto
                Caminhão
                """);
    }

    public static void showMarkMenu() {
        System.out.println("Selecione a marca do seu veiculo:");
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

    private static String changeURL(String tipo) {
        String tipoUpper = tipo.toUpperCase();
        if (tipoUpper.contains("CARRO")) {
            return BASE_URL + "/carros/marcas";
        } else if (tipoUpper.contains("MOTO")) {
            return BASE_URL + "/motos/marcas";
        } else {
            return BASE_URL + "/caminhoes/marcas";
        }
    }

    public static void getVehicleData(String tipo) {
        String json = apiConsumption.getData(changeURL(tipo));
        var listaMarcas = convertData.getList(json, Brand.class);
        listaMarcas.forEach(System.out::println);
    }
}