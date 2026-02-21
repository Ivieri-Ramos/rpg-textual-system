# Documentação do Projeto - RPG Textual System

## 📋 Sumário Executivo

Este documento apresenta a documentação completa do projeto **RPG Textual System**, um sistema de batalhas por turnos implementado em Java, onde o jogador controla um herói em combate contra adversários em um ambiente textual.

---

## 👥 1. Lista de Integrantes e Metadados do Projeto

### Informações Gerais
- **Nome do Projeto:** RPG Textual System (rpg-textual-system)
- **Versão:** 1.0-SNAPSHOT
- **Grupo:** br.com.ivieri
- **Linguagem:** Java (JDK 11+)
- **Build Tool:** Gradle 8.14
- **Framework de Testes:** JUnit 5

### Integrantes (Baseado no projeto)
- **Autor Principal:** Ivieri (conforme package `br.com.ivieri`)
- **Responsável pelo Repositório:** Professor (conforme caminho do Desktop)

### Ambiente de Desenvolvimento
- **IDE Sugerida:** IntelliJ IDEA (conforme artefatos na pasta `.idea/`)
- **Controle de Versão:** Git (conforme `.gitignore`)
- **Encoding:** UTF-8 (configurado no build.gradle.kts)

---

## 🎮 2. Descrição do Tema e Escopo do Projeto

### Tema
**"Sistema de Batalhas RPG Textual"** - Um motor de batalhas baseado em turnos inspirado em RPGs clássicos como Final Fantasy, Dragon Quest e Pokémon, implementado com interface textual (console).

### Descrição Geral
O RPG Textual System é um jogo de role-playing onde:
- O **jogador controla um Herói** que pode ser de diferentes classes (Guerreiro, Mago, etc.)
- O **Herói enfrenta Inimigos** procedentes de múltiplas categorias (Goblin, Orc, Dragão, etc.)
- O sistema **simula batalhas por turnos** onde ambos os personagens executam ações alternadas
- A **mecânica de combate** envolve distribuição de atributos, uso de habilidades, cálculo de dano e efeitos aleatórios (crítico, esquiva, defesa)

### Escopo do Projeto

#### Escopo Atual (Implementado) ✅
1. ✅ **Sistema de Personagens**
   - Heroi (classe jogável)
   - Inimigo (classes não-jogáveis)
   - Personagem (classe abstrata base)

2. ✅ **Sistema de Classes**
   - Classes de Herói (Guerreiro, Mago)
   - Classes de Inimigos (7 tipos diferentes)
   - Distribuição de atributos base por classe

3. ✅ **Sistema de Combate**
   - Turnos alternados
   - Cálculo de dano com múltiplos fatores
   - Sistema de Crítico (50% de aumento de dano)
   - Sistema de Esquiva (anula dano completamente)
   - Sistema de Defesa (reduz dano por percentual)
   - Sistema de Mana e consumo de habilidades

4. ✅ **Sistema de Habilidades**
   - Catálogo de habilidades
   - Aprendizado de habilidades por personagem
   - Multiplicadores de dano personalizados
   - Elementos de habilidades (Neutro, Fogo, Gelo, Elétrico, Terra)

5. ✅ **Interface de Linha de Comando**
   - Sistema de entrada de dados
   - Exibição de opções de batalha
   - Exibição de mensagens e resultados
   - Listagem de habilidades

#### Escopo Futuro (Planejado) 🔄
1. 🔄 **Ações Adicionais em Combate**
   - Defender (aumentar defesa próximo turno)
   - Fugir (chance baseada em vida/velocidade)
   - Usar itens

2. 🔄 **Sistema de Itens**
   - Itens de Cura
   - Itens de Ataque
   - Itens de Defesa
   - Sistema de Loja e Economia

3. 🔄 **Sistema de Efeitos de Status**
   - Sangramento
   - Queimadura
   - Atordoamento
   - Envenenamento

