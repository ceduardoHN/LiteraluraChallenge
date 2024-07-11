package com.curso.alura.literalura.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @author Soriano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookR(
        @JsonProperty("title")
        String title,
        @JsonProperty("authors")
        List<AuthorR> authorRS,
        @JsonProperty("languages")
        List<String> languages,
        @JsonProperty("download_count")
        int downloadCount
) {
}
