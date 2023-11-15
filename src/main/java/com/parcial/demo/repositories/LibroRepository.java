package com.parcial.demo.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.parcial.demo.models.Libro;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface LibroRepository extends JpaRepository<Libro, String>{

    @Query(value = "SELECT * FROM libro WHERE name = ?1", nativeQuery = true)
    Optional<Libro> findLibroByName(String name);

    @Query(value = "SELECT * FROM libro", nativeQuery = true)
    Optional<Libro> loadLibro();
}
     