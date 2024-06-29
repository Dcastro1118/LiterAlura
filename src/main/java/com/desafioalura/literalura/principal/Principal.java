package com.desafioalura.literalura.principal;

import com.desafioalura.literalura.logica.Logica;
import com.desafioalura.literalura.modelos.Autor;
import com.desafioalura.literalura.modelos.AutorRepository;
import com.desafioalura.literalura.modelos.Libro;
import com.desafioalura.literalura.modelos.LibroRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Logica logica;
    Scanner entrada = new Scanner(System.in);


    public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
        this.logica = new Logica(libroRepository, autorRepository);
    }

    public void Menu() {
        int opcion = 0;
        do {
                System.out.println("""
                        Bienvenido al sistema de consulta de libros!
                        Que desea hacer?:
                        1 - Consultar libro (en API)
                        2 - Consultar historial de libros buscados(En base de datos)
                        3 - Consultar libros por idioma(En base de datos)
                        4 - Consultar autores(En base de datos)
                        5 - Autores vivos en determinado año(En base de datos)
                        6 - Salir
                        """);

                try {
                    opcion = entrada.nextInt();
                    entrada.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("Ingrese un valor numerico");
                    entrada.nextLine();
                }

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nombre del libro que desea buscar:");
                            String nombreLibro = entrada.nextLine();
                            Libro libro = logica.consultarLibro(nombreLibro);
                            if (libro != null)
                                System.out.println(libro.toString());
                            else
                                System.out.println("Libro no encontrado");
                            break;
                        case 2:
                            System.out.println("Historial: \n" + logica.historialDeLibros());
                            break;
                        case 3:
                            System.out.println("Ingrese el idioma de los libros que desea buscar(en el siguiente formato: 'en' para ingles - 'es' para español)");
                            String idioma = entrada.nextLine();
                            if (idioma.contains("en") && idioma.contains("es")) {
                                List<Libro> libros = logica.consultarLibrosPorIdioma(idioma);
                                System.out.println("La cantidad de libros en '" + idioma + "' es de: " + libros.size());
                                libros.forEach(System.out::println);
                            } else {
                                System.out.println("Respuesta invalida: Ingrese 'en' para ingles o 'es' para español");
                            }
                            break;
                        case 4 :
                            System.out.println("Ingrese el nombre del autor a consultar");
                            String nombreAutor = entrada.nextLine();
                            Autor autorBuscado = logica.consultarAutor(nombreAutor);
                            if (autorBuscado != null)
                                System.out.println(autorBuscado);
                            else
                                System.out.println("Autor no encontrado en la base de datos");
                            break;
                        case 5:
                            System.out.println("Ingrese el año en el que quiere buscar autores vivos");
                            String year = entrada.nextLine();
                            List<Autor> autoresVivos = logica.consultarAutoresVivosPorFecha(year);
                            if (autoresVivos != null)
                                autoresVivos.forEach(System.out::println);
                            else
                                System.out.println("No se encontro ningun artista en la base de datos vivo en esa epoca");
                            break;
                        case 6:
                            System.out.println("Saliendo el programa \n Programa echo por David Castro");
                            break;
                    }
        } while (opcion != 6);

    }
}