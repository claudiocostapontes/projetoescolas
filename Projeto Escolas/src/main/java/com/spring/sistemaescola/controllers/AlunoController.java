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

import com.spring.sistemaescola.models.Aluno;
import com.spring.sistemaescola.repository.RepositoryAluno;

@Controller
public class AlunoController {

	@Autowired
	private RepositoryAluno ra;
	
	// cadastrar aluno
	
	@RequestMapping(value="/cadastrar-aluno", method = RequestMethod.GET)
	public String cadastrarAluno(Model model) {
		model.addAttribute("varNomeGenero", "generoAluno");
		return "/aluno/cadastrar-aluno";
	}
	
	@RequestMapping(value="/cadastrar-aluno", method = RequestMethod.POST)
	public String cadastrarAluno(Aluno aluno) {
		ra.save(aluno);
		return "redirect:/consultar-aluno";
		//return "redirect:/telefoneAluno/cadastrar-telefone-aluno";
	}
	
	// remover aluno
	
	@RequestMapping ("/removerAluno/{matriculaAluno}")
	public ModelAndView  removerAluno(@PathVariable("matriculaAluno") long matriculaAluno) {
		Aluno aluno = ra.findBymatriculaAluno(matriculaAluno);
		ModelAndView mv = new ModelAndView("/aluno/excluir-aluno");
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@RequestMapping("/deletarAluno")
	public String deletarAluno(long matriculaAluno){
		Aluno aluno = ra.findBymatriculaAluno(matriculaAluno);
		ra.delete(aluno);
		return "redirect:/consultar-aluno";
	}
	
	// atualizar aluno
	
	@RequestMapping (value="/atualizarAluno/{matriculaAluno}", method=RequestMethod.GET)
	public ModelAndView atualizarAluno(@PathVariable("matriculaAluno") long matriculaAluno) {
		Aluno aluno = ra.findBymatriculaAluno(matriculaAluno);
		ModelAndView mv = new ModelAndView("/aluno/atualizar-aluno");
		mv.addObject("aluno", aluno);
		mv.addObject("varNomeGenero", "generoAluno");
		mv.addObject("valorGenero", aluno.getGeneroAluno());
		return mv;
	}
	
	@RequestMapping(value="/atualizarAluno/{matriculaAluno}", method=RequestMethod.POST)
	public String alterarAluno(@Validated Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		ra.save(aluno);
		return "redirect:/consultar-aluno";
		
	}	
	
	// listar aluno
	@RequestMapping("/consultar-aluno")
	public ModelAndView listarAluno() {
		ModelAndView mv = new ModelAndView("/aluno/consultar-aluno");
		Iterable<Aluno> alunos = ra.findAll();
		mv.addObject("alunos", alunos);
		return mv;
	
	}
}
