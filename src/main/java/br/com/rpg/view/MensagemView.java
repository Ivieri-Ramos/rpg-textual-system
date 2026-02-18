package br.com.rpg.view;

/**
 * Possui métodos que imprimem mensagens de aviso para o usuário,
 * possuindo cores diferentes a depender do tipo de aviso.
 */
public class MensagemView {
    // Constantes que mudam a cor do texto, servem apenas para imprimir mensagens de feedback.
    private static final String RESET = "\u001B[0m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String AMARELO = "\u001B[33m";
    private static final String VERDE = "\u001B[32m";

    /**
     * Mostra uma mensagem em <span style="color: red;">vermelho</span>.
     * <p>
     * Usada quando o jogador realiza uma operação inválida, como usar
     * uma {@code habilidade} sem ter {@code mana}.
     * @param mensagem Aviso a ser impresso.
     */
    public void mostrarMensagemErro(String mensagem){
        System.out.println();
        System.out.println(VERMELHO + "ERRO: " + mensagem + RESET);
        aguardarLer();
    }

    /**
     * Mostra uma mensagem em <span style="color: yellow;">amarelo</span>.
     * <p>
     * Usada quando o jogador realiza uma operação perigosa.
     * @param mensagem Aviso a ser impresso.
     */
    public void mostrarMensagemAviso(String mensagem){
        System.out.println();
        System.out.println(AMARELO + "AVISO: " + mensagem + RESET);
        aguardarLer();
    }

    /**
     * Mostra uma mensagem em <span style="color: green;">verde</span>.
     * <p>
     * Usada quando o jogador realiza uma operação bem-sucedida.
     * @param mensagem Aviso a ser impresso.
     */
    public void mostrarMensagemSucesso(String mensagem){
        System.out.println();
        System.out.println(VERDE + "SUCESSO: " + mensagem + RESET);
        aguardarLer();
    }

    /**
     * Serve apenas para parar o programa por alguns segundos.
     */
    private void aguardarLer(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
