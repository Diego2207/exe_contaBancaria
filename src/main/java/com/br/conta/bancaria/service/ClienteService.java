package com.br.conta.bancaria.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.conta.bancaria.models.Cliente;
import com.br.conta.bancaria.repositories.ClienteRepository;

public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Iterable<Cliente> exibirTodos(){
		return clienteRepository.findAll();
	}

}
