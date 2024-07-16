package com.vasquez.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.vasquez.repositories.AuthorRepository;
import com.vasquez.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vasquez.DTO.BookDTO;
import com.vasquez.models.Author;
import com.vasquez.models.Book;

@Service
public class ScannerService {

    @Autowired
    ApiService apiService;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    public void getScanner() throws IOException, InterruptedException {

        System.out.println("Digite a opção 1");
        Scanner sc = new Scanner(System.in);
        String monedas = """

                *********************************************************************                
                     Sea Bienvenido/a al API PELICULAS =]
                     -------------------------------------------
              
                 1. Buscar libro por título
                 2. Listar libros registrados
                 3. Listar autores registrados
                 4. Listar autores vivos en un determinado año
                 5. Listar libros por idiomas
                 6. Salir
                 Elija una opción valida:
                                            [--- Developed By Jhonatan Vasquez ---]                 
                *********************************************************************
                """;


        int opcion = 0;

        do {
            try {
                System.out.println(monedas);
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Seleccione una opción valida.");
                sc.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la película:");
                    String title;
                    title = sc.nextLine();
                    BookDTO bookDTO = apiService.getApi(title);
                    Book book = new Book(bookDTO.title(), bookDTO.authors(), bookDTO.languages(), bookDTO.downloadTotal());
                    bookService.save(book);
                    System.out.println("Book ==>> " + book + " insertado correctamente");
                    break;
                case 2:
                    List<Book> books = bookService.findAll();
                    System.out.println("Lista de Libros");
                    System.out.println("-----------------");
                    System.out.println(books);
                    break;
                case 3:
                    List<Author> authors = authorService.findAll();
                    System.out.println("Lista de Autores");
                    System.out.println("------------------");
                    System.out.println(authors);
                    break;
                case 4:
                    System.out.println("Ingrese año que desea buscar:");
                    int year = sc.nextInt();
                    List<Author> aliveAuthorsInYear = authorService.findAliveAuthorsInYear(year);
                    System.out.println("Lista de Autores Vivos en el año " + year);
                    System.out.println("------------------------------------------");
                    System.out.println(aliveAuthorsInYear);
                    break;
                case 5:
                    System.out.println("Ingrese el idioma que sea buscar:");
                    String language = sc.nextLine();
                    List<Book> booksByLanguage = bookService.findBooksByLanguage(language);
                    System.out.println("Lista de Libros por idioma: " + language);
                    System.out.println("------------------------------------------");
                    System.out.println(booksByLanguage);
                    break;
                case 6:
                    System.out.println(" **  Adiós ** ");
                    break;
                default:
                    break;

            }
        } while (opcion != 6);
        sc.close();


    }
}
