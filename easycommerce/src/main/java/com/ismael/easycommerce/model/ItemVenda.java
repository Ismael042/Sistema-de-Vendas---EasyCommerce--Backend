package com.ismael.easycommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

//id, id_venda, id_produto, quantidade, subtotal

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;
    private BigDecimal precounitario;
    private BigDecimal subtotal;

    // Getters e Setters


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Venda getVenda() {
        return venda;
    }
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getPrecounitario() {
        return precounitario;
    }
    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
