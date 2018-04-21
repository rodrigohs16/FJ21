package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		if(result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> listatarefa = dao.lista();
		model.addAttribute("listatarefa", listatarefa);
		return "tarefa/listaTarefas";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa){
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostraTarefa(Long id, Model model){
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("mostraTarefa", dao.buscaPorId(id));
		return "tarefa/mostraTarefa";
	}
	
	@RequestMapping("alteraTarefa")
	public String alteraTarefa(Tarefa tarefa){
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@ResponseBody //Responsavel por deixar atualizar a pagina.	
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id){
		//JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
	}
	
	
}
