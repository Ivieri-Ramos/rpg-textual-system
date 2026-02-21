# 📋 RESUMO EXECUTIVO - RPG TEXTUAL SYSTEM

## ✅ INFORMAÇÕES DOCUMENTADAS

### 1️⃣ **INTEGRANTES, TEMA E ESCOPO**

#### 👥 Integrantes
- **Autor Principal:** Ivieri
- **Responsável:** Professor 
- **Versão:** 1.0-SNAPSHOT

#### 🎮 Tema
**"Sistema de Batalhas RPG Textual"** - Motor de batalhas por turnos com interface textual, inspirado em RPGs clássicos (Final Fantasy, Dragon Quest, Pokémon).

#### 🎯 Escopo Principal
- ✅ Sistema de personagens (Heroi, Inimigo)
- ✅ Sistema de classes (2 heróis, 7 inimigos)
- ✅ Batalhas por turnos alternados
- ✅ Cálculo de dano com crítico, esquiva, defesa
- ✅ Sistema de habilidades e mana
- ✅ IA básica para inimigos
- ✅ Interface textual em português

#### 🔄 Escopo Futuro
- 🔄 Sistema de itens e loja
- 🔄 Ações adicionais (defender, fugir)
- 🔄 Efeitos de status (sangramento, queimadura)
- 🔄 IA aprimorada com pesos ponderados
- 🔄 Sistema de progressão (XP, níveis)

---

### 2️⃣ **REQUISITOS E FUNCIONALIDADES PRINCIPAIS**

#### 🎯 Requisitos Funcionais

| # | Requisito | Status |
|---|-----------|--------|
| RF1 | Sistema de criação de personagens | ✅ Implementado |
| RF2 | Batalha por turnos alternados | ✅ Implementado |
| RF3 | Sistema de habilidades aprendidas | ✅ Implementado |
| RF4 | Cálculo de dano com múltiplos fatores | ✅ Implementado |
| RF5 | Sistema de sorte e aleatoriedade | ✅ Implementado |
| RF6 | Interface textual com menus | ✅ Implementado |
| RF7 | Gestão de vida, mana e status | ✅ Implementado |

#### 💎 Funcionalidades Principais

**Sistema de Personagens:**
- 2 Classes de Herói: GUERREIRO (vida/defesa) e MAGO (dano/mana)
- 7 Classes de Inimigo: Minion, Goblin, Orc, Dragão, Troll, Assassino
- Cada classe tem atributos base diferentes

**Sistema de Combate:**
- Turnos alternados (jogador → inimigo)
- Cálculo realista de dano: `(dano × razaoDano) × (1 - defesa%)`
- Crítico: +50% de dano (baseado em chance)
- Esquiva: anula 100% do dano (baseado em chance)
- Batalha termina quando alguém muere

**Sistema de Habilidades:**
- Catálogo centralizado de habilidades
- Cada habilidade tem: nome, custo de mana, multiplicador dano, elemento
- Personagens aprendem habilidades
- Verificação automática de mana disponível

**Interface de Usuário:**
- Menu de opções durante batalha
- Listagem de habilidades disponíveis
- Exibição de resultados de ataque
- Mensagens informativas
- Entrada validada do usuário

---

### 3️⃣ **DIAGRAMA DE CLASSES UML COMPLETO**

#### 📐 Estrutura Principal

```
ENTIDADES BASE
├── Personagem (abstrata)
│   ├── Heroi
│   └── Inimigo
└── Habilidade (record)

ENUMERAÇÕES
├── ClasseHeroi (GUERREIRO, MAGO)
├── ClasseInimigo (7 tipos)
└── TipoElemento (5 elementos)

SERVIÇOS
├── BatalhaService (cálculo de dano)
└── resultados: CalculoDano

CONTROLLERS
├── BatalhaController (fluxo)
└── DTOs: ResultadoAtaque

VIEWS
├── BatalhaView
├── ListagemView
├── MensagemView
├── Teclado
└── ConsoleUtils

UTILIDADES
├── Dado (gerador aleatório)
└── Exceptions
```

#### 🔗 Relacionamentos Principais

```
Personagem
  ↑ extends
  ├── Heroi (controlado por jogador)
  └── Inimigo (controlado por IA)

Personagem → "aprende 0..*" Habilidade
Habilidade → usa TipoElemento

ClasseHeroi → inicializa Heroi
ClasseInimigo → inicializa Inimigo

BatalhaController:
  ├── usa GameFachada
  ├── controla Heroi e Inimigo
  └── interage via BatalhaView, Teclado

GameFachada:
  ├── usa BatalhaService
  └── retorna ResultadoAtaque
```

---

### 📊 **TABELAS DE ATRIBUTOS**

#### Herói - Classes

| Classe | Vida | Dano | Mana | Defesa | Crítico | Esquiva |
|--------|------|------|------|--------|---------|---------|
| **GUERREIRO** | 100 | 15 | 25 | 15% | 5% | 8% |
| **MAGO** | 80 | 20 | 50 | 8% | 5% | 10% |

#### Inimigo - Classes

| Tipo | Vida | Dano | Mana | Defesa | Crítico | Esquiva | Propósito |
|------|------|------|------|--------|---------|---------|-----------|
| MINION_GUERREIRO | 10 | 5 | 0 | 5% | 0% | 10% | Tutorial |
| MINION_MAGO | 8 | 4 | 20 | 3% | 5% | 15% | Tutorial |
| GOBLIN | 30 | 8 | 0 | 5% | 10% | 25% | Ágil |
| ORC | 80 | 15 | 0 | 20% | 5% | 5% | Resistente |
| DRAGAO | 150 | 25 | 50 | 30% | 5% | 5% | Boss |
| TROLL | 15 | 10 | 0 | 80% | 50% | 0% | Defesa |
| ASSASSINO | 25 | 40 | 0 | 10% | 90% | 5% | Crítico |

