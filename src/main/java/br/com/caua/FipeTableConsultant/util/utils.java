package br.com.caua.FipeTableConsultant.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class utils {
    static Scanner scanner = new Scanner(System.in);
    private final static List<String> VALID_INPUT = new ArrayList<>(Arrays.asList(
            "CARRO",
            "CAMINHAO",
            "CAMINHÃO",
            "MOTO"));

    public static void showMenu() {
        var menu ="""
                Escolha uma opção:
                Carro
                Moto
                Caminhão
                """;
        System.out.println(menu);
    }
    public static boolean verifyInput() {
        try {
            var input = scanner.nextLine();

            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("A opção não pode ser vazia!");
            }

            if (!VALID_INPUT.contains(input.toUpperCase())) {
                throw new IllegalArgumentException("Opção inválida: " + input + ", tente novamente!");
            }

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
