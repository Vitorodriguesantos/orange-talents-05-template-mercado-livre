package br.com.zupacademy.vitor.mercadolivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
