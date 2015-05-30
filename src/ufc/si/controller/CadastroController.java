package ufc.si.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ufc.si.dao.PapeisDosUsuariosDAO;
import ufc.si.dao.UsuarioDAO;
import ufc.si.model.Usuario;

@Controller
public class CadastroController {
	
	private UsuarioDAO usuarioDao;
	private PapeisDosUsuariosDAO papeisDosUsuarioDao;
	
	@Autowired
	public CadastroController(UsuarioDAO usuarioDao, PapeisDosUsuariosDAO papeisDosUsuarios) {
		this.usuarioDao = usuarioDao;
		this.papeisDosUsuarioDao = papeisDosUsuarios;
	}
	
	@RequestMapping("cadastrar")
	public String cadastrar(Model model){		
		return "cadastro";
	}
	
	@RequestMapping("inserirCadastro")
	public String inserirCadastro(Usuario usuario){
		this.usuarioDao.adicionar(usuario);
		
		System.out.println(usuario.getNome());
		this.papeisDosUsuarioDao.adicionar(1, usuario.getLogin());
		
		return "redirect:/";
	}
	
}