4. 🔄 **Sistema de IA Aprimorado**
   - Peso ponderado nas escolhas de habilidades
   - Agressividade baseada em vida
   - Escolhas inteligentes de habilidades

5. 🔄 **Sistema de Progressão**
   - Experiência (XP)
   - Níveis de personagem
   - Subida de atributos

6. 🔄 **Múltiplas Batalhas**
   - Exploração de mundo
   - Encontros aleatórios
   - Campanha principal

---

## 📋 3. Lista de Requisitos e Funcionalidades Principais

### Requisitos Funcionais

#### RF1: Sistema de Criação de Personagens
- **Descrição:** O sistema deve permitir a criação e inicialização de heróis e inimigos
- **Funcionalidades:**
  - Criar um herói com nome e classe predefinida
  - Assinar atributos base selon a classe escolhida
  - Criar inimigos com classe predefinida
  - Personagem herdar vida, mana, dano, defesa, chance crítico e chance esquiva

#### RF2: Sistema de Batalha por Turnos
- **Descrição:** Implementar um loop de batalha onde ambos os personagens agem alternadamente
- **Funcionalidades:**
  - Turno do jogador: escolher ação (atacar, defender, etc.)
  - Turno do inimigo: IA escolhe habilidade automaticamente
  - Battaglia termina quando um personagem morre
  - Alternar turnos até o fim da batalha

#### RF3: Sistema de Habilidades
- **Descrição:** Gerenciar habilidades disponíveis aos personagens
- **Funcionalidades:**
  - Armazenar catálogo de habilidades (ATAQUE_NORMAL, ATAQUE_FORTE, etc.)
  - Permitir personagens aprender habilidades
  - Verificar disponibilidade de mana antes de usar habilidade
  - Consumir mana ao usar habilidade

#### RF4: Cálculo de Dano
- **Descrição:** A partir de uma ação de ataque, calcular dano recebido pelo alvo
- **Funcionalidades:**
  - Calcular dano base = dano atacante × razão dano habilidade
  - Aplicar redução de defesa = dano × (1 - defesa%)
  - Verificar se alvo esquiva (anula dano)
  - Verificar se atacante crítica (aumenta dano em 50%)
  - Retornar resultado completo do ataque

#### RF5: Sistema de Sorte e Aleatoriedade
- **Descrição:** Implementar sistema de dados e testes de probabilidade
- **Funcionalidades:**
  - Rolar dados para escolhas aleatórias
  - Testar probabilidade de eventos (crítico, esquiva)
  - IA inimigo escolher habilidade aleatoriamente

#### RF6: Interface de Usuário Textual
- **Descrição:** Exibir informações de batalha e receber input do jogador
- **Funcionalidades:**
  - Mostrar menu de opções de batalha
  - Listar habilidades disponíveis
  - Exibir resultado de ataques
  - Mostrar mensagens de status
  - Receber entrada de números e validar

#### RF7: Gestão de Estado de Personagem
- **Descrição:** Controlar vida, mana e status vitais do personagem durante a batalha
- **Funcionalidades:**
  - Reduzir vida ao receber dano
  - Reduzir mana ao usar habilidade
  - Verificar se personagem está vivo
  - Impedir ações após morte

---

### Requisitos Não-Funcionais

#### RNF1: Performance
- A resposta da batalha deve ser imediata (< 100ms entre turnos)
- O cálculo de dano deve utilizar operações matemáticas simples

#### RNF2: Usabilidade
- Interface clara e intuitiva em linha de comando
- Mensagens em português brasileiro
- Validação de entradas com feedback ao usuário

#### RNF3: Maintibilidade
- Código organizado em pacotes temáticos
- Padrão MVC com separação de responsabilidades (Model-View-Controller)
- Uso de padrões de design (Facade, DAO, Services)
- Documentação em JavaDoc

#### RNF4: Extensibilidade
- Fácil adicionar novas classes de heróis/inimigos
- Fácil adicionar novas habilidades
- Fácil adicionar novos elementos
- Sistema preparado para novos tipos de itens

