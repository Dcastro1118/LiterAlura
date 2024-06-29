package com.desafioalura.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;
    private List<String> idiomas;
    private Double numeroDeDescargas;


    public Libro(){
    }
    public Libro (DatosLibros libro){
        this.idiomas = libro.idiomas();
        this.numeroDeDescargas = libro.numeroDeDescargas();
        this.titulo = libro.titulo();
        Autor autor = new Autor(libro.autor().getFirst());
        autor.getLibros().add(this);
        this.autor = autor;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
                "\nAutores: " + autor +
                "\nIdiomas: " + idiomas +
                "\nNumero de descargas: " + numeroDeDescargas;
    }
}

