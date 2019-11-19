package br.edu.ifal.desformulado;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador{

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
        return retorno ;
    }


}