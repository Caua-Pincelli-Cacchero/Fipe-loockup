package br.com.caua.FipeTableConsultant.util;

import java.util.Scanner;

public class main {
    Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        var menu ="""
                Escolha uma opção:
                Carro
                Moto
                Caminhão
                """;
        System.out.println(menu);
        
    }
}
