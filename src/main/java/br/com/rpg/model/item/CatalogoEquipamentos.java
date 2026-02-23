package br.com.rpg.model.item;

import br.com.rpg.exceptions.EquipamentoNaoEncontradoException;
import br.com.rpg.model.enums.TipoEquipamento;

import java.util.HashMap;
import java.util.Map;

public final class CatalogoEquipamentos {
    private static final Map<String, Equipamentos> mapaEquipamentos = new HashMap<>();

    static{
        iniciarCatalogoEqp();
    }

    public static void iniciarCatalogoEqp() {
        mapaEquipamentos.put("ARMADURA DE COURO", new Equipamentos(
                "Armadura de couro",
                "Armadura leve feita de couro",
                1,
                TipoEquipamento.ARMARUDA,
                0,
                0,
                0,
                5.0,
                0.0,
                10.0));
        mapaEquipamentos.put("ARMADURA COMPLETA", new Equipamentos(
                "Armadura Completa",
                "Armadura pesada que com muita defesa",
                10,
                TipoEquipamento.ARMARUDA,
                0,
                0,
                0,
                15.0,
                0.0,
                -5.0));
        mapaEquipamentos.put("ESPADA CURTA", new Equipamentos(
                "Espada Curta",
                "Espada simples",
                1,
                TipoEquipamento.MAO_PRINCIPAL,
                0,
                5,
                0,
                0.0,
                0.0,
                0.0));
        mapaEquipamentos.put("MACHADO GRANDE", new Equipamentos(
                "Machado Grande",
                "Poderoso Machado com alto dano, reduz a esquiva",
                10,
                TipoEquipamento.MAO_PRINCIPAL,
                0,
                25,
                0,
                0.0,
                0.0,
                -10.0));
        mapaEquipamentos.put("ESCUDO DE APARAR", new Equipamentos(
                "Escudo de Aparar",
                "Pequeno escudo usado para aparar golpe. Aumenta um pouco da armadura e esquiva",
                5,
                TipoEquipamento.MAO_SEGUNDARIA,
                0,
                0,
                0,
                5.0,
                0.0,
                7.5));
        mapaEquipamentos.put("ESCUDO GRANDE", new Equipamentos(
                "Escudo Grande",
                "Escudo grande o suficiente para bloquear todos os tipos de golpe. Reduz a esquiva",
                5,
                TipoEquipamento.MAO_SEGUNDARIA,
                0,
                0,
                0,
                25.0,
                0.0,
                -5.0));
        mapaEquipamentos.put("MANTO DA SAÚDE", new Equipamentos(
                "Manto da Saúde",
                "Esse manto foi imbuído em poções de cura!",
                50,
                TipoEquipamento.CAPA,
                100,
                0,
                20,
                0.0,
                0.0,
                0.0));
        mapaEquipamentos.put("CAPA ELUSIVA", new Equipamentos(
                "Capa elusiva",
                "Quando equipado, deixa o usuário praticamente invisível, mas ao custo sua vida",
                250,
                TipoEquipamento.CAPA,
                -50,
                0,
                0,
                0.0,
                0.0,
                50.0));
    }

    public static Equipamentos enviarEquipamento(String chave){
        Equipamentos novoEquipamento = mapaEquipamentos.get(chave);
        if(novoEquipamento == null){
            throw new EquipamentoNaoEncontradoException(chave);
        }
        return novoEquipamento;
    }
}
