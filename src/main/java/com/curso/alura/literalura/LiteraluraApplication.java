package com.curso.alura.literalura;

import com.curso.alura.literalura.api.GutendexAPI;
import com.curso.alura.literalura.models.Book;
import com.curso.alura.literalura.models.Result;
import com.curso.alura.literalura.api.ProcessData;
import com.curso.alura.literalura.services.FormatObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Comparator;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

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
			System.out.println("-----------------MENÚ PRINCIPAL LITERALURA-----------------");
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
					Result bookResults = processData.getData(resultJson, Result.class);

					if(bookResults.count()!=0){
						StringBuilder outputBuilder = new StringBuilder();
						outputBuilder.append("\n----------- LIBRO -----------\n");

						bookResults.books().stream()
						.sorted(Comparator.comparing(Book::downloadCount).reversed())
						.limit(1)
						.forEach(book -> {
							outputBuilder.append(formatter.formatBookInfo(book));
							outputBuilder.append("-----------------------------\n");
						});

						System.out.println(outputBuilder.toString());
					}
					else{
						String outPut = String.format("""

                                        El nombre '%s' de libro que ingresaste no se encontró.
                                        Intenta con otro diferente.
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
					System.out.println("¡¡Nos vemos!!\nTe esperamos de vuelta.");
					System.exit(0);

					break;
				case 7:
					resultJson = gutApi.test("/");
					Result booksData = processData.getData(resultJson, Result.class);

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
