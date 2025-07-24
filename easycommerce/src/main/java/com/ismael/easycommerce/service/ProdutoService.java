package com.ismael.easycommerce.service;
import com.ismael.easycommerce.model.Produto;
import com.ismael.easycommerce.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


//id, nome, preco, categoria, estoque

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodosOsProdutos(){
        return produtoRepository.findAll();
    }

    public Integer estoquePorProduto(Long id){
        Integer estoque = produtoRepository.buscarEstoquePorId(id);
        if (estoque == null){
            throw new EntityNotFoundException("Produto com id: "+ id+ "não encontrado");
        }
        return estoque;
    };

    public List<String> categoriaDisponiveis(){
        return produtoRepository.buscarCategoriasDisponiveis();
    }

    public List<Produto> produtosPorCategoria(String categoria){
        List<Produto> produtos = produtoRepository.listarProdutosPorCategoria(categoria);
        if (produtos.isEmpty()){
            throw new EntityNotFoundException("Nenhu produto da categoria: "+ " encontrado!");
        }
        return produtos;
    }

    public Produto atualizarProduto(Long id, Produto dadosatualizados){
        Produto produtosatual = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        produtosatual.setNome(dadosatualizados.getNome());
        produtosatual.setCategoria(dadosatualizados.getCategoria());
        produtosatual.setPreco(dadosatualizados.getPreco());
        produtosatual.setEstoque(dadosatualizados.getEstoque());

        return produtoRepository.save(produtosatual);
    }

    public void deletarbyId(Long id){
        if(!produtoRepository.existsById(id)){
            throw new EntityNotFoundException("Produto com id: "+ id+ "não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
