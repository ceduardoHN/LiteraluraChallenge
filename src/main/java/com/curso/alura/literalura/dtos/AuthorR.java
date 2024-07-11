package com.curso.alura.literalura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Soriano
 */
public record AuthorR(
        @JsonProperty("name")
        String name,
        @JsonProperty("birth_year")
        int birthYear,
        @JsonProperty("death_year")
        int deathYear
) {
}
