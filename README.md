# Banheiro-Unisex-Com-recorrencia

# Trabalho Prático: Mecanismos de Sincronização

Marlus Marcos; Misael Damasceno.

LINK REPO: https://github.com/mis4ias/Banheiro-Unisex-Com-recorrencia

# 1 O problema

O problema consiste em administrar a entrada, saída e utilização de um banheiro
unisex de um determinado escritório. As regras de uso consistem em que quando um
homem estiver utilizado o banheiro somente, homens poderão entrar até o limite
máximo da capacidade do ambiente comportar. De mesmo modo, para as mulheres, ou
seja, sempre que outro gênero desejar utilizar o ambiente, ele primeiro deve aguardar
que o banheiro fique vazio. E necessário também fazer o controle do tempo para
utilização do banheiro e do tempo que o banheiro permanecerá para determinado
gênero, evitando que algum gênero fique sem entrar no banheiro e assim fazendo
justiça aos usuários do ambiente.

# 2 Solução

Para construir a solução foi necessário analisar o que precisava de atenção no
funcionamento da aplicação, verificamos que como foi descrito no problema, seria
necessário dar atenção a quem estava no banheiro para que pessoas do mesmo gênero
pudessem entrar e observar as filas que estariam fora do banheiro para evitarmos o
starvation.
Decidimos utilizar Monitores para implementação da solução, tendo em vista que
esse mecanismo de sincronização garante a exclusão mútua, por meio de locks e
sincronização dos métodos. Utilizamos então uma classe Monitor que ficou
responsável por controlar o fluxo do banheiro, sendo o banheiro outra classe onde
possui os atributos como fila de homens, fila de mulheres, ocupação e capacidade. A
classe monitor então cria humanos de maneira randômica e povoa as filas do banheiro
que por sua vez chama a classe BanheiroThread em que faz a chamada dos próximos
humanos para entrar no banheiro e faz a troca do gênero depois de um determinado
tempo para evitar o starvation, ficando o Monitor responsável pela execução e
controle das threads.
Desta Forma, com a utilização do Monitor conseguimos garantir o fluxo correto do
banheiro, permitindo a entrada e saída, como também a utilização mais justa para
ambos os gêneros.

# 3 Conclusões

A problemática maior que tivemos foi no controle da entrada, saída de pessoas e
impressão na saída do terminal. Precisamos pensar um pouco fora da caixa para
chegarmos a solução, não ficando totalmente correto por conta desse controle que
precisa ser feito de uma forma minuciosa. O pouco conhecimento dos métodos de
concorrência da linguagem também dificultou um pouco pelo motivo de nem todos os
membros da equipe terem o mesmo nível de programação com concorrência em java.
