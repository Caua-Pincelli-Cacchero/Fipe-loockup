package br.com.caua.FipeTableConsultant.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(@JsonAlias("nome") modelVehicle vehicleModel,
                      @JsonAlias("CodigoFipe") int fipeCode,
                      @JsonAlias("Marca") String mark,
                      @JsonAlias("Modelo") String model,
                      @JsonAlias("AnoModelo") LocalDateTime year

) {
}
