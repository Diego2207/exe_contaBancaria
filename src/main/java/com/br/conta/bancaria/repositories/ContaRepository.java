package com.br.conta.bancaria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.conta.bancaria.models.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer>{

}
