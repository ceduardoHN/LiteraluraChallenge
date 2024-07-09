package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Soriano
 */
public record Autor(
        @JsonProperty("name")
        String nombre,
        @JsonProperty("birth_year")
        int nacimiento,
        @JsonProperty("death_year")
        int fallecimiento
) {
}
