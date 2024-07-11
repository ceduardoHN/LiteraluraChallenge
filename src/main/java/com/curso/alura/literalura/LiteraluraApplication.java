package com.curso.alura.literalura;

import com.curso.alura.literalura.api.GutendexAPI;
import com.curso.alura.literalura.dtos.BookR;
import com.curso.alura.literalura.dtos.ResultR;
import com.curso.alura.literalura.api.ProcessData;
import com.curso.alura.literalura.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Soriano
 */
@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner entradaMenu = new Scanner(System.in);
		GutendexAPI gutApi = new GutendexAPI();
		ProcessData processData = new ProcessData();
		FormatObject formatter = new FormatObject();
		String resultJson = "";

//		StringBuilder outputBuilder = new StringBuilder();
//		outputBuilder.append("\n----------LIBRO (S)----------\n");

		while(true){
			System.out.println("\n-----------------MENÚ PRINCIPAL LITERALURA-----------------");
			System.out.println("1. Buscar/Agregar libro por título.");
			System.out.println("2. Obtener libros registrados/buscados.");
			System.out.println("3. Obtener autores registrados/buscados.");
			System.out.println("4. Buscar autores vivos en un determinado año.");
			System.out.println("5. Buscar libros por idioma.");
			System.out.println("0. SALIR");
			int opcionMenu = entradaMenu.nextInt();

			switch(opcionMenu) {
				case 1:
					Scanner entradaMenuOp1 = new Scanner(System.in);

					System.out.println("\nIngresa el nombre del libro que quieres buscar/agregar:");
					String bookName = entradaMenuOp1.nextLine();

					resultJson = gutApi.searchBook(bookName);
					ResultR bookResults = processData.getData(resultJson, ResultR.class);

					if(bookResults.count()!=0){
						StringBuilder outputBuilder = new StringBuilder();
						outputBuilder.append("\n----------- LIBRO -----------\n");

						//MOSTRANDO LIBRO ENCONTRADO AL USUARIO
						bookResults.bookRS().stream()
						.sorted(Comparator.comparing(BookR::downloadCount).reversed())
						.limit(1)
						.forEach(bookR -> {
							outputBuilder.append(formatter.formatBookInfo(bookR));
							outputBuilder.append("-----------------------------\n");
						});
						System.out.println(outputBuilder.toString());

						//GUARDANDO DATOS EN LA BASE
						List<BookR> bookResultsSorted = bookResults.bookRS().stream()
								.sorted(Comparator.comparing(BookR::downloadCount).reversed())
								.limit(1)
								.collect(Collectors.toList());
						this.dataService.saveData(bookResultsSorted);
					}
					else{
						String outPut = String.format("""

                                        El nombre '%s' de libro que ingresaste no se encontró.
                                        Intenta con un nombre diferente.
                                        """,
								bookName);
						System.out.println(outPut);
					}

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 0:
					System.out.println("¡¡Nos vemos!!\nTe esperamos de vuelta.\n");
					System.exit(0);

					break;
				case 7:
					resultJson = gutApi.test("");
					ResultR booksData = processData.getData(resultJson, ResultR.class);

					if(booksData.count()!=0){
						String outPut = String.format("""
											
										LIBROS ENCONTRADOS
										%s
										""",
								booksData);

						System.out.println(outPut);
					}
					else{
						System.out.println("""
									
									NO SE ENCONTRARON LIBROS.
								""");
					}

					break;
				default:
					String format = String.format("\n¡¡La opcion '%d' no es valida!!\n", opcionMenu);
					System.out.println(format);
					break;
			}
		}
	}
}
