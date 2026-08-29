package br.com.caua.FipeTableConsultant.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record modelResponse(@JsonAlias("modelos") List<Model> models,
                            @JsonAlias("anos") List<Year> years) {}
