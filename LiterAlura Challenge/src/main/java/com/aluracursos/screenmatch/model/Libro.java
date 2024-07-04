package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private List<String> idiomas;
    private Double numeroDeDescargas;
    @ManyToOne
    //@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autores;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutores() {
        return autores;
    }

    public Libro(){}
    public Libro(DatosLibro D){
        this.titulo = D.titulo();
        this.idiomas = D.idiomas();
        this.numeroDeDescargas = D.numeroDeDescargas();
    }

    public void setAutores(Autor autor) {
        this.autores = autor;
    }

    @Override
    public String toString() {
        return
        "------------LIBRO------------"+
        "\nTitulo: " + titulo +
        "\nIdiomas: " + idiomas +
        "\nNúmero de descargas: " + numeroDeDescargas +
        "\nAutor: " + autores.getTitulo()+
        "\n-----------------------------";
    }

}
