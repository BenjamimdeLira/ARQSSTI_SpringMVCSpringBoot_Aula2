package br.usjt.hellospringboot.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.hellospringboot.model.PrevisaoTempo;
import br.usjt.hellospringboot.service.PrevisoesTempoService;

@Controller
public class PrevisoesTempoController {
	// não faça mais essa injeção
	// @Autowired
	// private AlunosRepository alunosRepo;
	// injete um serviço
	@Autowired
	private PrevisoesTempoService previsoesTempoService;

	@GetMapping("/previsoesTempo")
	public ModelAndView listarPrevisoesTempo() {

		// passe o nome da página ao construtor
		ModelAndView mv = new ModelAndView("lista_previsoesTempo");

		// para modelar o formulário
		mv.addObject(new PrevisaoTempo());

		// Busque a coleção com o service
		List previsoesTempo = previsoesTempoService.listarTodos();

		// adicione a coleção ao objeto ModelAndView
		mv.addObject("previsoesTempo", previsoesTempo);

		// devolva o ModelAndView
		return mv;
	}

	@PostMapping("/alunos")
	public String salvar(PrevisaoTempo previsaoTempo) {
		// salvando com o service
		previsoesTempoService.salvar(previsaoTempo);
		return "redirect:/previsoesTempo";
	}
}