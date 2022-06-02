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

import com.spring.sistemaescola.models.Curso;
import com.spring.sistemaescola.repository.RepositoryCurso;

@Controller
public class CursoController {
	
	@Autowired
	private RepositoryCurso rc;
	
	// controller do index
	@RequestMapping("/index")
	public String index() {
	return "/index";
}
	
	//cadastrar curso
	
	@RequestMapping(value="/cadastrar-curso", method = RequestMethod.GET)
	public String cadastrarCurso() {
		return "/curso/cadastrar-curso";
	}
	
	@RequestMapping(value="/cadastrar-curso", method = RequestMethod.POST)
	public String cadastrarCurso(Curso curso) {
		rc.save(curso);
		return "redirect:/consultar-curso";
	}
	
	//remover curso
	@RequestMapping ("/removerCurso/{idCurso}")
	public ModelAndView removerCurso(@PathVariable("idCurso") long idCurso) {
		Curso curso = rc.findByidCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/excluir-curso");
		mv.addObject("curso", curso);
		return mv;
	}
	
	@RequestMapping("/deletarCurso")
	public String deletarCurso(long idCurso){
		Curso curso = rc.findByidCurso(idCurso);
		rc.delete(curso);
		return "redirect:/consultar-curso";
	}
	
	// atualizar curso
	
	@RequestMapping (value="/atualizarCurso/{idCurso}", method=RequestMethod.GET)
	public ModelAndView atualizarCurso(@PathVariable("idCurso") long idCurso) {
		Curso curso = rc.findByidCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/atualizar-curso");
		mv.addObject("curso", curso);
		return mv;
	}
	
	@RequestMapping(value="/atualizarCurso/{idCurso}", method=RequestMethod.POST)
	public String alterarCurso(@Validated Curso curso, BindingResult result, RedirectAttributes attributes) {
		rc.save(curso);
		return "redirect:/consultar-curso";		
	}
	
	// listar curso
	
	@RequestMapping("/consultar-curso")
	public ModelAndView listarCurso() {
		ModelAndView mv = new ModelAndView("/curso/consultar-curso");
		Iterable<Curso> cursos = rc.findAll();
		mv.addObject("cursos", cursos);
		return mv;
	
	}
	

}
