package com.br.conta.bancaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.conta.bancaria.models.Cliente;
import com.br.conta.bancaria.models.Conta;
import com.br.conta.bancaria.repositories.ClienteRepository;
import com.br.conta.bancaria.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Iterable <Conta> exibirTodasContas(){
		return contaRepository.findAll();
	}
	
	public String salvarConta(Cliente cliente, Conta conta) {

		conta.setCliente(cliente);
		contaRepository.save(conta);
		return "Conta criada com sucesso";

	}

	public long totalContas() {
		return contaRepository.count();
	}
	
	public void salvarContaApi(Conta conta) {
		contaRepository.save(conta);
	}
	
	public void atualizarContaApi(int id, Conta conta) {
		
		conta.setId(id);
		contaRepository.save(conta);
	}
	
	public void cancelarContaApi(int id) {
		contaRepository.deleteById(id);
		
	}
	
	public Conta pegarContaPeloId(int id) {
		
		if(contaRepository.existsById(id)) {
			return contaRepository.findById(id).get();
		}
		
		return null;
	}
	
	
	
}
