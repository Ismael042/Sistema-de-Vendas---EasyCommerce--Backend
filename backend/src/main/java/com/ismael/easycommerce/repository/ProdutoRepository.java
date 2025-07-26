package com.ismael.easycommerce.repository;

import com.ismael.easycommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p.estoque FROM Produto p WHERE p.id =:id")
    Integer buscarEstoquePorId(@Param("id") Long id);

    @Query("SELECT DISTINCT p.categoria FROM Produto p ORDER BY categoria ASC")
    List<String> buscarCategoriasDisponiveis();

    @Query("SELECT p FROM Produto p WHERE p.categoria =:categoria")
    List<Produto> listarProdutosPorCategoria(@Param("categoria") String categoria);

}
