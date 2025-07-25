package com.ismael.easycommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//id, id_cliente, data_venda, total

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private LocalDate data_venda; // Pega somente a data sem a hora
    private BigDecimal total;

    @OneToMany(mappedBy = "venda" , cascade = CascadeType.ALL)
    private List<ItemVenda> itens = new ArrayList<>();

    //Getters e Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public LocalDate getData_venda() {
        return data_venda;
    }
    public void setData_venda(LocalDate data_venda) {
        this.data_venda = data_venda;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public List<ItemVenda> getItens() {
        return itens;
    }
    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

}
