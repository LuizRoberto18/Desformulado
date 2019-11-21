package br.edu.ifal.desformulado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controlador{

    @Autowired
    AlunoRepositorio alunoRepo;
    
    Aluno aluno = new Aluno();

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");   
    }
    
    @RequestMapping("/formulario")
    public ModelAndView form(Aluno a) {
        ModelAndView retorno = new ModelAndView("form.html");
        retorno.addObject("aluno", a);
        return retorno;
    }
    
   
    @RequestMapping("/cadastro")
    public ModelAndView cadastrar(Aluno aluno, RedirectAttributes redirect) {
    	alunoRepo.save(aluno);
    	ModelAndView retorno = new ModelAndView("redirect:/lista");
    	redirect.addFlashAttribute("mensagem", aluno.getNome() + " cadastrado com sucesso");
    	return retorno;
    }
    
    @RequestMapping("/lista")
	public ModelAndView listarAlunos(){
		ModelAndView retorno = new ModelAndView("Lista.html");
		Iterable<Aluno> alunos = alunoRepo.findAll();
		retorno.addObject("alunos", alunos);
		return retorno;
	}
    
}