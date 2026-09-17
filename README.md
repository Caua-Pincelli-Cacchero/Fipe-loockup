# Fipe-Loockup

Aplicação Java em linha de comando (CLI), construída com Spring Boot, que consome a API pública da Tabela FIPE para consultar o valor de veículos com base no tipo, marca, modelo e ano.

## Funcionalidades

- Consulta por tipo de veículo: carro, moto ou caminhão
- Seleção de marca
- Seleção de modelo
- Listagem de todos os anos disponíveis para o modelo escolhido, com:
  - Valor
  - Código FIPE
  - Marca
  - Modelo
  - Ano

## Tecnologias utilizadas

- Java
- Spring Boot
- HttpClient nativo do Java (para consumo da API pública da FIPE)
- Maven

## Como rodar o projeto

Pré-requisitos: Java 17+ e Maven instalados.

\`\`\`bash
# Clone o repositório
git clone https://github.com/Caua-Pincelli-Cacchero/Fipe-loockup.git
cd Fipe-loockup

# Rode a aplicação
mvn spring-boot:run
\`\`\`

Não é necessária nenhuma configuração adicional (chave de API, variáveis de ambiente ou banco de dados) — a aplicação consome a API pública da FIPE diretamente.

## Como usar

Ao rodar a aplicação, o terminal solicita as informações em sequência:

1. Tipo de veículo (carro, moto ou caminhão)
2. Marca
3. Modelo

Em seguida, a aplicação lista todos os anos disponíveis para o modelo escolhido, exibindo para cada um: valor, código FIPE, marca, modelo e ano.

### Exemplo de uso

\`\`\`
Digite o tipo de veículo (carro, moto, caminhão): carro
Digite a marca: Fiat
Digite o modelo: Uno

Resultados:
Ano: 2020 | Modelo: Uno | Marca: Fiat | Código FIPE: 001234-5 | Valor: R$ 38.500,00
Ano: 2019 | Modelo: Uno | Marca: Fiat | Código FIPE: 001234-5 | Valor: R$ 35.200,00
...
\`\`\`
> *Valores meramente ilustrativos — os dados reais vêm da API pública da FIPE em tempo de consulta.*

## Autor

**Cauã Pincelli Cacchero**
[GitHub](https://github.com/Caua-Pincelli-Cacchero) | [LinkedIn](https://linkedin.com/in/caua-pincelli-cacchero)