---

### 🏗️ **ARQUITETURA DO PROJETO**

#### Padrões de Design Utilizados

| Padrão | Classe | Benefício |
|--------|--------|-----------|
| **Facade** | GameFachada | Simplifica acesso à lógica |
| **Service** | BatalhaService | Encapsula cálculos |
| **Enum** | ClasseHeroi/Inimigo | Constantes seguras |
| **Record** | Habilidade, ResultadoAtaque | Dados imutáveis |
| **Abstract** | Personagem, Item | Reutilização de código |
| **MVC** | Controller/View/Model | Separação de responsabilidades |

#### Stack Tecnológico

- **Linguagem:** Java 11+
- **Build:** Gradle 8.14
- **Testes:** JUnit 5.10.0
- **Encoding:** UTF-8
- **Main Class:** `br.com.rpg.Main`

---

### 🎮 **FLUXO DE EXECUÇÃO - EXEMPLO**

```
1. INICIALIZAÇÃO
   └─ Main cria Heroi("Ivieri", GUERREIRO)
   └─ Main cria Inimigo("Goblin", GOBLIN)
   └─ Inicia BatalhaController.iniciarBatalha()

2. LOOP DE BATALHA
   ├─ Enquanto heroi.isVivo() && goblin.isVivo():
   │  ├─ Turno Jogador:
   │  │  ├─ Exibe menu
   │  │  ├─ Recebe escolha
   │  │  └─ Executa ataque via GameFachada
   │  │
   │  └─ Turno Inimigo:
   │     ├─ IA escolhe habilidade
   │     └─ Executa ataque automático

3. CÁLCULO DE DANO (Para cada ataque)
   ├─ Testa esquiva do alvo (chance%)
   ├─ Se não esquivou:
   │  ├─ Calcula: dano × razaoDano × (1 - defesa%)
   │  ├─ Testa crítico atacante (chance%)
   │  └─ Se crítico: dano *= 1.5
   └─ Retorna ResultadoAtaque

4. ENCERRAMENTO
   └─ Quando alguém morre
   └─ Exibe vencedor
```

---

### 📁 **ESTRUTURA DE DIRETÓRIOS**

```
rpg-textual-system/
├── src/main/java/br/com/rpg/
│   ├── Main.java                    [Entry Point]
│   ├── controller/
│   │   └── BatalhaController        [Orquestra batalha]
│   ├── facade/
│   │   └── GameFachada              [Fachada de negócio]
│   ├── model/
│   │   ├── dto/
│   │   │   └── ResultadoAtaque      [Dados de resultado]
│   │   ├── entities/
│   │   │   ├── Personagem           [Classe base]
│   │   │   ├── Heroi                [Herói do jogo]
│   │   │   ├── Inimigo              [Adversário IA]
│   │   │   ├── Habilidade
│   │   │   └── CatalogoHabilidades
│   │   ├── enums/
│   │   │   ├── ClasseHeroi
│   │   │   ├── ClasseInimigo
│   │   │   └── TipoElemento
│   │   ├── item/
│   │   │   └── Item
│   │   └── services/
│   │       ├── BatalhaService
│   │       └── results/CalculoDano
│   ├── util/
│   │   └── Dado                     [Aleatório]
│   ├── view/
│   │   ├── BatalhaView
│   │   ├── ListagemView
│   │   ├── MensagemView
│   │   ├── Teclado
│   │   └── utils/ConsoleUtils
│   ├── exceptions/
│   │   └── HabilidadeNaoEncontradaException
│   └── dao/                         [Preparado para futuro]
├── build.gradle.kts
├── gradlew / gradlew.bat
└── ...
```

---

### 🚀 **COMO EXECUTAR**

```bash
# Windows (PowerShell ou CMD)
.\gradlew.bat run

# Linux/Mac
./gradlew run

# Com output UTF-8
./gradlew run -Dfile.encoding=UTF-8
```

---

### 📝 **FUNCIONALIDADES EM TODO (PRÓXIMAS)**

- [ ] Sistema de Defesa (aumentar defesa por turno)
- [ ] Sistema de Itens (consumíveis, equipamento)
- [ ] Efeitos de Status (sangramento, queimadura, atordoamento)
- [ ] IA Inteligente (pesos nas habilidades, agressividade)
- [ ] Sistema de Fuga (com chance baseada em stats)
- [ ] Menu de Informações do Inimigo
- [ ] Sistema de Progressão (XP e níveis)
- [ ] Múltiplas Batalhas e Exploração

---

### ✨ **DIFERENCIAIS DO PROJETO**

✅ Código bem estruturado com padrões de design  
✅ Separação clara de responsabilidades (MVC)  
✅ Uso moderno de Java (Records, Enums)  
✅ Documentação completa em JavaDoc  
✅ Tratamento robusto de entrada do usuário  
✅ Cálculos realistas de dano  
✅ Sistema de aleatoriedade bem implementado  
✅ Extensível para futuras funcionalidades  

---

**📄 Documentação Completa:** [DOCUMENTACAO_PROJETO.md](DOCUMENTACAO_PROJETO.md)

**Última Atualização:** 20 de fevereiro de 2026  
**Versão:** 1.0-SNAPSHOT
