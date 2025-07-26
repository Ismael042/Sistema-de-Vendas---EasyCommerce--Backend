package com.ismael.easycommerce.controller;
import com.ismael.easycommerce.model.Cliente;
import com.ismael.easycommerce.repository.ClienteRepository;
import com.ismael.easycommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    private ResponseEntity<Cliente> Salvar(@RequestBody Cliente cliente){
        Cliente salvo = clienteService.salvar(cliente);
        return ResponseEntity.status(201).body(salvo);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletarPorID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    private List<Cliente> listarTodos(){
        return clienteService.listarTodos();
    }

    @GetMapping("/{nome}")
    private List<Cliente> listarPorNome(@PathVariable String nome){
        return clienteService.buscarPorNome(nome);
    }

    @GetMapping("/cpf/{cpf}")
    private List<Cliente> listarPorCpf(@PathVariable String cpf){
        return clienteService.buscarPorCpf(cpf);
    }

    @PutMapping("{id}")
    private ResponseEntity<Cliente> atualizarPorId(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteatualizado = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteatualizado);
    }
    
}
