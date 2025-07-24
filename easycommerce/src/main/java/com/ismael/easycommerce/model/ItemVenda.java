package com.ismael.easycommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

//id, id_venda, id_produto, quantidade, subtotal

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long id_venda;
    private long id_produto;
    private Integer quantidade;
    private BigDecimal subtotal;

        // Getters e Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId_venda() {
        return id_venda;
    }
    public void setId_venda(long id_venda) {
        this.id_venda = id_venda;
    }
    public long getId_produto() {
        return id_produto;
    }
    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
