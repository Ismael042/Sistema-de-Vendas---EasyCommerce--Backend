package com.ismael.easycommerce.service;

import com.ismael.easycommerce.model.Cliente;
import com.ismael.easycommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//id,nome,email,cpf,telefone

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(Cliente cliente){
        return clienteRepository.findAll();
    }

    public List<Cliente> buscarPorNome(String nome){
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Cliente buscarPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
    public Cliente atualizarCliente(Long id, Cliente dadosatualizados){

        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteExistente.setNome(dadosatualizados.getNome());
        clienteExistente.setCpf(dadosatualizados.getCpf());
        clienteExistente.setEmail(dadosatualizados.getEmail());
        clienteExistente.setTelefone(dadosatualizados.getTelefone());

        return clienteRepository.save(clienteExistente);
    }
}
