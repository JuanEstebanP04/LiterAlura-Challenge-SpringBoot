package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import java.util.OptionalInt;
import java.util.stream.Collectors;

@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeMuerte;
    @OneToMany (mappedBy = "autores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> Libros;

    public Autor(){}

    public Autor(DatosAutor d) {
        this.nombre = d.nombre();
        this.fechaDeNacimiento = OptionalInt.of(Integer.parseInt(d.fechaDeNacimiento())).orElse(0);
        this.fechaDeMuerte = OptionalInt.of(Integer.parseInt(d.fechaDeMuerte())).orElse(0);
        this.Libros = new ArrayList<>();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return nombre;
    }

    public void setTitulo(String titulo) {
        this.nombre = titulo;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public List<Libro> getLibros() {
        return Libros;
    }

    public void setLibros(List<Libro> libros) {
        Libros = libros;
    }
    public void setLibro(Libro libro) {
        libro.setAutores(this);
        Libros.add(libro);
    }

    public List<String> nombreLibros(){
        return getLibros().stream().map(Libro::getTitulo).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return
            "------------AUTOR------------"+
            "\nNombre: " + nombre +
            "\nLibros: " + nombreLibros() +
            "\nFecha de nacimiento: " + fechaDeNacimiento +
            "\nFecha de fallecimiento: " + fechaDeMuerte+
            "\n-----------------------------";
    }
}
