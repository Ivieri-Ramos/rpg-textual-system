package br.com.rpg.model.mundo;

import java.util.List;

public class MundoBuilder {
    public Cidade gerarCidadePrincipal() {
        // TODO: criar chefes e colocar a chave deles aqui.
        Cidade cidadePrincipal = new Cidade("Capital de Olari", "O centro de todo o reino de Olari");
        Masmorra masmorraFloresta = new Masmorra("Floresta assombrada",
                "Floresta esquecida pelo tempo, dominada por terríveis monstros",
                 5, List.of("GOBLIN_COMUM", "ORC_COMUM"), "CHEFE_AREA");
        Masmorra masmorraCaverna = new Masmorra("Mina abandonada",
                "Mina deixada depois de uma antiga tragédia, agora resta apenas trevas",
                6, List.of("GOBLIN_COMUM", "ORC_COMUM"), "CHEFE_AREA");
        Masmorra masmorraRuinas = new Masmorra("Ruínas esquecidas",
                "Restos de uma antiga civilização, lar de um mal proibido",
                7, List.of("GOBLIN_COMUM", "ORC_COMUM"), "CHEFE_AREA");
        Masmorra masmorraFinal = new Masmorra("Reino de ---",
                "O fim, você será capaz de livrar nosso reino",
                1, null, "CHEFE_AREA");
        // TODO: Adicionar futuramente mais variedades de inimigos
        cidadePrincipal.adicionarMasmorra(masmorraFloresta);
        cidadePrincipal.adicionarMasmorra(masmorraCaverna);
        cidadePrincipal.adicionarMasmorra(masmorraRuinas);
        cidadePrincipal.adicionarMasmorra(masmorraFinal);
        return cidadePrincipal;
    }
}
