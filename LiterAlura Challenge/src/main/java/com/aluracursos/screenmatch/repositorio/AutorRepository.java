package com.aluracursos.screenmatch.repositorio;

import com.aluracursos.screenmatch.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.aluracursos.screenmatch.model.Libro;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Optional<Autor> findBynombreContainsIgnoreCase(String nombre);
    @Query ("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :year AND a.fechaDeMuerte >= :year")
    List<Autor> findByYear(Integer year);
}
