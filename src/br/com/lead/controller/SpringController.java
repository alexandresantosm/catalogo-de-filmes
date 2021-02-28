package br.com.lead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

	@RequestMapping(value = "/adicionarFilme", method = RequestMethod.GET)
	@ResponseBody
	public String adicionarFilme(String nome, String genero, Integer ano) {
		String resposta = String.format("Nome: %s<br>Gênero: %s<br>Ano: %s", nome, genero, ano);
		
		return resposta;
	}
}
