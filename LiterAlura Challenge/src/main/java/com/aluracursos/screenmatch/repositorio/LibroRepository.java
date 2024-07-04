package com.aluracursos.screenmatch.repositorio;


import com.aluracursos.screenmatch.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findBytituloContainsIgnoreCase(String titulo);
    @Query(value="SELECT * FROM libros WHERE :idioma =ANY (idiomas)",nativeQuery = true)
    List<Libro> findByidiomas(String idioma);
}
