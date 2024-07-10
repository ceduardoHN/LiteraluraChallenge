package com.curso.alura.literalura.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcessData implements IProcessData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> clase) {
        try {
            return mapper.readValue(json.toString(), clase);
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
