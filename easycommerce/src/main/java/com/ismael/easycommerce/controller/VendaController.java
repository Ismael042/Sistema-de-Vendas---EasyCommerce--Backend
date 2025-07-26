package com.ismael.easycommerce.controller;

import com.ismael.easycommerce.model.Venda;
import com.ismael.easycommerce.repository.VendaRepository;
import com.ismael.easycommerce.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @Autowired
    VendaRepository vendaRepository;

    @PostMapping
    private ResponseEntity<Venda> salvar(@RequestBody Venda venda){
        Venda vendasalva = vendaService.salvar(venda);
        return ResponseEntity.status(201).body(vendasalva);
    }
    @GetMapping
    private ResponseEntity<List<Venda>> listarVendas(){
        return ResponseEntity.ok(vendaService.listarTodas());  
    }
}
