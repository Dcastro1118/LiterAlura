package com.desafioalura.literalura.logica;

import com.desafioalura.literalura.logica.service.ConsumoApi;
import com.desafioalura.literalura.modelos.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class Logica {

    @Autowired
    LibroRepository libroRepository;
    AutorRepository autorRepository;
    ConsumoApi consulta = new ConsumoApi();

    public Logica(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }
    @Transactional
    public String historialDeLibros(){
        StringBuilder stringBuilder = new StringBuilder();
        List<Libro> historialDeLibros = libroRepository.findAll().stream()
                .collect(Collectors.toList());
        for (Libro libro : historialDeLibros){
            stringBuilder.append(libro.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
    @Transactional
    public Libro consultarLibro(String tituloLibro) {
        Autor autor = null;
        Libro libro = null;
        try {
            String json = consulta.solicitudApi(tituloLibro);
            Datos datos = consulta.convertirDatos(json, Datos.class);
            libro = new Libro(datos.libros().getFirst());
            if (libroRepository.findByTitulo(libro.getTitulo()) == null) {
                autor = autorRepository.findByNombre(libro.getAutor().getNombre());
                if (autor == null) {
                    libroRepository.save(libro);
                } else {
                    libro.setAutor(autor);
                    libroRepository.save(libro);
                }
            }
            return libro;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Autor> consultarAutoresVivosPorFecha(String fecha){
        return autorRepository.findByFechaDeNacimientoLessThanAndFechaDeFallecimientoGreaterThan(fecha, fecha);
    }

    public Autor consultarAutor(String nombreAutor) {
        Autor autor = autorRepository.findByNombreJpql(nombreAutor);
        return autor;
    }
    @Transactional
    public List<Libro> consultarLibrosPorIdioma (String idioma) {
        List<Libro> libros = libroRepository.findAll().stream()
                .filter(l -> l.getIdiomas().getFirst().equalsIgnoreCase(idioma))
                .toList();
        return libros;
    }
}
