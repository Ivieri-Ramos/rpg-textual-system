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
    private int numeroTurnos = 0;

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
            if (!oponente.isVivo()) {
                break;
            }
            turnoInimigo(oponente, jogador);
            // TODO: Futuramente aplicar efeitos, como sangramento, queimadura, atordoar, etc.
            this.numeroTurnos++;
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
        // TODO: Pedir ação do jogador, fugir.
        while (true) {
            batalhaView.mostrarOpcoesBatalhaJogador();
            int opEscolhida = input.lerInteiro("Selecione alguma opção acima:", 1, 6);
            switch (opEscolhida) {
                case 1 -> {
                    Habilidade habUsar = retornarHabilidadeJogador(jogador.getMenuHabilidades(), jogador.getMana());
                    if (habUsar == null) {
                        continue;
                    }
                    ResultadoAtaque imprimir = fachada.personagemAtacar(jogador, alvo,  habUsar);
                    batalhaView.mostrarResultadoAtaque(imprimir);
                }
                case 2 -> {
                    jogador.setDefendendo(true);
                    batalhaView.jogadorDefendeu();
                }
                case 3 -> {
                    //TODO: Criar sistema de itens, onde possua itens de cura, ataque, etc.
                }
                case 4 -> {
                    boolean isPrimeiroTurno = (this.numeroTurnos == 0); // Verifica se é o primeiro tur\no (quando é '0').
                    batalhaView.imprimirInfoInimigo(alvo, isPrimeiroTurno);
                    input.aguardarEnter();
                    continue; // Não consome um turno.
                }
                case 5 -> {
                    batalhaView.mostrarInfoCompletaHeroi(jogador);
                    input.aguardarEnter();
                    continue; // Como não é uma ação de atacar, ou defender, não custa turnos.
                }
                case 6 -> {
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
     * @return Uma habilidade do jogador ou {@code null} caso ele digite 0 para voltar.
     */
    private Habilidade retornarHabilidadeJogador(List<Habilidade> listaHab, int mana) {
        int qtdHabilidades = listaHab.size();
        while (true) {
            listaView.mostrarHabilidades(listaHab, mana);
            int usarHabilidade = input.lerInteiro("Selecione qual habilidade usar, ou digite 0 para voltar: ", 0, qtdHabilidades);
            if (usarHabilidade == 0) { // Se o jogador digitou '0', retorna null para depois voltar para o menu normal.
                return null;
            }
            int indice = usarHabilidade - 1; // Menos um pois está acessando o índice de um vetor.
            if (listaHab.get(indice).custoMana() > mana) { // Se não tiver mana suficiente, cancela o uso da habilidade.
                avisoView.mostrarMensagemErro("Você não possui mana para usar essa habilidade!");
                continue;
            }
            return listaHab.get(indice);
        }
    }

    /**
     * Recebe uma habilidade de {@link Inimigo} e a usa contra {@link Heroi}.
     * <p>
     * Primeiro recebe a habilidade, e depois valida se pode usar, caso sim,
     * chama a {@code fachada} para atualizar as entidades e então imprimir o resultado.
     * @param oponente Entidade atacante.
     * @param alvo Entidade que recebe o ataque.
     */
    private void turnoInimigo(Inimigo oponente, Heroi alvo) {
        Habilidade habUsar = oponente.retornarHabilidade();
        if (habUsar == null) {
            avisoView.mostrarMensagemAviso("O inimigo não possui mana");
            return;
        }
        ResultadoAtaque imprimir = fachada.personagemAtacar(oponente, alvo, habUsar);
        batalhaView.mostrarResultadoAtaque(imprimir);
    }
}
