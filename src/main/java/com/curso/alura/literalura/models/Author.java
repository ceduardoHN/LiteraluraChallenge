package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Soriano
 */
public record Author(
        @JsonProperty("name")
        String name,
        @JsonProperty("birth_year")
        int birthYear,
        @JsonProperty("death_year")
        int deathYear
) {
}