#### RNF5: Compatibilidade
- Suportar Windows, Linux e macOS
- Encoding UTF-8 para suportar caracteres especiais
- Compatível com Java 11+

#### RNF6: Segurança
- Não permitir valores negativos de vida/mana
- Validar entrada do usuário
- Impedir ações inválidas durante a batalha

---

### Funcionalidades Principais por Módulo

#### 🎭 Módulo Model (Modelos de Dados)
1. **Entidades**
   - `Personagem`: Classe abstrata com atributos e comportamentos
   - `Heroi`: Personagem controlado pelo jogador
   - `Inimigo`: Personagem controlado por IA
   - `Habilidade`: Record imutável com dados de poder
   - `CatalogoHabilidades`: Gerenciador de habilidades disponíveis
   - `Item`: Classe abstrata para itens

2. **Enumerações**
   - `ClasseHeroi`: Define tipos de heróis (Guerreiro, Mago)
   - `ClasseInimigo`: Define 7 tipos de inimigos
   - `TipoElemento`: Define 5 elementos de habilidades

3. **Serviços**
   - `BatalhaService`: Realiza cálculos de dano e efeitos
   - `CalculoDano`: Record com resultado de dano

4. **DTOs**
   - `ResultadoAtaque`: Encapsula dados de resultado de ataque

#### 🎮 Módulo Controller
1. **BatalhaController**
   - Gerencia fluxo de batalha
   - Processa turnos do jogador e inimigo
   - Coordena entrada de dados e execução de ações

#### 👀 Módulo View
1. **BatalhaView**: Exibe opções e resultados de batalha
2. **ListagemView**: Exibe listas (habilidades, inimigos, etc.)
3. **MensagemView**: Exibe mensagens informativas
4. **Teclado**: Gerencia entrada do usuário
5. **ConsoleUtils**: Utilitários de formatação de console

#### 🏗️ Padrões de Design

| Padrão | Classe | Descrição |
|--------|--------|-----------|
| **Facade** | `GameFachada` | Simplifica acesso à lógica de negócio |
| **DAO** | `br.com.rpg.dao` | Preparado para acesso a dados (futuro) |
| **Service** | `BatalhaService` | Encapsula lógica de cálculos |
| **Enum** | `ClasseHeroi`, `ClasseInimigo` | Define constantes de classes |
| **Record** | `Habilidade`, `ResultadoAtaque` | Armazena dados imutáveis |
| **Abstract** | `Personagem`, `Item` | Base para hierarquias |

---

## 📊 4. Arquitetura do Projeto

### Estrutura de Pacotes

```
br.com.rpg
├── Main                          [Ponto de entrada]
├── controller/
│   └── BatalhaController         [Gerencia fluxo]
├── facade/
│   └── GameFachada              [Fachada de negócio]
├── model/
│   ├── dto/
│   │   └── ResultadoAtaque      [Transferência de dados]
│   ├── entities/
│   │   ├── Personagem           [Classe abstrata]
│   │   ├── Heroi                [Herói controlado]
│   │   ├── Inimigo              [Inimigo com IA]
│   │   ├── Habilidade           [Record de poder]
│   │   └── CatalogoHabilidades  [Gerenciador]
│   ├── enums/
│   │   ├── ClasseHeroi          [Tipos de herói]
│   │   ├── ClasseInimigo        [Tipos de inimigo]
│   │   └── TipoElemento         [Elementos]
│   ├── item/
│   │   └── Item                 [Classe abstrata]
│   ├── services/
│   │   ├── BatalhaService       [Cálculos]
│   │   └── results/
│   │       └── CalculoDano      [Record de resultado]
├── util/
│   └── Dado                      [Gerador aleatório]
├── view/
│   ├── BatalhaView              [Exibição batalha]
│   ├── ListagemView             [Listagens]
│   ├── MensagemView             [Mensagens]
│   ├── Teclado                  [Entrada]
│   └── utils/
│       └── ConsoleUtils         [Formatação console]
├── exceptions/
│   └── HabilidadeNaoEncontradaException
└── dao/                          [DAO preparado]
```

