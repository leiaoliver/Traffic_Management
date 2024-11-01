# SmartCities - Projeto de Cidades Inteligentes

Este repositório contém o projeto **TrafficManagement**. 

### 1. Testes de API
* Implementar testes automatizados para todas as APIs do projeto, garantindo:
  - **Validação do status code** (códigos de resposta HTTP corretos).
  - **Validação do corpo de resposta** (estrutura e dados do JSON).
  - **Testes de contrato** utilizando **JSON Schema**.


### 2. Ferramentas Utilizadas:
* java
* springboot
* Banco de dados(sql)
* Gherkin (Testes)

### 3. Execução dos Testes
* Os testes são integrados em um pipeline de **CI/CD** (Integração Contínua) utilizando ferramentas como **Azure DevOps** e **GitHub Actions**. Foi é validado as funcionalidades críticas do sistema utilizando **BDD (Behavior Driven Development)** com Gherkin e automação de testes para APIs.

```bash
git clone https://github.com/leiaoliver/Aplication_Devops.git
cd Aplication_Devops
mvn test

