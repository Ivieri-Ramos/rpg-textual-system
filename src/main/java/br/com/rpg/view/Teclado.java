package br.com.rpg.view;

import java.util.Scanner;

/**
 * Classe responsável pela leitura de dados.
 * <p>
 * Possui métodos estáticos para validação de dados do tipo {@code int},
 * usados em classes do pacote {@link br.com.rpg.controller controller}.
 */
public class Teclado {

    private static final Scanner teclado = new Scanner(System.in);

    /**
     * Método para ler um inteiro no stdin (teclado do jogador).
     * <p>
     * Valida a entrada caso o jogador digite letras ao invés de inteiros.
     * @param mensagem Texto a ser impresso.
     * @return O valor convertido para inteiro escrito pelo jogador.
     */
    public int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String valor = teclado.nextLine();
                return Integer.parseInt(valor);
            }
            catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números inteiros!");
            }
        }
    }

    /**
     * Método que valida se o número escrito pelo jogador está entre o intervalo permitido.
     * <p>
     * Chama o método {@link Teclado#lerInteiro(String)} e então valida se
     * o inteiro retornado está no intervalo.
     * @param mensagem Texto que será impresso em {@link Teclado#lerInteiro(String)}.
     * @param min Menor inteiro que o usuário pode digitar.
     * @param max Maior inteiro que o usuário pode digitar.
     * @return Valor dentro dos limites estabelecidos.
     */
    public int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            int numero = lerInteiro(mensagem);
            if (numero < min || numero > max) {
                continue;
            }
            return numero;
        }
    }

    /**
     * Aguarda o usuário digitar enter, usado quando é uma ação demorada.
     */
    public void aguardarEnter() {
        System.out.print("Digite [ENTER] para continuar: ");
        teclado.nextLine();
    }

    /**
     * Método que fecha o Scanner.
     * <p>
     * <b>Importante:</b> Só deve ser chamada uma única vez
     * no final da execução do programa, para impedir bugs na
     * entrada de dados.
     */
    public void fecharTeclado() {
        teclado.close();
    }
}