### Fluxo de Dados Principal

```
Main
  ↓
BatalhaController.iniciarBatalha()
  ├─ turnoJogador()
  │   ├─ BatalhaView.mostrarOpcoes()
  │   ├─ Teclado.lerInteiro()
  │   ├─ GameFachada.personagemAtacar()
  │   │   ├─ Personagem.consumirMana()
  │   │   ├─ BatalhaService.calcularDano()
  │   │   ├─ Personagem.receberDano()
  │   │   └─ ResultadoAtaque
  │   └─ BatalhaView.mostrarResultado()
  │
  ├─ turnoInimigo()
  │   ├─ Inimigo.retornarHabilidade()
  │   ├─ GameFachada.personagemAtacar()
  │   └─ BatalhaView.mostrarResultado()
  │
  └─ Loop enquanto ambos vivos
```

---

## 📐 5. Diagrama de Classes UML Completo

O diagrama abaixo representa a arquitetura e relacionamentos entre todas as classes principais do projeto:

### Visualização do Diagrama UML

```
[Diagrama renderizado acima - veja o diagrama Mermaid em "Diagrama de Classes UML - RPG Textual System"]
```

### Descrição dos Relacionamentos

#### Hierarquia de Herança
- **Personagem** (abstrata) ← **Heroi** : Herói controlado pelo jogador
- **Personagem** (abstrata) ← **Inimigo** : Adversário controlado por IA
- **Item** (abstrata) : Base para futuras subclasses (Equipamento, Consumível)

#### Associações Principais
- **Personagem** usa **Habilidade** (composição: 0...* habilidades aprendidas)
- **Habilidade** usa **TipoElemento** (enum para tipo de ataque)
- **ClasseHeroi** inicializa **Heroi** (atributos base)
- **ClasseInimigo** inicializa **Inimigo** (atributos base)

#### Fluxo de Dados
- **BatalhaController** coordena **Heroi** vs **Inimigo**
- **GameFachada** executa ações via **BatalhaService**
- **BatalhaService** calcula resultado **CalculoDano**
- Resultado é encapsulado em **ResultadoAtaque**

---

## 📊 6. Detalhamento das Principais Classes

### 6.1 Personagem (Classe Abstrata)

**Responsabilidade:** Definir atributos e comportamentos base para heróis e inimigos

**Atributos:**
| Atributo | Tipo | Descrição |
|----------|------|-----------|
| `nome` | String | Identificação única do personagem |
| `vida` | int | Pontos de vida atuais (0-Max) |
| `dano` | int | Bônus de dano base |
| `mana` | int | Energia para conjurar habilidades |
| `defesa` | double | Redução de dano por percentual (0-100%) |
| `chanceCrit` | double | Probabilidade de crítico (0-100%) |
| `chanceEsq` | double | Probabilidade de esquiva (0-100%) |
| `isVivo` | boolean | Status vitals do personagem |
| `menuHabilidades` | List~Habilidade~ | Habilidades aprendidas |

**Métodos Principais:**
```java
public void receberDano(int dano)          // Reduz vida
public void consumirMana(int mana)         // Consome mana
public void aprenderHabilidade(Habilidade) // Aprende nova habilidade
public boolean isVivo()                     // Verifica se está vivo
```

### 6.2 Heroi

**Responsabilidade:** Representar o personagem jogável

**Atributos Adicionais:**
- Herda todos de `Personagem`
- Armazena `ClasseHeroi` para referência

**Exemplo de Instanciação:**
```java
Heroi heroi = new Heroi("Ivieri", ClasseHeroi.GUERREIRO);
// Herói criado com atributos base do Guerreiro
```

### 6.3 Inimigo

**Responsabilidade:** Representar adversário controlado por IA

**Métodos Especiais:**
```java
public Habilidade retornarHabilidade() // IA escolhe habilidade aleatória
```

