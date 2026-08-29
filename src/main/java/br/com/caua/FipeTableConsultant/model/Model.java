package br.com.caua.FipeTableConsultant.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Model(@JsonAlias("codigo") String code,
                    @JsonAlias("nome") String name){
}
