# Projeto Dino Tech

![dinotech](https://github.com/migueelfr/DINO-TECH/assets/142853940/71d736b0-b021-49cf-b50a-7812a53677d5)


## Descrição
Este é um projeto de uma loja com peças de computador. A porposta da loja é vender peças como processadores, SSDs, coolers, e outros itens de hardware.

Usamos a linguagem java e o banco de dados SQLite com a dependência do driver sqlite-jdbc-3.20.0.jar, então voce precisara baixa-lo.

Também é necessário baixar o Plugin para ver as tabelas:

![image](https://github.com/migueelfr/DINO-TECH/assets/142853940/9393245a-387d-45c2-8520-8fb25189c22d)

As telas foram feitos usando a biblioteca do swing disponível no java, ou seja, é uma interface desktop.


## Funcionalidades
- Tela de login para o usuario entrar com seu usuario a senha.
- Tela de criação de conta.
- Tela para escolher e vizualizar os produtos disponíveis junto com seus preços.
- Um carrinho para armezenar os produtos escolhidos.
- Tela de pagamento com as opções "Cartao de crédito, boleto e pix".

## Como Usar
1. Para iniciar a Dino Tech, basta acessar a classe "TelaDeLogin" e seguir adiante preenchendo os campos e escolhendo os protudos.
2. Para conectar o banco de  dados, voce precisa baixar o driver da dependência como dito acima e inseri-lo no código, baixar o Plugin mostrado e mudar o caminho da String URl para o local em que o banco foi guardado em seu pc:

![image](https://github.com/migueelfr/DINO-TECH/assets/142853940/24443395-767b-4828-8a9a-7e71d046f5a3)

3. Então é so executar o main da classe ConexaoSQL e o banco de dados será conectado.
4. E para ver o codigo em seu PC, baixe o .zip e extraia, porque houveram muitos arquivos e nao foi aceito toda a pasta do LOJA.GUI no diretório.

## Bibliotecas Utilizadas
PARA O BANCO DE DADOS:
- import java.sql.Connection -  conexão (sessão) com um banco de dados específico;
- import java.sql.DriverManager - Gerencia um conjunto de drivers JDBC;
- java.sql.SQLException - Para caso ocorra um Excessão SQL;
- import java.util.logging.Level - Define um conjunto de níveis padrão de log que controlam a saída de mensagens de log;
- import java.util.logging.Logger - É usado para registrar mensagens de aplicação no Java Logging API;

PARA AS TELAS:
- import javax.swing.* - Biblioteca que fornece os metodos para criação de botões, textos, cores, scrolls e tudo que seja necessário para fazer as telas. Só é possível utilizar as outras bibliotecas para essas ações por conta do swing, mas como são muitas, serão citadas apenas algumas.
- import java.awt.event.ActionEvent - Usada para ações de botões, etc;
- import java.awt.* - Tem função parecida com a do swing;
- import java.util.ArrayList- Usada para armazenar uma quantidade de itens;
- import java.awt.event.WindowAdapter - Usada para receber eventos de janela em Java, fornecendo métodos vazios para todos os eventos de interesse;
- import java.awt.datatransfer.Clipboard - Usada para implementar um mecanismo de transferência de dados usando operações de corte/cópia/cola;

## Contribuidores
- @brksam
- @migueelfr

## Final
Este é um projeto bem simples da Faculdade, não possui funcionalidades impressionantes ou uma interface excelente, foi apenas algo para testar nosso conhecimento basico em java.
OBRIGADO PELA ATENÇÃO!!!
