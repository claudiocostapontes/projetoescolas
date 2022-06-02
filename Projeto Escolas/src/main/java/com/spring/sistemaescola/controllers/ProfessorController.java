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

import com.spring.sistemaescola.models.Professor;
import com.spring.sistemaescola.repository.RepositoryProfessor;

@Controller
public class ProfessorController {
	
	@Autowired
	private RepositoryProfessor rp;
	
	// cadastrar professor
	
	@RequestMapping(value="/cadastrar-professor", method = RequestMethod.GET)
	public String cadastrarProfessor(Model model) {
		model.addAttribute("varNomeGenero", "generoProfessor");
		return "/professor/cadastrar-professor";
	}
	
	@RequestMapping(value="/cadastrar-professor", method = RequestMethod.POST)
	public String cadastrarProfessor(Professor professor) {
		rp.save(professor);
		return "redirect:/consultar-professor";
		
	}
	
	// remover professor
	
	@RequestMapping ("/removerProfessor/{matriculaProfessor}")
	public ModelAndView  removerProfessor(@PathVariable("matriculaProfessor") long matriculaProfessor) {
		Professor professor = rp.findBymatriculaProfessor(matriculaProfessor);
		ModelAndView mv = new ModelAndView("/professor/excluir-professor");
		mv.addObject("professor", professor);
		return mv;
	}
	
	@RequestMapping("/deletarProfessor")
	public String deletarProfessor(long matriculaProfessor){
		Professor professor = rp.findBymatriculaProfessor(matriculaProfessor);
		rp.delete(professor);
		return "redirect:/consultar-professor";
	}
	
	// atualizar professor
	
	@RequestMapping (value="/atualizarProfessor/{matriculaProfessor}", method=RequestMethod.GET)
	public ModelAndView atualizarProfessor(@PathVariable("matriculaProfessor") long matriculaProfessor) {
		Professor professor = rp.findBymatriculaProfessor(matriculaProfessor);
		ModelAndView mv = new ModelAndView("/professor/atualizar-professor");
		mv.addObject("professor", professor);
		mv.addObject("varNomeGenero", "generoProfessor");
		mv.addObject("valorGenero", professor.getGeneroProfessor());		
		return mv;
	}
	
	@RequestMapping(value="/atualizarProfessor/{matriculaProfessor}", method=RequestMethod.POST)
	public String alterarProfessor(@Validated Professor professor, BindingResult result, RedirectAttributes attributes) {
		rp.save(professor);
		return "redirect:/consultar-professor";
		
	}	
	
	// listar professor
	@RequestMapping("/consultar-professor")
	public ModelAndView listarProfessor() {
		ModelAndView mv = new ModelAndView("/professor/consultar-professor");
		Iterable<Professor> professores = rp.findAll();
		mv.addObject("professores", professores);
		return mv;
	
	}
	
}
