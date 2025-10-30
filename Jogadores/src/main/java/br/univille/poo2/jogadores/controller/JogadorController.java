package br.univille.poo2.jogadores.controller;

import br.univille.poo2.jogadores.entity.Jogador;
import br.univille.poo2.jogadores.repository.JogadorRepository;
import br.univille.poo2.jogadores.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;
    private final JogadorRepository jogadorRepository;

    public JogadorController(JogadorService jogadorService, JogadorRepository jogadorRepository) {
        this.jogadorService = jogadorService;
        this.jogadorRepository = jogadorRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("jogadores", jogadorService.findAll());
        return "jogador/lista";
    }

    @GetMapping("/adicionar-jogador")
    public String mostrarFormularioNovoJogador(Model model) {
        model.addAttribute("jogador", new Jogador());
        return "jogador/adicionar"; // caminho correto do template
    }

    @PostMapping("/salvar")
    public String salvarJogador(@ModelAttribute Jogador jogador) {
        jogadorRepository.save(jogador);
        return "redirect:/jogadores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarJogador(@PathVariable Long id) {
        jogadorRepository.deleteById(id);
        return "redirect:/jogadores";
    }

    @GetMapping("/aleatorio")
    public String jogadorAleatorio(Model model) {
        Optional<Jogador> jogador = jogadorService.obterUmJogadorAleatoriamente();
        jogador.ifPresent(value -> model.addAttribute("jogador", value));
        return "jogador/jogador_aleatorio";
    }

    @GetMapping("/editar/{id}")
    public String editarJogador(@PathVariable Long id, Model model) {
        Jogador jogador = jogadorRepository.findById(id).orElseThrow();
        model.addAttribute("jogador", jogador);
        return "jogador/editar_jogador";
    }

    @PostMapping("/salvar-edicao/{id}")
    public String salvarEdicao(@PathVariable Long id, @ModelAttribute Jogador jogadorAtualizado) {
        jogadorRepository.save(jogadorAtualizado);
        return "redirect:/jogadores";
    }
}
