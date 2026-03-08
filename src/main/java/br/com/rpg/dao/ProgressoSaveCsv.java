package br.com.rpg.dao;

import br.com.rpg.model.save.ProgressoSaveDTO;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class ProgressoSaveCsv implements ISerializarArquivos {
    private final String NOME_DIRETORIO = "storage";
    private final String NOME_ARQUIVO = NOME_DIRETORIO + "/save.csv";
    private final CsvMapper mapper = new CsvMapper();
    private final CsvSchema schema;

    public ProgressoSaveCsv() {
        schema = mapper.schemaFor(ProgressoSaveDTO.class)
                .withHeader()
                .withArrayElementSeparator(";");
    }

    /**
     * Salva o progresso de jogo em um arquivo .csv a partir de um DTO contendo
     * as informações do usuário.
     * @param dados Informações que serão salvas.
     */
    @Override
    public void salvarProgresso(ProgressoSaveDTO dados) {
        try {
            File diretorio = new File(NOME_DIRETORIO);
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            File arquivo = new File(NOME_ARQUIVO);
            mapper.writer(schema).writeValue(arquivo, dados);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carrega o jogo de um arquivo .csv se existir, ou retorna {@code null}
     * caso não exista.
     * @return informações carregadas do arquivo.
     */
    @Override
    public ProgressoSaveDTO carregarProgresso() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) { // Se o arquivo não existe, é porque é um novo jogo.
            return null;
        }
        try {
            MappingIterator<ProgressoSaveDTO> leitor = mapper.readerFor(ProgressoSaveDTO.class)
                    .with(schema)
                    .readValues(arquivo);
            if (leitor.hasNext()) {
                return leitor.next();
            }
        }
        catch (IOException e) {
            return null;
        }
        return null;
    }
}
