package br.com.fiap.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.model.GameModel;
import br.com.fiap.repository.GameRepository;

@Controller
@RequestMapping("/")
public class GameController {
	
	GameRepository repository = GameRepository.getInstance();
	
	@GetMapping("{page}")
	public String redirect(@PathVariable("page") String page,
						   @RequestParam(required = false) Long id,
						   Model model) {
		
		System.out.println("Page:" + page);
		
		if(
		   "about".equals(page) || 
		   "edit".equals(page)
		  ) {
			
			GameModel game = repository.findByID(id);
			model.addAttribute("game", game);
		}
		else if("home".equals(page)) {
			List<GameModel> games = repository.findAll();
			model.addAttribute("games", games);
		}
		
		return page;
		// Adicionar ModelAttribute para validação
	}

	@PostMapping()
	public String create(GameModel game) {
		repository.create(game);
		return "redirect:/home";
		// Criar validações
		// Criar mensagem de validação
	}
	
	@PutMapping()
	public String update(GameModel game) {
		repository.update(game);
		return "redirect:/home";
		// Criar validações
		// Criar mensagem de validação
		// Perguntar para o professor se realmente precisa do "@PathVariable("id") long id"
	}

	@DeleteMapping("{id}")
	public String deleteByID(@PathVariable("id") long id){
		repository.deleteByID(id);
		return "redirect:/home";
		// Criar mensagem de validação
	}

}
