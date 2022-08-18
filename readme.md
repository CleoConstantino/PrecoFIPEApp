## Descrição do projeto:
Projeto desenvolvido para o aprendizado da disciplina de 'Desenvolvimento de aplicações móveis' da pós graduação 'Desenvolvimento Fullstack de Sistemas Modernos para Nuvem (Cloud Native)'.
Desenvolvido um Aplicativo para realizar buscas de preços da tabela Fipe em tempo real, contemplando uma tela de login, uma listView, consultar via webservice o valor do carro e mostrar para o usuário.

## Técnicas, tecnologias e ferramentas utilizadas

Para a criação desse App foi utilizando a IDE Android Studio e a linguagem de programação Java.

Conceitos de xml, activity, banco de dados, webservices e utilizado o componente de lista (ListView).

Utilizado o HashMap para simular um "banco de dados", apenas para validar as informações de login;

## Funcionalidades do projeto



# Pós-Gradução Desenvolvimento Fullstack de Sistemas Modernos para Nuvem (Cloud Native)

## Desenvolvimento de aplicações móveis //Instruções da aula

## Dicas de um bom aplicativo

- Globalização: quanto mais idiomas colocar no aplicativo melhor ele vai ser divulgado;
- Visual do ícone: o ícone e a porta de entrada do aplicativo, ícone clean e que chame a atenção;
- Texto da descrição: quando sobre o aplicativo e faz o depoly nas lojas, você vai ter um espaço disponível para colocar a descrição;
- Monetização 1: In-app Ads (não exagerar);
- Monetização 2: Compras via In-app purchase (se o aplicativo pode oferecer algo, pode colocar);
- Feedback 1: dados de navegação e opiniões dos usuários;
- Feedback 2: ferramentas de inteligência que o Google oferece.
- Testes: o aplicativo deve subir da melhor forma possível.
- Ecosistema: o aplicativo anterior faz propaganda para o próximo aplicativo a ser lançado.

**Monetização de aplicativos:**
- Terceirização de monetização usando (In-App Adds): monetização por anuncio, a plataforma vai escolher com base no seu aplicativo e big data qual anuncio ele vai disponibilizar, para aparecer algo relacionado ao teu app;
- Terceirização usando In-App purchase: tem ótimos resultados para games, ex: compra de skins, roupas dos personagens que o jogo coloca a venda;

## Ferramentas de desenvolvimento

- Android Studio: baixar fazer a instalação e fazer um projeto zerado para concluir todas as instalações: https://developer.android.com/;
- Será utilizado a linguagem de programação Java;
- Project > 'Nome do projeto' > app > src > main:
    - o arquivo AndroidManifest.xml é onde são incluidas as permissões necessárias para o aplicativo funcionar, ex; câmera, internet, etc...

> <uses-permission android:name="android.permission.CAMERA"/

- pasta 'res':
- drawable: onde vai ficar todas as imagens, planos de fundo, botão com imagens;
- layout: onde será desenvolvido a interface das telas, arquivos .xml;
- mipmap: ícones do aplicativo, cada pasta representa um tamanho diferente do ícone;
- values > colors: cores disponíveis para serrem utilizadas;
- values > strings: onde vai estar todas as constantes (ex: botão 'Gravar');
- values > themes: tema do aplicativo;
- pasta Java: é onde vamos fazer toda a programação, e onde vamos linkar toda parte de programação com o layout do arquivo .xml

## Conceitos e práticas fundamentais

- View: quando eu for adicionar algum botão, label, campo para digitação, no aplicativo tudo é tratado como 'view';
- Atributos básicos de todos os componentes:
  - (altura) android: layout_height
  - (largura) android: layout_width
  - (peso) android: layout_weight
  - (direção) android: layout_gravity
  - Gerenciador de layouts:
    - LinearLayout
    - RelativeLayout
    - TableLayout
    - FrameLayout
    - GridView

