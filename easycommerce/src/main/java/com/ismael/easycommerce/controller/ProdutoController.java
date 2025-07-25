package com.ismael.easycommerce.controller;

import com.ismael.easycommerce.model.Produto;
import com.ismael.easycommerce.repository.ProdutoRepository;
import com.ismael.easycommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    private ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        Produto salvo = produtoService.salvar(produto);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping
    private List<Produto> listartodos(){
        return produtoService.listarTodosOsProdutos();
    }

    @GetMapping("/estoque/{id}")
    public Integer estoquePorProdutoById(@PathVariable Long id){
        return produtoService.estoquePorProduto(id);
    }

    @GetMapping("/categorias")
    private List<String> categoriasDisponiveis(){
        return produtoService.categoriaDisponiveis();
    }

    @GetMapping("/categorias/{categoria}")
    private List<Produto> categoriasDisponiveis(@PathVariable String categoria){
        return produtoService.produtosPorCategoria(categoria);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Produto> editar(@PathVariable Long id, @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.atualizarProduto(id,produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletarbyId(id);
        return ResponseEntity.noContent().build();
    }
}
