## 💰 Calculadora de Juros Diários

* Este projeto é uma aplicação Java simples e objetiva desenvolvida para calcular o valor de juros e multa sobre um título vencido, utilizando a data de execução em tempo real como referência para o cálculo.
* O foco principal é garantir a precisão financeira através do uso da classe java.math.BigDecimal e a exatidão temporal com o java.time.LocalDate.

---

## ✨ Funcionalidades Principais

* Cálculo Automático: Utiliza a data atual do sistema (LocalDate.now()) para calcular os dias de atraso, eliminando a necessidade de atualização manual do código.
* Precisão Financeira: Emprega BigDecimal para todos os cálculos monetários, garantindo que o arredondamento (configurado para HALF_UP com 2 casas decimais) seja preciso e adequado para aplicações financeiras.
* Regra de Multa: Aplica uma taxa de multa/juros diária sobre o valor original.

## ⚙️ Dados Utilizados

| Descrição | Valor |
| :--- | :--- |
| Data de Vencimento | 05/11/2025 | 
| Data de Cálculo | **Em Tempo Real** |
| Valor Original da Dívida | R$ 1418,90 |
| Multa Diária Aplicada | 2,5% |

---

## 🛠️ Tecnologias e Pré-requisitos

* Linguagem: Java 17+ (ou qualquer versão que suporte o pacote java.time).
* Build Tool: Maven (padrão para projetos no IntelliJ).
* IDE: IntelliJ IDEA (recomendado).

---

## 🤝 Contribuição
Sinta-se à vontade para sugerir melhorias, como mover o JSON para um arquivo externo ou implementar testes unitários.

---

## Autor: Vinícius Santana Lima / https://github.com/ViniVSL / www.linkedin.com/in/vinivsl-dev