Para cada xml(tela) que foi criado deve-se ter uma classe em Java correspondente. Ex: quando foi criado o projeto, automaticamente a ferramenta cria o arquivo 'activity_main.xml' que é correspondente ao arquivo em java 'MainActivity', e essa classe herda as propriedades de 'AppCompatActivity' e tem um método bem especifico > .onCreate (quando abrir o aplicativo, ele vai passar dentro do .onCreate e ele vai setar a view que será utilizada) dessa forma, essa classe Java está sendo associada automaticamente pelo arquivo .xml.

ScrollView: insere uma barra de rolagem => é uma tag "pai" que só pode ter um "filho", onde as outras tags devem ficar dentro de 'LinearLayout';

O arquivo AndroidManifest.xml deve ter registrado todas as telas do app.

## Banco de dados para dispositivos móveis - SQLite

O Android oferece um suporte completo para banco de dados, chamado de SQLite. É um tipo de banco de dados que pode ser criado e acessado por qualquer classe da aplicação mas não pode ser acessado por outras aplicações, é de uso exclusivo para o aplicativo que está sendo desenvolvido.

É uma biblioteca de software que implementa e faz uso de um banco de dados relacional.

Caracteristicas: não é uma biblioteca client, usada para conectar em um servidor de banco de dados, mas funciona como um proprio servido, é mais rápido por conta disso, ele está tudo local, diretamente no aparelho (smatphone).

Topologia SQLite Mobile: cada aplicativo possui uma biblioteca SQLite Library onde ele faz aassociação direta. O SQLite tem um arquivo .db que cada instância do aplicativo tem o seu arquivo.

Desvantangens de usar o SQLite: tem uma alta concorrência, tem muitos recursos sendo utilizados e o processamento pode ficar mais lento. Grades conjuntos de dados - arquivo do banco não pode exceder o limite. Não tem controle de acesso 100% seguro.

Tipo de de dados que o SQLite trabalha:

- NULL, um valor nulo;
- INTEIRO: um inteiro assinado, armazenado em 1, 2, 3, 4, 5, 6 ou 8 bytes de acordo com a magnitude do valor;
- REAIS:  um número de ponto flutuantes;
- TEXTO: uma sequencia armazenada com codificações;
- BLOB: em fomato binário, são armazenados exatamente como entrou.

**Linguagem DDL e DML:**
DDL: CREATE, DROP, ALTER (basicamente não precisam de commit);
DML: SELECT, INSERT*, UPDATE*, DELETE* (*precisam de commit);

## Estrutura a ser utilizada > SQLite na prática

Para trabalhar com SQLite de forma organizada e otimizada, a estrutura abaixo deverá ser criada:

- Database
    - model (pacote);
    - dao (pacote);
    - helper (classe) - vai ajudar a criar o banco de dados, (vai ter o nome e a versão do banco de dados e vai fazer a função de create table);

Onde:

- Model: conterá o modelo de classe a ser utilizada (vão ser representativos conforme a tabela que eu criar no banco de dados, vai conter todos os atributos dessa tabela);
- DAO: conterá o objeto de acesso a base de dados (data access object, vai ter o controller, vai ser responsável por fazer o insert, select, update e delete, abre e fecha a conexão com o banco) -  opem > faz a operação > close;

Passo 01
Para se criar, evoluir e abrir banco de dados, a maneira recomendada é criar uma subclasse (classe filha) de SQLiteOpenHelper no pacote database e definir:

- Construtor;
- Método onCreate();
- Método onUpgrade();

Passo 02
Deve-se criar as classes no pacote database.model para modelar o(s) objeto(s) a ser(em) gravado(s) no banco de dados. Como por exemplo, se o objetivo irá guardar os dados de uma Pessoa, deve-se criar a classe PessoaModel e implementá-la.

Passo 03
Deve-se criar a classe para manipulação da tabela no pacote database.dao e implementar os métodos Open, Close, Insert, Delete, Select e Update.
Sugestão: Como todas as classes no pacote database.dao precisam implementar os método Open() e Close(), que são exatamente iguais para todas as tabelas, cria-se uma classe Abstrata para implementá-los.

Passo 04
Depos de toda a implementação feita, deve-se dar permissão no arquivo Manifest.xml de escrita e leitura do disco:

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>  
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>