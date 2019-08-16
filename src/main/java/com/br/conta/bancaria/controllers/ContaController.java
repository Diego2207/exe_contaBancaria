package com.br.conta.bancaria.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.conta.bancaria.models.Cliente;
import com.br.conta.bancaria.models.Conta;
import com.br.conta.bancaria.service.ContaService;

@Controller
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@GetMapping("/")
	public ModelAndView mapeiaHome() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		return modelAndView;
	}

	@GetMapping("/novaConta")
	public ModelAndView novaConta() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}

	@PostMapping("/novaConta")
	public ModelAndView salvarConta(@Valid Conta conta, BindingResult binResultConta, @Valid Cliente cliente,
			BindingResult binResultCliente) {

		ModelAndView modelAndView = new ModelAndView("novaConta.html");

		List<String> erros = new ArrayList<String>();

		if (binResultConta.hasErrors() || binResultCliente.hasErrors()) {

			for (ObjectError objErros : binResultCliente.getAllErrors()) {
				erros.add(objErros.getDefaultMessage());
				modelAndView.addObject("erros", erros);
			}

			for (ObjectError objErros : binResultConta.getAllErrors()) {
				erros.add(objErros.getDefaultMessage());
				modelAndView.addObject("erros", erros);
			}

		} else {
			modelAndView.addObject("mensagens", contaService.salvarConta(cliente, conta));

		}

		return modelAndView;
	}

	@GetMapping("/contas")
	public ModelAndView exibirContas() {
		ModelAndView modelAndView = new ModelAndView("contas.html");
		modelAndView.addObject("contas", contaService.exibirTodasContas());
		return modelAndView;
		

	}
}