**Lógica de Escolha:**
1. Filtra habilidades com mana disponível
2. Se nenhuma disponível, retorna null
3. Se tem disponível, escolhe aleatoriamente uma

**Exemplo de Instanciação:**
```java
Inimigo inimigo = new Inimigo("Orc", ClasseInimigo.ORC);
// Inimigo criado com vida moderada, dano moderado, boa defesa
```

### 6.4 Habilidade (Record)

**Responsabilidade:** Armazenar dados imutáveis de um poder/ataque

**Atributos:**
```java
record Habilidade(
    String nome,           // "ATAQUE_FORTE"
    int custoMana,        // Mana necessária (0 = básico)
    double razaoDano,     // Multiplicador (1.0 = normal, 1.5 = forte)
    TipoElemento elemento // FOGO, GELO, etc
)
```

**Exemplo:**
```java
Habilidade ataqueForte = new Habilidade(
    "ATAQUE_FORTE",
    15,      // Custa 15 de mana
    1.5,     // 150% do dano base
    TipoElemento.NEUTRO
);
```

### 6.5 ClasseHeroi (Enum)

**Variantes Disponíveis:**

| Classe | Vida | Dano | Mana | Defesa | Crítico | Esquiva |
|--------|------|------|------|--------|---------|---------|
| **GUERREIRO** | 100 | 15 | 25 | 15.0% | 5.0% | 8.0% |
| **MAGO** | 80 | 20 | 50 | 8.0% | 5.0% | 10.0% |

**Característica:** Guerreiro = resistência + defesa, Mago = dano + mana

### 6.6 ClasseInimigo (Enum)

**Variantes Disponíveis:**

| Tipo | Vida | Dano | Mana | Defesa | Crítico | Esquiva | Propósito |
|------|------|------|------|--------|---------|---------|-----------|
| **MINION_GUERREIRO** | 10 | 5 | 0 | 5% | 0% | 10% | Tutorial |
| **MINION_MAGO** | 8 | 4 | 20 | 3% | 5% | 15% | Tutorial |
| **GOBLIN** | 30 | 8 | 0 | 5% | 10% | 25% | Fraco, ágil |
| **ORC** | 80 | 15 | 0 | 20% | 5% | 5% | Resistente |
| **DRAGAO** | 150 | 25 | 50 | 30% | 5% | 5% | Boss |
| **TROLL** | 15 | 10 | 0 | 80% | 50% | 0% | Defesa extrema |
| **ASSASSINO** | 25 | 40 | 0 | 10% | 90% | 5% | Crítico extremo |

### 6.7 BatalhaService

**Responsabilidade:** Calcular dano e efeitos de combate

**Método Principal:**
```java
public CalculoDano calcularDano(
    Personagem atacante,
    Personagem alvo,
    Habilidade ataque
)
```

**Algoritmo:**
```
1. Testar esquiva do alvo
   └─ Se esquiva bem-sucedida (prob: chanceEsq%)
      └─ Retorna: dano=0, esquivou=true

2. Calcular dano base
   └─ danoBase = atacante.dano × ataque.razaoDano

3. Aplicar defesa
   └─ danoFinal = danoBase × (1 - alvo.defesa/100)

4. Testar crítico do atacante
   └─ Se crítico bem-sucedido (prob: chanceCrit%)
      └─ danoFinal *= 1.5 (50% de aumento)

5. Retornar CalculoDano com resultado
```

### 6.8 BatalhaController

**Responsabilidade:** Gerenciar fluxo de batalha

**Loop Principal:**
```
Enquanto (heroiVivo && inimigoVivo):
    ├─ turnoJogador(heroi, inimigo)
    │  ├─ Exibir menu de opções
    │  ├─ Ler escolha do usuário
    │  └─ Executar ação (atacar, defender, etc.)
    │
    └─ turnoInimigo(inimigo, heroi)
       ├─ IA escolhe habilidade
       └─ Executar ataque automático
```

### 6.9 GameFachada

