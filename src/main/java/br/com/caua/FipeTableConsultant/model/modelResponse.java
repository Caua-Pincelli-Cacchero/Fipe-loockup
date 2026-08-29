package br.com.caua.FipeTableConsultant.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record modelResponse(@JsonAlias("modelos") List<Model> models,
                            @JsonAlias("anos") List<Year> years) {}
