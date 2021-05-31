package br.com.zupacademy.vitor.mercadolivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.vitor.mercadolivre.modelo.Imagens;
@Repository
public interface ImagemRepository extends JpaRepository<Imagens, Long>{

}
