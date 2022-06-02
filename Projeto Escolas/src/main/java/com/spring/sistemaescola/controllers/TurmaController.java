package com.spring.sistemaescola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.sistemaescola.models.Curso;
import com.spring.sistemaescola.models.Professor;
import com.spring.sistemaescola.models.Turma;
import com.spring.sistemaescola.repository.RepositoryCurso;
import com.spring.sistemaescola.repository.RepositoryProfessor;
import com.spring.sistemaescola.repository.RepositoryTurma;

@Controller
public class TurmaController {

	@Autowired
	private RepositoryCurso rc;
	
	@Autowired
	private RepositoryProfessor rp;
	
	@Autowired
	private RepositoryTurma rt;

	// cadastrar turma
	@RequestMapping(value="/cadastrar-turma", method = RequestMethod.GET)
	public String cadastrarTurma(Model model) {
		Iterable<Curso> cursos = this.rc.findAll();
		Iterable<Professor> professores = this.rp.findAll();
		model.addAttribute("cursos", cursos);
		model.addAttribute("professor", professores);
		return "/turma/cadastrar-turma";
	}
	
	@RequestMapping(value="/cadastrar-turma", method = RequestMethod.POST)
	public String cadastrarTurma(Turma turma) {
		rt.save(turma);
		return "redirect:/consultar-turma";		
	}
	// remover turma
	
	@RequestMapping ("/removerTurma/{codigoTurma}")
	public ModelAndView removerTurma(@PathVariable("codigoTurma") long codigoTurma) {
		Turma turma = rt.findBycodigoTurma(codigoTurma);
		ModelAndView mv = new ModelAndView("/turma/excluir-turma");
		mv.addObject("turma", turma);
		return mv;
	}
	
	@RequestMapping("/deletarTurma")
	public String deletarTurma(long codigoTurma){
		Turma turma = rt.findBycodigoTurma(codigoTurma);
		rt.delete(turma);
		return "redirect:/consultar-turma";
	}
	// atualizar turma
	
	@RequestMapping (value="/atualizarTurma/{codigoTurma}", method=RequestMethod.GET)
	public ModelAndView atualizarTurma(@PathVariable("codigoTurma") long codigoTurma) {
		Turma turma = rt.findBycodigoTurma(codigoTurma);
		ModelAndView mv = new ModelAndView("/turma/atualizar-turma");
		mv.addObject("turma", turma);
		return mv;
	}
	
	@RequestMapping(value="/atualizarTurma/{codigoTurma}", method=RequestMethod.POST)
	public String alterarTurma(@Validated Turma turma, BindingResult result, RedirectAttributes attributes) {
		rt.save(turma);
		return "redirect:/consultar-turma";
		
	}
	//  listar turma
	
	@RequestMapping("/consultar-turma")
	public ModelAndView listarTurmas() {
		ModelAndView mv = new ModelAndView("/turma/consultar-turma");
		Iterable<Turma> turmas = rt.findAll();
		mv.addObject("turmas", turmas);
		return mv;
	
	}
	
	
	
}