**Responsabilidade:** Intermediar entre Controller e Model

**Método Principal:**
```java
public ResultadoAtaque personagemAtacar(
    Personagem atacante,
    Personagem alvo,
    Habilidade habUsar
)
```

**Processo:**
1. Consome mana do atacante
2. Calcula dano via BatalhaService
3. Reduz vida do alvo
4. Retorna resultado completo em ResultadoAtaque

---

## 🎮 7. Fluxo de Execução - Exemplo Prático

### Cenário: Herói Guerreiro vs Goblin

```
INICIALIZAÇÃO:
├─ Main.main()
├─ Criar Heroi("Ivieri", GUERREIRO)
│  └─ Herói criado com: vida=100, dano=15, mana=25, defesa=15%, etc.
├─ Criar Inimigo("Goblin", GOBLIN)
│  └─ Goblin criado com: vida=30, dano=8, mana=0, defesa=5%, esquiva=25%
├─ Ensinar habilidades
│  ├─ herói aprende "ATAQUE_NORMAL" (dano 1.0x)
│  └─ herói aprende "ATAQUE_FORTE" (dano 1.5x)
└─ Iniciar BatalhaController.iniciarBatalha(herói, goblin)

TURNO 1 - JOGADOR:
├─ BatalhaView.mostrarOpcoesBatalhaJogador()
│  └─ Exibe: [1] Atacar [2] Defender [3] Itens [4] Inimigo [5] Fugir
├─ Jogador escolhe: 1 (Atacar)
├─ BatalhaView.listarHabilidades(herói.menuHabilidades)
│  └─ Exibe habilidades com custo de mana
├─ Jogador escolhe: ATAQUE_FORTE (15 mana, 1.5x dano)
├─ GameFachada.personagemAtacar(herói, goblin, ATAQUE_FORTE)
│  ├─ herói.consumirMana(15) → herói.mana = 10
│  ├─ BatalhaService.calcularDano(herói, goblin, ATAQUE_FORTE)
│  │  ├─ Testar esquiva Goblin: 25% chance
│  │  │  └─ Não esquivou
│  │  ├─ Dano base: 15 × 1.5 = 22.5
│  │  ├─ Após defesa: 22.5 × (1 - 0.05) = 21.375
│  │  ├─ Testar crítico Herói: 5% chance
│  │  │  └─ Não foi crítico
│  │  └─ Retorna: CalculoDano(21, false, false)
│  ├─ goblin.receberDano(21) → goblin.vida = 9
│  └─ Retorna: ResultadoAtaque("Ivieri", "Goblin", "ATAQUE_FORTE", 21, false, false, false)
└─ BatalhaView.mostrarResultadoAtaque(resultado)
   └─ Exibe: "Ivieri usou ATAQUE_FORTE em Goblin e causou 21 de dano!"

TURNO 1 - INIMIGO:
├─ Inimigo.retornarHabilidade()
│  ├─ Filtrar habilidades com mana disponível
│  └─ Goblin tem 0 mana, mas ATAQUE_NORMAL custa 0
│  └─ Retorna: ATAQUE_NORMAL
├─ GameFachada.personagemAtacar(goblin, herói, ATAQUE_NORMAL)
│  ├─ goblin.consumirMana(0)
│  ├─ BatalhaService.calcularDano(goblin, herói, ATAQUE_NORMAL)
│  │  ├─ Testar esquiva Herói: 8% chance
│  │  │  └─ Herói esquivou!
│  │  └─ Retorna: CalculoDano(0, false, true)
│  ├─ herói.receberDano(0)
│  └─ Retorna: ResultadoAtaque("Goblin", "Ivieri", "ATAQUE_NORMAL", 0, true, false, false)
└─ BatalhaView.mostrarResultadoAtaque(resultado)
   └─ Exibe: "Goblin usou ATAQUE_NORMAL em Ivieri, mas errou!"

TURNO 2+:
└─ Continuar até Goblin.vida <= 0 ou Herói.vida <= 0

FINALIZAÇÃO:
├─ Loop sai (Goblin morreu)
├─ BatalhaView.mostrarVencedor("Ivieri")
└─ Jogo termina
```

