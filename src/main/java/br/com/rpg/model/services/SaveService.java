package br.com.rpg.model.services;

import br.com.rpg.dao.ProgressoSaveDAO;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.habilidade.Habilidade;
import br.com.rpg.model.save.ProgressoSaveDTO;

import java.util.ArrayList;
import java.util.List;

public class SaveService {
    private final ProgressoSaveDAO saveDAO = new ProgressoSaveDAO();

    public SaveService() {}

    public void salvarJogo(Heroi jogador) {
        List<String> chaveHabilidades = new ArrayList<>();
        for (Habilidade habAtual : jogador.getMenuHabilidades()) {
            chaveHabilidades.add(habAtual.chaveID());
        }
        saveDAO.salvarProgresso(new ProgressoSaveDTO(
                jogador.getNome(),
                jogador.getVidaMaxima(),
                jogador.getDano(),
                jogador.getManaMaxima(),
                jogador.getDefesa(),
                jogador.getChanceCrit(),
                jogador.getChanceEsq(),
                chaveHabilidades
        ));
    }

    /**
     * Cria um novo {@link Heroi} a partir de um save existente (se existir).
     * @param jogador Heroi que será criado.
     */
    public Heroi carregarJogo() {
        ProgressoSaveDTO saveDTO = saveDAO.carregarProgresso();
        if (saveDTO == null) { // Quando o jogador não tem save (novo jogo ou corrompeu).
            return null;
        }
        return new Heroi(
                saveDTO.nomeHeroi(),
                saveDTO.vidaMaxima(),
                saveDTO.dano(),
                saveDTO.manaMaxima(),
                saveDTO.defesa(),
                saveDTO.chanceCrit(),
                saveDTO.chanceEsq(),
                saveDTO.chaveHabilidades()
        );
    }
}
