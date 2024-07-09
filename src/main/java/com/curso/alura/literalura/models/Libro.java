package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @author Soriano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Libro(
        @JsonProperty("title")
        String titulo,
        @JsonProperty("authors")
        List<Autor> autores,
        @JsonProperty("languages")
        List<String> lenguajes,
        @JsonProperty("download_count")
        int numeroDescargas
) {
}
