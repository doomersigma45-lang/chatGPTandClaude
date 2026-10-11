# Claude Content — mod conjunto Claude + ChatGPT (Minecraft 1.20.1 / Forge 47.3.0)

Projeto Java/Gradle completo. O `.jar` é gerado automaticamente pelo GitHub Actions
(aba **Actions** → último run → artefato `claude-content-jar`) ou localmente com `gradle build` (JDK 17, Gradle 8.1.1+).

## Conteúdo
| | Claude | ChatGPT |
|---|---|---|
| Boss | Ceifador de Cinzas (`ash_reaper`) | Colosso de Musgo (`moss_colossus`), invocado no Altar das Raízes |
| Criatura neutra | Musgolim (`mossling`) | — |
| Criatura hostil | Espreitador de Brasa (`cinder_stalker`) | — |
| Criatura pacífica | — | Lumileu (`lumileu`), reproduz com frutas |
| Armadura | Conjunto de Brasa | — |
| Extras | Selo de Cinzas, Escama de Brasa | Altar das Raízes, Broto Ancestral, Núcleo Enraizado, Santuário das Raízes (estrutura subterrânea em florestas) |

---


## O que tem aqui
| Categoria | Nome (pt-BR) | Id |
|---|---|---|
| Boss | Ceifador de Cinzas | `claude_content:ash_reaper` |
| Criatura neutra | Musgolim | `claude_content:mossling` |
| Criatura hostil | Espreitador de Brasa | `claude_content:cinder_stalker` |
| Armadura | Conjunto de Brasa (elmo, peitoral, calças, botas) | `claude_content:cinder_*` |
| Extra | Selo de Cinzas (invoca o boss), Escama de Brasa (material), ovos de spawn | `ash_sigil`, `cinder_scale` |

### Comportamento
- **Ceifador de Cinzas** (300 HP, barra de boss): fase 1 corpo a corpo que incendeia, bolas de fogo à distância e golpe no chão (quem está pulando desvia).
  Abaixo de 50% de vida fica mais rápido, lança 3 bolas por vez, golpeia o chão com mais frequência e invoca Espreitadores. Nenhum golpe causa mais de 40 de dano nele. Dropa 8–14 Escamas de Brasa.
- **Musgolim**: neutro. Deixa tapetes de musgo por onde anda; se atacado, ele e os Musgolins próximos ficam furiosos por 20–39 s. Spawna em florestas e pântanos.
- **Espreitador de Brasa**: hostil, imune ao fogo, salta sobre a presa e incendeia; sofre dano na água/chuva. Spawna no Nether (ermos e deltas de basalto) e desertos. Dropa 0–2 Escamas.
- **Armadura de Brasa**: defesa 3/8/6/3, resistência 3,5, repulsão 0,05. Conjunto completo: resistência ao fogo permanente + 25% de chance de incendiar quem te atacar.
- **Receitas**: armadura = Escamas de Brasa no formato vanilla. Selo de Cinzas = 4 Escamas + 4 Obsidiana + 1 Estrela do Nether (padrão em X com a estrela no centro).

## Como rodar sozinho
Precisa de JDK 17. Este projeto não inclui o Gradle wrapper: copie `gradlew`, `gradlew.bat` e a pasta `gradle/` do MDK oficial do Forge 1.20.1 (47.3.0) e rode `./gradlew runClient`.

## Como integrar no mod do ChatGPT (dois jeitos)
**A) Copiar para o mod principal (recomendado)**
1. Copie `src/main/java/com/claudecontent/` para o projeto principal (mantendo o pacote) e `src/main/resources/assets/claude_content` + `data/claude_content` para os resources.
2. Em `ClaudeContent.java`, **remova** `@Mod(...)` e o construtor.
3. No construtor da classe principal: `ClaudeContent.register(modEventBus);`
4. Os ids usam o namespace `claude_content`, então não colidem com os do ChatGPT.
5. Se o mod principal já tiver uma aba criativa própria, pode apagar `ModCreativeTabs` e registrar os itens dela.

**B) Dois mods na mesma jar**: mantenha `@Mod` e adicione um segundo bloco `[[mods]]` com `modId="claude_content"` no `mods.toml` do projeto principal.

## Pendências conhecidas
- As texturas são **placeholders** gerados por script (funcionais, mas simples). Os modelos 3D reusam os vanilla (zumbi ampliado, aranha, porco).
- O código **não foi compilado aqui** (o ambiente não alcança o Maven do Forge). Se o compilador reclamar de alguma assinatura, é correção de uma linha.

## Conteúdo integrado pelo ChatGPT
| Categoria | Nome (pt-BR) | Id |
|---|---|---|
| Boss | Colosso de Musgo | `claude_content:moss_colossus` |
| Criatura pacífica | Lumiléu | `claude_content:lumileu` |
| Estrutura | Santuário das Raízes | `claude_content:roots_sanctuary` |
| Recompensas | Núcleo Enraizado e Broto Antigo plantável | `rooted_core`, `ancient_sprout` |

O Santuário das Raízes é adicionado como feature de geração rara em biomas de floresta. O altar central pode ser ativado uma vez para despertar o Colosso; o altar vira pedra rachada após a invocação. O boss tem barra própria e segunda fase abaixo de metade da vida. O Lumiléu aparece naturalmente em florestas, foge quando ferido, segue frutas doces e pode se reproduzir com frutas doces ou maçãs. O Broto Antigo é uma flor decorativa plantável que emite luz suave.

As texturas dos novos conteúdos usam provisoriamente os placeholders visuais que já acompanham o ZIP. Os arquivos de código, registros, tabelas de loot, traduções, modelos e dados de geração estão incluídos.

