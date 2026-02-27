package br.com.rpg.dao;

import br.com.rpg.model.save.ProgressoSaveDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class ProgressoSaveDAO {
    private final String NOME_ARQUIVO = "save.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public ProgressoSaveDAO() {
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Salva o progresso atual do jogador, sendo esses os atributos do seu personagem.
     * @param dto Contém as informações a serem escritas no JSON.
     */
    public void salvarProgresso(ProgressoSaveDTO dto) {
        try {
            File arquivo = new File(NOME_ARQUIVO);
            mapper.writeValue(arquivo, dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carrega o progresso do jogador, se não tiver nenhum arquivo, inicia um novo jogo,
     * e se o arquivo estiver corrompido, inicia um novo jogo, do contrário,
     * carrega as informações existentes e escreve no DTO.
     * @return As informações do jogador escritas no JSON ou {@code null} caso o arquivo não exista ou esteja corrompido.
     */
    public ProgressoSaveDTO carregarProgresso() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) { // Se o arquivo não existe, é porque é um novo jogo.
            return null;
        }
        try {
            return mapper.readValue(arquivo, ProgressoSaveDTO.class);
        }
        catch (IOException e) {
            return null;
        }
    }
}
