package br.com.rpg.dao;

import br.com.rpg.model.save.ProgressoSaveDTO;

public interface ISerializarArquivos {
    void salvarProgresso(ProgressoSaveDTO dados);
    ProgressoSaveDTO carregarProgresso();
}
