package com.br.conta.bancaria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.conta.bancaria.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
