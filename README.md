# JobCloud-Microservices ou Acelera Frameworks
### Esse repo foi criado para o Kit 3: Frameworks
## Esse repo foi criado para o Kit 3: Frameworks
### O plano:
Depois de chegar no projeto do Spring e terminar ele, eu também cheguei no projeto do Grails, o grande problema é que eu estou com um plano. 
Vou seguir o seguinte esquema: Angular > Grails > Micronaut > Spock
Com o Angular eu já começo a fundação pra criação de um CRUD com Login. 
O problema atual é que como eu não tenho um LOGIN eu não sei qual das vagas ou candidatos eu posso deletar e atualizar, fazendo assim o CRUD ficar impossivel.
Eu faço o Front usando o mesmo design, só que dessa vez pensando em logins e etc, e refatoro o backend e apis para fazer login, atualizar e deletar no Grails, e ai uso a base do Grails no Micronaut e adiciono os testes com Spock. 

# Spring

Essa semana começa forte com Spring vindo com tudo, não tive muitas dificuldades, não sei se fiz corretamente, mas consigo adicionar itens ao banco de dados, fazer solicitações HTTP e etc.
Resolvi por fazer o minímo pedido pela questão, que é o cadastro de Vagas, Candidatos e Empresas por conta do tempo, provavelmente hoje mesmo irei entregar Grails e vou seguir o mesmo caminho. Então a feature de login vai aparecer lá pelo Angular.

## Faltantes 
- Login
- Apagar empresa, vaga ou candidato
- Refresh de empresa vaga ou candidato

# Angular 

Refatação do Front end com Angular, e também uma refatação do Spring, senti que o meu spring estava de alguma maneira errada, por que estava enviando strings e não objetos. 
Agora eu envio o objeto, comuniando tudo com as apis usando o spring. 

## Adicionado
- Integração completa do cadastro de candidato, vagas e empresas
- Corrigido alguns bugs de z-index
- Agora você tem uma visão de "admin", quando um candidato é adicionado você pode ver ele no feed de empresas, e quando uma vaga é adicionada, você pode ver ela no feed de candidato

## Faltantes

- Sistema de login
- Linkar o sistema de login com delete de empresas
- Atualizar info 

Basicamente o que falta tudo é dependente do Login, com o login você poderia ver quais são as vagas da SUA empresa, e ai apagar, atualizar, etc... O mesmo vale para os candidatos.
Aconteceu uma refatoração básica do front, coisas da parte do design, coloquei umas animações. 


# Spock

Adição do Spock para testes unitários, nada além disso foi adicionado ou retirado, salve algumas linhas do back-end para retorno de objetos. 
Com certeza deve estar faltando alguma coisa que eu simplesmente me esqueci de adicionar aos testes, mas vou assumir que está tudo certo pelo fato de todos passarem.


# Swagger

Adição do Swagger, a documentação está conjunta porém com alguns adendos. 
Como o Grails estava mal configurado, durante a criação do mesmo as configurações estavam em Create-Drop, o que fez meu Postgres dropar algumas tables, a refatoração terá de ser feita no Micronaut.

## Swagger + Grails 
- POST
- PUT
- DELETE
- GETBYID
- GETALL

## Swagger + Spring

- POST
- GETALL

Como eu fiz o Spring antes, e era obrigatoriedade apenas esses dois métodos, esses são os que ficarão, pelo fato do restrição de tempo e de que provavelmente eu não usarei o Spring futuramente, tendo preferido muito mais o Grails. 
Algumas refatorações foram feitas no Spring para se adequarem ao " novo banco de dados ", leia essa frase com muitas aspas.
A parte do Swagger que corresponde ao: securityDefinitions não foi alterado do próprio Swagger editor.

# Grails

Adição do crud com grails, basicamente a mesma coisa do Spring, criação dos endpoints por grails, algumas mudanças tiveram de ser feitas ( Ou o GRAILS FEZ SOZINHO ) ao banco de dados, então mudei o banco de dados temporariamente, provavlemente até a trilha de Micronaut, onde ficará em sua forma definitiva. 
Mudei também algumas coisas no front end, mas ainda sem login, provavelmente a versão final virá em micronaut, que até o fim da semana estará pronto.

Uma  coisa que esqueci de comentar que vale para todas as trilhas, quando for rodar a aplicação em Angular, não use o ng serve, use ng serve --proxy-config proxy.conf.js 
Isso vai evitar problema de CORS.


Como eu fiz o Spring antes, e era obrigatoriedade apenas esses dois métodos, esses são os que ficarão, pelo fato do restrição de tempo e de que provavelmente eu não usarei o Spring futuramente, tendo preferido muito mais o Grails. Algumas refatorações foram feitas no Spring para se adequarem ao " novo banco de dados ", leia essa frase com muitas aspas. A parte do Swagger que corresponde ao: securityDefinitions não foi alterado do próprio Swagger editor.


# Micronaut

## Adição do Micronaut
Nessa trilha, a integração é feita com Micronaut, alguns bugs podem ser destacados, sendo esses:
- Algumas vezes o endpoint vai simplesmente dar erro, quando reiniciado o servidor tudo volta ao normal
- Algumas vezes o Angular não vai registrar o primeiro click em um candidato ou vaga

Uma trilha curta, fazendo basicamente as mesmas coisas que as outras trilhas, vou deixar pra adicionar os últimos featuras quando sobrar tempo, a agenda tá curta.



# Kafka

## Adição do Kafka
Essa trilha foi para adição Kafka e comunicação por mensageria.

## Como iniciar
Primeiramente, abra um servidor do Zookeeper, depois abra o kafka na porta 9092, após isso comece o host do MICRONAUT, é nele que criei um producer, então, abra a pasta KAFKA e comece a aplicação principal, logo após isso comece o host do Angular, insira um novo candidato com um email da sua escolha, logo após isso crie uma vaga e o email deverá chegar sem problemas.

## Bugs 
- Typescript tag não é transportada para box de  " Descrição da vaga "
- Email com a table de baixo não aparece


Segue imagem do bug ( que eu apelidei carinhosamente de IDENTIDADE DE BRAND ) :

![mail](https://user-images.githubusercontent.com/80402261/179337328-2d139e19-852f-41dd-a7f1-5a9481de4ca8.png)


