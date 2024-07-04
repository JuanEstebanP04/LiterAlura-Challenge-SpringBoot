package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.model.*;
import com.aluracursos.screenmatch.repositorio.AutorRepository;
import com.aluracursos.screenmatch.repositorio.LibroRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.*;

public class AppPrincipal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final AutorRepository repositorio;
    private final LibroRepository LibroRepositorio;
    private Libro BusquedaLibro;
    private Autor BusquedaAutor;

    public AppPrincipal(AutorRepository repository, LibroRepository libroRepository) {
        this.repositorio = repository;
        this.LibroRepositorio = libroRepository;
    }

    public void muestraElMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar Libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    librosRegistrados();
                    break;
                case 3:
                    AutoresRegistrados();
                    break;
                case 4:
                    autoresVivos();
                    break;
                case 5:
                    librosPorIdioma();

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private Datos getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ","+"));
        return conversor.obtenerDatos(json,Datos.class);
    }

    private void buscarLibroWeb(){
        Optional<DatosLibro> libroBuscado = getDatosLibro().resultados().stream().findFirst();
        if (libroBuscado.isPresent()){
            if (exitenciaDeLibro(libroBuscado.get())){
                System.out.println("El libro ya fue consultado");
                System.out.println(BusquedaLibro);
            }else{
                var autorLibro = libroBuscado.get().autor().stream().findFirst();
                Libro libro = new Libro(libroBuscado.get());
                if(existenciaDeAutor(autorLibro.get())){
                    BusquedaAutor.setLibro(libro);
                        repositorio.save(BusquedaAutor);
                }else {
                    Autor autornuevo = new Autor(libroBuscado.get().autor().stream().findFirst().get());
                    autornuevo.setLibro(libro);
                    repositorio.save(autornuevo);
                }
            }
        }else {
            System.out.println("Libro no encontrado");
        }
    }

    private boolean exitenciaDeLibro(DatosLibro libro){
        var libroEncontrado = LibroRepositorio.findBytituloContainsIgnoreCase(libro.titulo());
        if(libroEncontrado.isPresent()){
            BusquedaLibro = libroEncontrado.get();
            return true;
        }else {
            return false;
        }
    }

    private boolean existenciaDeAutor(DatosAutor autor){
        var autorencontrado = repositorio.findBynombreContainsIgnoreCase(autor.nombre());
        if(autorencontrado.isPresent()){
            BusquedaAutor = autorencontrado.get();
            return true;
        }else {
            return false;
        }
    }

    private void librosRegistrados(){
        var libros = LibroRepositorio.findAll();
        libros.forEach(System.out::println);
    }

    private void AutoresRegistrados(){
        var autores = repositorio.findAll();
        autores.forEach(System.out::println);
    }

    private void autoresVivos(){
        System.out.println("Ingrese el año vivo de autor(es) que desea consultar");
        var año = teclado.nextInt();
        var autores = repositorio.findByYear(año);
        autores.forEach(System.out::println);
    }

    private void librosPorIdioma(){
        var menu = """
                    es - Español
                    en - Inglés
                    fr - Francés
                    pt - Portugués
                    
                    """;
        System.out.println("Ingrese el idioma para buscar los libros");
        System.out.println(menu);
        var idioma = teclado.nextLine();
        var libros = LibroRepositorio.findByidiomas(idioma);
        libros.forEach(System.out::println);
    }
}
