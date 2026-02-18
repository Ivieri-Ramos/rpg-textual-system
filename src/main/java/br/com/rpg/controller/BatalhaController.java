package br.com.rpg.controller;

import br.com.rpg.facade.GameFachada;
import br.com.rpg.model.dto.ResultadoAtaque;
import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.view.BatalhaView;
import br.com.rpg.view.ListagemView;
import br.com.rpg.view.MensagemView;
import br.com.rpg.view.Teclado;

import java.util.List;

/**
 * Classe responsável no controle do fluxo de batalha.
 * <p>
 * Possui métodos que gerenciam o turno do jogador e do inimigo dentro de
 * {@link BatalhaController#iniciarBatalha(Heroi, Inimigo) iniciarBatalha},
 * recebendo o input do usuário e chamando classes no pacote {@link br.com.rpg.view view}
 */
public class BatalhaController {

    private final GameFachada fachada = new GameFachada();
    private final BatalhaView batalhaView = new BatalhaView();
    private final MensagemView avisoView = new MensagemView();
    private final ListagemView listaView = new ListagemView();
    private final Teclado input = new Teclado();

    /**
     * Contém a lógica de batalha, fica em loop até que alguma entidade morra.
     * <p>
     * Usa métodos auxiliares para controlar as ações do jogador e do oponente.
     * @param jogador Entidade controlada pelo usuário.
     * @param oponente Entidade controlada por um algoritmo.
     */
    public void iniciarBatalha(Heroi jogador, Inimigo oponente) {
        while (jogador.isVivo() && oponente.isVivo()) {
            turnoJogador(jogador, oponente);
            // TODO: Turno do inimigo
            // TODO: Futuramente aplicar efeitos, como sangramento, queimadura, atordoar, etc.
        }
    }

    /**
     * Contém a lógica de processar as ações do jogador durante a batalha.
     * <p>
     * Fica em loop até que o jogador realize uma ação válida, como se defender, atacar, etc.
     * @param jogador Entidade principal, todas as ações dependem dele.
     * @param alvo Necessário apenas quando é atacado e ter suas informações analisadas.
     */
    private void turnoJogador(Heroi jogador, Inimigo alvo) {
        // TODO: Pedir ação do jogador, como defender, fugir, etc.
        while (true) {
            batalhaView.mostrarOpcoesBatalhaJogador();
            int opEscolhida = input.lerInteiro("Selecione alguma opção acima:", 1, 5);
            switch (opEscolhida) {
                case 1 -> {
                    Habilidade habUsar = retornarHabilidade(jogador.getMenuHabilidades(), jogador.getMana());
                    if (habUsar == null) {
                        continue;
                    }
                    ResultadoAtaque imprimir = fachada.personagemAtacar(jogador, alvo,  habUsar);
                    batalhaView.mostrarResultadoAtaque(imprimir);
                }
                case 2 -> {
                    //TODO: Criar estado onde o Personagem possa se defender.
                }
                case 3 -> {
                    //TODO: Criar sistema de itens, onde possua itens de cura, ataque, etc.
                }
                case 4 -> {
                    /*
                    TODO: Criar um menu onde possa ver as informações do inimigo
                        (vida e habilidades aprendidas), mas sem amostrar informações como
                        dano, mana, pois tem que deixar difícil para o jogador, mas certas
                        informações só aparecerem após o primeiro turno.
                    */
                }
                case 5 -> {
                    /*
                    TODO: Criar um sistema que permita o jogador fugir,
                        perdendo a capacidade de ganhar XP, ouro, etc. Mas
                        escapando de certos inimigos, de preferência,
                        calculando em relação a vida do inimigo e a própria (chanceEsq também), para dificultar
                        quando tentasse fugir se tivesse pouca vida.
                     */

                }
            }
            return; // Só chega no return se alguma operação nos cases tenha tido sucesso.
        }
    }

    /**
     * Sintetiza a lógica de pedir uma habilidade do jogador em
     * {@link BatalhaController#turnoJogador(Heroi, Inimigo) turnoJogador}.
     * @param listaHab Acessa as habilidades do jogador.
     * @param mana Mana atual do jogador.
     * @return Uma habilidade do jogador ou {@code null} caso digite 0 para voltar.
     */
    private Habilidade retornarHabilidade(List<Habilidade> listaHab, int mana) {
        int qtdHabilidades = listaHab.size();
        while (true) {
            listaView.mostrarHabilidades(listaHab, mana);
            int usarHabilidade = input.lerInteiro("Selecione qual habilidade usar, ou digite 0 para voltar: ", 0, qtdHabilidades);
            if (usarHabilidade == 0) {
                return null;
            }
            if (listaHab.get(usarHabilidade - 1).custoMana() > mana) { // Se não tiver mana suficiente, cancela o uso da habilidade.
                avisoView.mostrarMensagemErro("Você não possui mana para usar essa habilidade!");
                continue;
            }
            return listaHab.get((usarHabilidade - 1)); // Menos um pois está acessando o índice de um vetor.
        }
    }
}
