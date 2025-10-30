package br.univille.poo2.jogadores.controller;

import br.univille.poo2.jogadores.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private final JogadorService jogadorService;

    public HomeController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/gerar-jogadores")
    public ModelAndView criarJogadorAutomaticamente() {
        jogadorService.adicionarJogadores();
        return new ModelAndView("redirect:/jogadores");
    }

    @GetMapping("/deletar-jogadores")
    public ModelAndView deletarJogadores() {
        jogadorService.deletarTudo();
        return new ModelAndView("redirect:/jogadores");
    }


}
