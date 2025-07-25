package com.ismael.easycommerce.model;

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

}
