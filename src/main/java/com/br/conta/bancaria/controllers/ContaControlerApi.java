package com.br.conta.bancaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.conta.bancaria.models.Conta;
import com.br.conta.bancaria.service.ContaService;

@RestController
@RequestMapping("/contas/api")
public class ContaControlerApi {
	@Autowired
	private  ContaService contaService;
	
	@GetMapping
	public ResponseEntity pegarContas() {
		if (contaService.totalContas() > 0) {
			return ResponseEntity.ok(contaService.exibirTodasContas());
		}
		return ResponseEntity.noContent().build();

	}
	@PostMapping
	public ResponseEntity<Conta> criarMansagem(@RequestBody Conta conta) {
		contaService.salvarContaApi(conta);
		return ResponseEntity.status(HttpStatus.CREATED).body(conta);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Conta> atualizarMensagem(@PathVariable int id, @RequestBody Conta conta) {
		contaService.atualizarContaApi(id, conta);

		return ResponseEntity.ok(conta);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity cancelarConta(@PathVariable int id) {
		contaService.cancelarContaApi(id);
		return ResponseEntity.ok().build();

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> pegarContaId(@PathVariable int id) {
		Conta conta = contaService.pegarContaPeloId(id);
		if (conta== null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(conta);
		}
	}
}
