package com.curso.alura.literalura.api;

public interface IProcessData {
    <T> T getData(String json, Class<T> clase);
}
