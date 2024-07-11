package com.curso.alura.literalura.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @author Soriano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultR(
        @JsonProperty("count")
        int count,
        @JsonProperty("results")
        List<BookR> bookRS
) {
}
