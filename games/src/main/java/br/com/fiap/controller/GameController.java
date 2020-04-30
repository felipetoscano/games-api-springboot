package br.com.fiap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.GameModel;
import br.com.fiap.repository.GameRepository;

@Controller
@RequestMapping("/")
public class GameController {

	GameRepository repository = GameRepository.getInstance();

	@GetMapping("{page}")
	public String redirect(@PathVariable("page") String page, 
						   @RequestParam(required = false) Long id, 
						   @ModelAttribute("gameModel") GameModel gameModel,
						   Model model) {

		if ("about".equals(page) || 
		    "edit".equals(page)) {
			
			GameModel game = repository.findByID(id);
			model.addAttribute("game", game);
			
		} else if ("home".equals(page)) {
			
			List<GameModel> games = repository.findAll();
			model.addAttribute("games", games);
		}

		return page;
	}

	@PostMapping("/new")
	public String create(@Valid GameModel game, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "new";
		}

		repository.create(game);
		redirectAttributes.addFlashAttribute("messages", "Game cadastrado com sucesso!");

		return "redirect:/home";

	}

	@PutMapping("/edit")
	public String update(@Valid GameModel game, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		
		repository.update(game);
		redirectAttributes.addFlashAttribute("messages", "Informações do game alteradas com sucesso!");
		
		return "redirect:/home";
		
	}

	@DeleteMapping("{id}")
	public String deleteByID(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		repository.deleteByID(id);
		redirectAttributes.addFlashAttribute("messages", "Game excluído com sucesso!");
		
		return "redirect:/home";
	}

}
