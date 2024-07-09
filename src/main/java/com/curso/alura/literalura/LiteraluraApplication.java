package com.curso.alura.literalura;

import com.curso.alura.literalura.api.GutendexAPI;
import com.curso.alura.literalura.models.Datos;
import com.curso.alura.literalura.api.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		GutendexAPI gutapi = new GutendexAPI();
		ConvierteDatos convierteDatos = new ConvierteDatos();

		String librosJson = gutapi.test("");
		Datos datosLibros = convierteDatos.obtenerDatos(librosJson, Datos.class);
		//System.out.println(librosJson);
		System.out.println(datosLibros);
	}
}
