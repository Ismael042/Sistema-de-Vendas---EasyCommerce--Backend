package com.ismael.easycommerce.service;

import com.ismael.easycommerce.model.ItemVenda;
import com.ismael.easycommerce.model.Produto;
import com.ismael.easycommerce.model.Venda;
import com.ismael.easycommerce.repository.ProdutoRepository;
import com.ismael.easycommerce.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public Venda salvar(Venda venda){
        BigDecimal total = BigDecimal.ZERO;

        for (ItemVenda item : venda.getItens()){

            // Busca do Produto
            Produto produto = produtoRepository.findById(item.getProduto().getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            // Subtotal = Preçounitario * quantidade
            BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));

            item.setPrecounitario(produto.getPreco());
            item.setSubtotal(subtotal);
            item.setVenda(venda);

            //Atualizando o valor do estoque dps da venda
            int novoestoque = produto.getEstoque() - item.getQuantidade();
            if (novoestoque < 0) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }
            produto.setEstoque(novoestoque);
            produtoRepository.save(produto);

            //Soma total
            total = total.add(subtotal);
        }

        venda.setTotal(total);
        venda.setData_venda(LocalDate.now());

        return vendaRepository.save(venda);
    }
    public List<Venda> listarTodas(){
        return vendaRepository.findAll();
    }
    public Venda buscarPorId(Long id){
        return vendaRepository.findById(id).orElseThrow(()-> new RuntimeException("Venda não encontrada"));
    }
    public void remover(Long id){
        vendaRepository.deleteById(id);
    }
    
}
