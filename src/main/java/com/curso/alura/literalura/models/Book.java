package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author Soriano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
        @JsonProperty("title")
        String title,
        @JsonProperty("authors")
        List<Author> authors,
        @JsonProperty("languages")
        List<String> languages,
        @JsonProperty("download_count")
        int downloadCount
) {
}