---

## 💾 8. Tecnologias e Dependências

### Stack Tecnológico

| Componente | Versão | Propósito |
|-----------|--------|----------|
| **Java** | 11+ | Linguagem principal |
| **Gradle** | 8.14 | Build tool |
| **JUnit** | 5.10.0 | Framework de testes |
| **Maven Central** | - | Repositório de dependências |

### Configuração de Build (build.gradle.kts)

```gradle
plugins {
    id("java")
    id("application")
}

group = "br.com.ivieri"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("br.com.rpg.Main")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaExec> {
    jvmArgs = listOf("-Dfile.encoding=UTF-8")
}
```

---

## 🚀 9. Como Executar o Projeto

### Pré-requisitos
- Java Development Kit (JDK) 11 ou superior
- Gradle 8.14+ (ou usar gradlew fornecido)

### Executar no Windows

```batch
# Abra PowerShell ou CMD no diretório do projeto

# Compilar o projeto
.\gradlew.bat build

# Executar
.\gradlew.bat run
```

### Executar no Linux/Mac

```bash
# Terminal no diretório do projeto

# Compilar
./gradlew build

# Executar
./gradlew run
```

### Executar Testes

```bash
./gradlew test
```

---

## 📝 10. Notas Importantes e TODOs

### Funcionalidades em TODO (Próximas Implementações)

1. **Sistema de Defesa**
   - Permitir jogador escolher se defender
   - Aumentar defesa por 1 turno
   - Localização: [BatalhaController.java](src/main/java/br/com/rpg/controller/BatalhaController.java#L60)

2. **Sistema de Itens**
   - Criar subclasses de Item (Consumível, Equipamento)
   - Implementar inventário
   - Sistema de loja
   - Localização: [BatalhaController.java](src/main/java/br/com/rpg/controller/BatalhaController.java#L64)

3. **Sistema de Efeitos de Status**
   - Sangramento, Queimadura, Atordoamento
   - Duração de efeitos
   - Localização: [BatalhaController.java](src/main/java/br/com/rpg/controller/BatalhaController.java#L40)

4. **IA Aprimorada para Inimigo**
   - Pesos ponderados nas habilidades
   - Agressividade baseada em vida
   - Localização: [Inimigo.java](src/main/java/br/com/rpg/model/entities/Inimigo.java#L34)

5. **Sistema de Fuga**
   - Permitir jogador tentar fugir
   - Chance baseada em vida/velocidade
   - Localização: [BatalhaController.java](src/main/java/br/com/rpg/controller/BatalhaController.java#L70)

6. **Sistema de Informações de Inimigo**
   - Menu para ver vida e habilidades do inimigo
   - Sem mostrar dano/mana
   - Informações aparecem após primeiro turno
   - Localização: [BatalhaController.java](src/main/java/br/com/rpg/controller/BatalhaController.java#L65)

### Boas Práticas Observadas

✅ Padrão MVC implementado  
✅ Separação de responsabilidades clara  
✅ Uso de Enums para constantes  
✅ Records para dados imutáveis  
✅ Documentação em JavaDoc  
✅ Encoding UTF-8 configurado  
✅ Nomes de classes descritivos  
✅ Métodos com responsabilidade única  

### Possíveis Melhorias Futuras

- Adicionar tests unitários (JUnit 5 já configurado)
- Persistência de dados em banco de dados (DAO preparado)
- Interface gráfica (Swing/JavaFX)
- Modo multiplayer em rede
- Sistema de achievement/ranking
- Sons e efeitos visuais (com biblioteca externa)

---

## 📞 Contato e Suporte

- **Autor Original:** Ivieri
- **Responsável do Projeto:** Professor
- **Última Atualização:** 2026-02-20
- **Versão da Documentação:** 1.0

---

**Fim da Documentação - RPG Textual System v1.0**

