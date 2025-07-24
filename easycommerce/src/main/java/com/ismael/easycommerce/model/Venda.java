package com.ismael.easycommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

//id, id_cliente, data_venda, total

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_cliente;
    private LocalDate data_venda; // Pega somente a data sem a hora
    private BigDecimal total;

    // Getters e Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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
}
