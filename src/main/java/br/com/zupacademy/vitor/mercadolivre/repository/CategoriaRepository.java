package br.com.zupacademy.vitor.mercadolivre.repository;

import java.util.Optional;

import javax.validation.constraints.Positive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.vitor.mercadolivre.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByCategoriaMae(@Positive Long idCategoriaMae);

}
