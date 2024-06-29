package com.desafioalura.literalura.modelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);
    @Query("SELECT a FROM Autor a WHERE LOWER(TRIM(a.nombre)) LIKE LOWER(TRIM(CONCAT('%', :nombre, '%')))")
    Autor findByNombreJpql(@Param("nombre") String nombre);
    List<Autor> findByFechaDeNacimientoLessThanAndFechaDeFallecimientoGreaterThan(String fechaParaCompararNacimiento, String fechaParaCompararFallecimiento);

}
