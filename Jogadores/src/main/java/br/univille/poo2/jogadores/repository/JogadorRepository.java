package br.univille.poo2.jogadores.repository;

import br.univille.poo2.jogadores.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
