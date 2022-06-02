package com.spring.sistemaescola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.spring.sistemaescola.models.Pauta;
import com.spring.sistemaescola.repository.RepositoryPauta;

@Controller
public class PautaController {
	
	@Autowired
	RepositoryPauta rp;
	
	//cadastrar pauta
	
	@RequestMapping(value="cadastrar-pauta", method = RequestMethod.GET)
	public String cadastrarPauta() {
		return "/pauta/cadastrar-pauta";
	}
	
	@RequestMapping(value="cadastrar-pauta", method = RequestMethod.POST)
	public String cadastrarPauta(Pauta codigoTurma, Pauta matriculaAluno) {
		rp.save(codigoTurma);
		rp.save(matriculaAluno);
		return "redirect:/";
		
	}
	
	//remover pauta
	@RequestMapping ("/removerPauta/{codigoPauta}")
	public ModelAndView  removerPauta(@PathVariable("codigoPauta") long codigoPauta) {
		Pauta pauta = rp.findBycodigoPauta(codigoPauta);
		ModelAndView mv = new ModelAndView("/pauta/excluir-pauta");
		mv.addObject("pauta", pauta);
		return mv;
	}
	
	@RequestMapping("/deletarPauta")
	public String deletarPauta(long codigoPauta){
		Pauta pauta = rp.findBycodigoPauta(codigoPauta);
		rp.delete(pauta);
		return "redirect:/";
	}
	
	// atualizar pauta
	
	@RequestMapping (value="/atualizarPauta/{codigoPauta}", method=RequestMethod.GET)
	public ModelAndView atualizarPauta(@PathVariable("codigoPauta") long codigoPauta) {
		Pauta pauta = rp.findBycodigoPauta(codigoPauta);
		ModelAndView mv = new ModelAndView("/pauta/atualizar-pauta");
		mv.addObject("pauta", pauta);
		return mv;
	}
	
	@RequestMapping(value="/atualizarPauta/{codigoPauta}", method=RequestMethod.POST)
	public String alterarPauta(@Validated Pauta pauta, BindingResult result, RedirectAttributes attributes) {
		rp.save(pauta);
		return "redirect:/";
		
	}
	
	// listar pauta
	
	@RequestMapping("/consultar-pauta")
	public ModelAndView listarPauta(long codigoTurma) {
		ModelAndView mv = new ModelAndView("/pauta/consultar-pauta");
		Iterable<Pauta> pautas = rp.findAll();
		mv.addObject("pautas", pautas);
		return mv;
	
	}

}
