package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Result(
        @JsonProperty("count")
        int count,
        @JsonProperty("results")
        List<Book> books
) {
}
