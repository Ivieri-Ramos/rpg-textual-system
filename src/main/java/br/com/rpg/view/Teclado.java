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
     * Valida o nome do jogador dentre dos limites permitidos.
     * @return Um nome válido para o {@link br.com.rpg.model.entities.heroi.Heroi Heroi} do jogador.
     */
    public String lerNomeJogador() {
        String nome = "";
        boolean nomeValido = false;

        while (!nomeValido) {
            System.out.print("> Digite o nome do seu Herói: ");
            nome = teclado.nextLine().trim();
            // Apertou enter
            if (nome.isEmpty()) {
                System.out.println("O nome não pode estar vazio. Tente novamente!\n");
                continue;
            }
            // Não pode conter espaços
            if (nome.contains(" ")) {
                System.out.println("Só pode ser uma palavra. Tente novamente!\n");
                continue;
            }
            // Só aceita letras normais e acentos.
            if (!nome.matches("^[a-zA-ZÀ-ÿ]+$")) {
                System.out.println("O nome deve conter apenas letras normais ou acentos. Tente novamente!\n");
                continue;
            }
            // Verifica se é um nome grande.
            if (nome.length() < 2 || nome.length() > 12) {
                System.out.println("O nome deve ser curto, entre 2 e 12 letras. Tente novamente!\n");
                continue;
            }

            // Se chegou aqui, é um nome válido.
            nomeValido = true;
        }

        // Deixa a primeira maiúscula e o resto minúscula.
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
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