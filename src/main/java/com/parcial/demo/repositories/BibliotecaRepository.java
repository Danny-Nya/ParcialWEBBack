package com.parcial.demo.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.parcial.demo.models.Biblioteca;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{

    @Query(value = "SELECT * FROM biblioteca WHERE name = ?1", nativeQuery = true)
    Optional<Biblioteca> findBibliotecaByName(String name);

    @Query(value = "SELECT * FROM biblioteca", nativeQuery = true)
    Optional<Biblioteca> loadBiblioteca();
}