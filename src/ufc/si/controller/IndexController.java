package ufc.si.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.si.dao.SecaoDAO;
import ufc.si.model.Secao;

@Controller
public class IndexController {
	
	private SecaoDAO secaoDao;
	@Autowired
	public IndexController(SecaoDAO secaoDao) {
		this.secaoDao = secaoDao;
	}

	@RequestMapping("/")
	public String execute(Model model) {
		System.out.println("INDEX CONTROLLER");
		//lista todas as secoes
		List<Secao> secoes = this.secaoDao.getLista();
		model.addAttribute("secoes", secoes);
		return "index";
	}

	@RequestMapping("home")
	public String home() {
		return "redirect:/";
	}

}
