package ufc.si.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.si.dao.SecaoDAO;
import ufc.si.model.Secao;

@Controller
public class SecaoController {
	
	private SecaoDAO secaoDao;
	@Autowired
	public SecaoController(SecaoDAO secaoDao) {
		this.secaoDao = secaoDao;
	}
	
	@RequestMapping("todasSecoes")
	public String buscarTodasSecao(Secao secao, Model model){
		
		List<Secao> secoes = this.secaoDao.getLista();
		model.addAttribute("secoes", secoes);
		return "";
	}
}
