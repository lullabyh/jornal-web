package ufc.si.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.si.dao.NoticiaDAO;
import ufc.si.dao.SecaoDAO;
import ufc.si.model.Noticia;
import ufc.si.model.Secao;

@Controller
public class NoticiasController {

	private NoticiaDAO noticiaDao;
	private SecaoDAO secaoDao;

	@Autowired
	public NoticiasController(NoticiaDAO noticiaDao, SecaoDAO secaoDao) {
		this.noticiaDao = noticiaDao;
		this.secaoDao = secaoDao;
	}
	

	@RequestMapping("noticiasDaSecao")
	public String noticiasSecao(Secao secao, Model model) {
		
		//salva o id da secao que veio
		int idSecao = secao.getId();
		List<Noticia> noticias = this.noticiaDao.listaNoticiasSecao(idSecao);
		List<Noticia> ultimasNoticias = this.noticiaDao.ultimasNoticias();

		model.addAttribute("noticias", noticias);
		// retorna a primeira noticia mais recente
		model.addAttribute("primeira", ultimasNoticias.get(0));
		// remove a primeira noticia
		ultimasNoticias.remove(0);
		// retorna a lista todas as noticias
		model.addAttribute("ultimasNoticias", ultimasNoticias);
		// listar secao
		
		List<Secao> secoes = this.secaoDao.getLista();
		// retorna todas as secoes
		model.addAttribute("secoes", secoes);
		
		//pega o objeto secao do banco com o id que veio idSecao
		Secao s = this.secaoDao.getSecao(secao.getId());
		model.addAttribute("secaoAtual", s);
		
		System.out.println("Listar noticias: ok!");
		
		return "noticiasSecao";
	}

	@RequestMapping("lerNoticia")
	public String lerNoticia(Noticia noticia, Model model) {
		
		//pega todo o objeto noticia
		Noticia n = this.noticiaDao.getNoticia(noticia);
		model.addAttribute("noticia", n);
		
		//lista ultimas noticias
		List<Noticia> ultimasNot = this.noticiaDao.ultimasNoticias();
		// retorna a primeira noticia mais recente
		model.addAttribute("ultimasNoticias", ultimasNot);
		
		//variavel para pegar o idSecao da noticia
		int id = n.getIdSecao();
		
		//Pega no banco o objeto secao com o idSecao passado que veio de noticia
		Secao s = this.secaoDao.getSecao(id);
		System.out.println("CONTROLLER + ");
		model.addAttribute("nomeSecao", s);
		
		List<Secao> secoes = this.secaoDao.getLista();
		model.addAttribute("listaDeSecoes", secoes);
		
		return "noticia";
	}
	

}
