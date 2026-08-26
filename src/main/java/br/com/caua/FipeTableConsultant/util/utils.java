package br.com.caua.FipeTableConsultant.util;

import br.com.caua.FipeTableConsultant.model.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static br.com.caua.FipeTableConsultant.model.baseURL.BASE_URL;

public class utils {
    static Scanner scanner = new Scanner(System.in);
    private final static List<String> VALID_INPUT = new ArrayList<>(
            Arrays.asList("CARRO",
                    "CAMINHAO",
                    "CAMINHÃO",
                    "MOTO"));

    public static void showVehicletMenu() {
        var menu ="""
                Escolha uma opção:
                Carro
                Moto
                Caminhão
                """;
        System.out.println(menu);
    }

    public static void showMarkMenu() {
        var menu = """
                Selecione a marca do seu veiculo:""";
        System.out.println(menu);
    }

    public static boolean verifyInputNullOrBlank() {
        try {
            var input = scanner.nextLine();

            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("A opção não pode ser vazia!");
            }

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static String verifyTypeVehicle() {
        utils.verifyInputNullOrBlank();
        var input = scanner.nextLine();

        if (!VALID_INPUT.contains(input.toUpperCase())) {
            throw new IllegalArgumentException("Opção inválida: " + input + ", tente novamente!");
        }

        return input;
    }

    private static String changeURL() {
        verifyTypeVehicle();

        String address;

        if(verifyTypeVehicle().contains("CARRO")) {
            address = BASE_URL + "/carros/marcas";
        } else if (verifyTypeVehicle().contains("MOTO")) {
            address = BASE_URL + "/motos/marcas";
        } else {
            address = BASE_URL + "/caminhoes/marcas";
        }

        return address;
    }

   // public static Vehicle

}
