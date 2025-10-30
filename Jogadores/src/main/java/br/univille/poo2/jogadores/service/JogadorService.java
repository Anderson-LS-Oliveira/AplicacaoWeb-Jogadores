package br.univille.poo2.jogadores.service;

import br.univille.poo2.jogadores.entity.Jogador;
import br.univille.poo2.jogadores.repository.JogadorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @PostConstruct
    public void inicializarBanco() {
        if (jogadorRepository.count() == 0) {
            adicionarJogadores();
        }
    }

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public void adicionarJogadores() {
        var j1 = new Jogador();
        j1.setNome("Lionel Messi");
        j1.setPais("Argentina");
        j1.setTime("Inter Miami");
        j1.setIdade(37);
        j1.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Lionel-Messi-Argentina-2022-FIFA-World-Cup_sharpness.jpg/250px-Lionel-Messi-Argentina-2022-FIFA-World-Cup_sharpness.jpg");
        jogadorRepository.save(j1);

        var j2 = new Jogador();
        j2.setNome("Cristiano Ronaldo");
        j2.setPais("Portugal");
        j2.setTime("Al-Nassr");
        j2.setIdade(40);
        j2.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Cristiano_Ronaldo_playing_for_Al_Nassr_FC_against_Persepolis%2C_September_2023_%28cropped%29.jpg/250px-Cristiano_Ronaldo_playing_for_Al_Nassr_FC_against_Persepolis%2C_September_2023_%28cropped%29.jpg");
        jogadorRepository.save(j2);

        var j3 = new Jogador();
        j3.setNome("Neymar Jr");
        j3.setPais("Brasil");
        j3.setTime("Al-Hilal");
        j3.setIdade(33);
        j3.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Neymar_Jr._with_Al_Hilal%2C_3_October_2023_-_03_%28cropped%29.jpg/250px-Neymar_Jr._with_Al_Hilal%2C_3_October_2023_-_03_%28cropped%29.jpg");
        jogadorRepository.save(j3);

        var j4 = new Jogador();
        j4.setNome("Kylian Mbappé");
        j4.setPais("França");
        j4.setTime("Real Madrid");
        j4.setIdade(27);
        j4.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Picture_with_Mbapp%C3%A9_%28cropped%29_%28cropped%29.jpg/250px-Picture_with_Mbapp%C3%A9_%28cropped%29_%28cropped%29.jpg");
        jogadorRepository.save(j4);

        var j5 = new Jogador();
        j5.setNome("Kevin De Bruyne");
        j5.setPais("Bélgica");
        j5.setTime("Manchester City");
        j5.setIdade(34);
        j5.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Kevin_De_Bruyne-December_2021.png/250px-Kevin_De_Bruyne-December_2021.png");
        jogadorRepository.save(j5);

        var j6 = new Jogador();
        j6.setNome("Vinícius Jr");
        j6.setPais("Brasil");
        j6.setTime("Real Madrid");
        j6.setIdade(25);
        j6.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/2025_04_26_Final_de_la_Copa_del_Rey_-_Vin%C3%ADcius_J%C3%BAnior.jpg/250px-2025_04_26_Final_de_la_Copa_del_Rey_-_Vin%C3%ADcius_J%C3%BAnior.jpg");
        jogadorRepository.save(j6);

        var j7 = new Jogador();
        j7.setNome("Erling Haaland");
        j7.setPais("Noruega");
        j7.setTime("Manchester City");
        j7.setIdade(25);
        j7.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Norway_Italy_-_June_2025_E_07.jpg/250px-Norway_Italy_-_June_2025_E_07.jpg");
        jogadorRepository.save(j7);

        var j8 = new Jogador();
        j8.setNome("Luka Modrić");
        j8.setPais("Croácia");
        j8.setTime("Real Madrid");
        j8.setIdade(39);
        j8.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Luka_Modric_Interview_2021_%28cropped%29.jpg/250px-Luka_Modric_Interview_2021_%28cropped%29.jpg");
        jogadorRepository.save(j8);

        var j9 = new Jogador();
        j9.setNome("Mohamed Salah");
        j9.setPais("Egito");
        j9.setTime("Liverpool");
        j9.setIdade(33);
        j9.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Mohamed_Salah_2021_CAN_Final.jpg/250px-Mohamed_Salah_2021_CAN_Final.jpg");
        jogadorRepository.save(j9);

        var j10 = new Jogador();
        j10.setNome("Robert Lewandowski");
        j10.setPais("Polônia");
        j10.setTime("Barcelona");
        j10.setIdade(36);
        j10.setFotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Robert_Lewandoski%2C_jugador_del_FCBarcelona_durant_la_gira_de_pretemporada_a_EUA._%2805-08-2024%29_%28cropped%29.jpg/250px-Robert_Lewandoski%2C_jugador_del_FCBarcelona_durant_la_gira_de_pretemporada_a_EUA._%2805-08-2024%29_%28cropped%29.jpg");
        jogadorRepository.save(j10);

    }

    public void deletarTudo(){
        jogadorRepository.deleteAll();
    }

    public Optional<Jogador> obterUmJogadorAleatoriamente() {
        var lista = findAll();
        if(lista.isEmpty()){ return Optional.empty();}
        return Optional.ofNullable(lista.get((int) (Math.random() * lista.size())));
    }
}
