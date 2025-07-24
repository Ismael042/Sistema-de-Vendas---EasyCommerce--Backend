package com.ismael.easycommerce.repository;

import com.ismael.easycommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    Cliente findByCpf (String cpf);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
