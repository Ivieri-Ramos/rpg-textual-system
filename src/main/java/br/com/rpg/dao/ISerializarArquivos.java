package br.com.rpg.dao;

import br.com.rpg.model.save.ProgressoSaveDTO;

/**
 * Delimita os métodos padrões para as classes que salvam e carregam arquivos
 * do jogo.
 */
public interface ISerializarArquivos {
    void salvarProgresso(ProgressoSaveDTO dados);
    ProgressoSaveDTO carregarProgresso();
}
