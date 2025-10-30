package br.univille.poo2.jogadores.controller;

import br.univille.poo2.jogadores.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jogadores2")
public class JogadorDinamicoController {

    private final JogadorService jogadorService;

    public JogadorDinamicoController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("lista");
        var lista = jogadorService.findAll();
        mv.addObject("jogadores", lista);
        return mv;
    }

    @GetMapping("/aleatorio")
    public ModelAndView aleatorio() {
        var optional = jogadorService.obterUmJogadorAleatoriamente();

        if (optional.isEmpty()) {
            return new ModelAndView("jogador/nao_ha_jogador");
        }

        var mv = new ModelAndView("jogador/jogador_aleatorio");
        mv.addObject("jogador", optional.get());
        return mv;
    }
}
