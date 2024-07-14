package com.curso.alura.literalura;

import com.curso.alura.literalura.api.GutendexAPI;
import com.curso.alura.literalura.dtos.BookR;
import com.curso.alura.literalura.dtos.ResultR;
import com.curso.alura.literalura.api.ProcessData;
import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.models.Book;
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
	private DataService dataService;

	@Autowired
	private BookService bookService;

	@Autowired
	private FormatObject formatterService;

	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner entradaMenu = new Scanner(System.in);
		GutendexAPI gutApi = new GutendexAPI();
		ProcessData processData = new ProcessData();
		String resultJson = "";

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
				case 1:		//BUSCAR/AGREGAR LIBROS
					Scanner entradaMenuOp1 = new Scanner(System.in);
					StringBuilder outPutBuilderOp1 = new StringBuilder();

					System.out.println("\nIngresa el nombre del libro que quieres buscar/agregar en tu biblioteca:");
					String bookName = entradaMenuOp1.nextLine();

					resultJson = gutApi.searchBook(bookName);
					ResultR bookResults = processData.getData(resultJson, ResultR.class);

					if(bookResults.count()!=0){
						StringBuilder bookTitle = new StringBuilder();
						bookResults.bookRS().stream()
							.sorted(Comparator.comparing(BookR::downloadCount).reversed())
							.limit(1)
							.forEach(bookRIterator -> {
								bookTitle.append(bookRIterator.title());
							});

						if(!this.dataService.verifyBook(bookTitle.toString())){
							//MOSTRANDO LIBRO ENCONTRADO AL USUARIO
							outPutBuilderOp1.append("\n----------- LIBRO -----------\n");
							bookResults.bookRS().stream()
								.sorted(Comparator.comparing(BookR::downloadCount).reversed())
								.limit(1)
								.forEach(bookRIterator -> {
									outPutBuilderOp1.append(formatterService.formatBookRInfo(bookRIterator));
									outPutBuilderOp1.append("-----------------------------\n");
								});
							System.out.println(outPutBuilderOp1.toString());

							//GUARDANDO DATOS EN LA BASE
							List<BookR> bookResultsSorted = bookResults.bookRS().stream()
								.sorted(Comparator.comparing(BookR::downloadCount).reversed())
								.limit(1)
								.collect(Collectors.toList());
							this.dataService.saveData(bookResultsSorted);
						}
						else{
							String outPut = String.format("""

                                        El nombre '%s' de libro que ingresaste ya existe.
                                        """,
									bookName);
							System.out.println(outPut);
						}
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
				case 2:		//BUSCAR LIBROS GUARDADOS/REGISTRADOS
					List<Book> books = this.bookService.getAllBooks();

					if(!books.isEmpty()){
						StringBuilder outPutBuilderOp2 = new StringBuilder();

						books.forEach(bookIterator -> {
							outPutBuilderOp2.append("\n----------- LIBRO -----------\n");
							outPutBuilderOp2.append(formatterService.formatBookInfo(bookIterator));
							outPutBuilderOp2.append("-----------------------------\n");
						});
						System.out.println(outPutBuilderOp2.toString());
					}
					else{
						String outPut = """
											
											_____Aún no hay libros registrados._____
											""";
						System.out.println(outPut);
					}

					break;
				case 3:		//BUSCAR AUTORES GUARDADOS/REGISTRADOS
					List<Author> authors = this.authorService.getAllAuthors();

					if(!authors.isEmpty()) {
						StringBuilder outPutBuilderOp3 = new StringBuilder();

						authors.forEach(authorIterator -> {
							outPutBuilderOp3.append("\n----------- AUTOR -----------\n");
							outPutBuilderOp3.append(formatterService.formatAuthorInfo(authorIterator));
							outPutBuilderOp3.append("-----------------------------\n");
						});
						System.out.println(outPutBuilderOp3.toString());
					}
					else{
						String outPut = """
												
												_____Aún no hay autores registrados._____
												""";
						System.out.println(outPut);
					}

					break;
				case 4:		//BUSCAR AUTORES VIVOS EN DETERMINADO AÑO
					Scanner entradaMenuOp4 = new Scanner(System.in);

					System.out.println("\nIngresa el año:");
					int year = entradaMenuOp4.nextInt();

					List<Author> authorsAlive = this.authorService.getAuthorsAliveByYear(year);

					if(!authorsAlive.isEmpty()) {
						StringBuilder outPutBuilderOp4 = new StringBuilder();
						authorsAlive.forEach(authorIterator -> {
							outPutBuilderOp4.append("\n----------- AUTOR -----------\n");
							outPutBuilderOp4.append(formatterService.formatAuthorInfo(authorIterator));
							outPutBuilderOp4.append("-----------------------------\n");
						});
						System.out.println(outPutBuilderOp4.toString());
					}
					else{
						String outPut = String.format("""
												
												----------------------------------
												Aún no hay autores registrados que
												estuviesen vivos en el año %d.
												----------------------------------
												""",
											year);
						System.out.println(outPut);
					}

					break;
				case 5:		//BUSCAR LIBROS POR IDIOMA
					Scanner entradaMenuOp5 = new Scanner(System.in);

					String outPutOptions = """
                                        
                                        Ingresa el idioma para buscar libros. 
                                        Las opciones son las siguientes:
                                        es - Español
                                        en - Inglés
                                        zh - Mandarín
                                        pt - Portugués
                                        nl - Holandés
                                        de - Alemán    
                                        otro* - Abreviatura de lenguaje soportada 
                                        		por la API.
                                        	*: Si la abreviatura no se reconoce 
                                        			por la API, no se retornará nada 
                                        			en la consola.                                 
                                        """;
					System.out.println(outPutOptions);
					String language = entradaMenuOp5.nextLine();

					List<Book> booksByLanguage = this.bookService.getBooksByLanguage(language);

					if(!booksByLanguage.isEmpty()) {
						StringBuilder outPutBuilderOp5 = new StringBuilder();
						booksByLanguage.forEach(bookIterator -> {
							outPutBuilderOp5.append("\n----------- LIBRO -----------\n");
							outPutBuilderOp5.append(formatterService.formatBookInfo(bookIterator));
							outPutBuilderOp5.append("-----------------------------\n");
						});
						System.out.println(outPutBuilderOp5.toString());
					}
					else{
						String outPut = String.format("""
													
													---------------------------------
													Aún no hay libros registrados que
													coincidan con el lenguaje '%s'.
													---------------------------------
													""",
												language);
						System.out.println(outPut);
					}

					break;
				case 0:
					System.out.println("¡¡Nos vemos!!\nTe esperamos de vuelta.\n");
					System.exit(0);

					break;
				default:
					String format = String.format("\n¡¡La opción '%d' no es válida!!\n", opcionMenu);
					System.out.println(format);
					break;
			}
		}
	}
}
