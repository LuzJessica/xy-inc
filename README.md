![logo](https://user-images.githubusercontent.com/25165426/55489625-a46f5e80-5608-11e9-8c13-ad81ea68cc9d.jpg)
__________________________________________________________________________________________________________________________________________

### Bem Vindo,

A _XY Inc._ é uma empresa especializada na produção de excelentes receptores GPS (_Global Positioning System_).
Este projeto tem como objetivo te auxiliar na localização de pontos de interesse (POIs). 
Para isso acesse as páginas que encontram-se na opção __Listar__ do Menu.
Além disso você pode ainda cadastrar um novo ponto de interesse. Basta acessar a página __Cadastrar Ponto__ através da opção __Cadastrar__ do Menu.

__________________________________________________________________________________________________________________________________________

### Preparando o ambiente:


<ol>
  <li>Cria uma pasta com o nome XY_INC no seu Desktop</li>
  <li>Dentro do diretório criado, através do botão direito do mouse, acesse o GitBash clicando em GitBash Here</li>
  <li>Com o terminal do git aberto, inserir o seguinte comando: </li>
  
       git clone https://github.com/LuzJessica/xy-inc.git
       
  <li>Abrir o Eclipse e importar o projeto seguindo os seguintes passos: </li>
  
    File -> Import -> General -> Existing Projects Into Workspace -> Next -> Browser
    
  <li>Selecionar a pasta xy-inc que encontra-se dentro da pasta XY_INC criada anteriormente. Ao final deste processo vc terá no eclipse uma estrutura como na imagem abaixo:</li>
  
  ![Estrutura](https://user-images.githubusercontent.com/25165426/55489483-5eb29600-5608-11e9-926a-0c41457f92b6.png)
  
  <li>Em sua base de dados, executar o script xy-inc.sql contido neste projeto a fim de criar schema e table</li>
  <li>No projeto, no pacote br.com.xyinc.factory, na classe ConexaoFactory, alterar as variáveis URL, USUARIO e SENHA, de acordo com as configurações da sua base de dados</li>
 
  
</ol>

________________________________________________________________________________________________________________________________________
##Testes

### Testes Unitários:

Existe uma classe de testes dentro do pacote __br.com.xyinc.testes__ chamada __StringUnitTests__. Nela encontram-se os testes entre a Aplicação e Base de Dados

<ol>
  <li>sucessoConexao()</li>
   
    Testa a conexão entre a aplicação e a base de dados. Passando valores corretor de URL, 
    USUARIO e SENHA o teste retornará OK.
    
  <li>cadastrarPonto()</li>
  
    Testa o cadastro de um novo Ponto no sistema. Para que o teste retorne OK todos os 
    parâmeteos do objeto ponto (exceto id) devem ser setados, já que estes são obrigatórios.
    
  <li>deletarPonto()</li>
    
    Testa a exclusão de um Ponto. Para que o teste retorne OK é necessário setar um ID 
    que de fato esteja cadatrado na base de dados. Funcionalidade não é utilizada pelo 
    portal mas está preparada caso necessário.
    
  <li>atualizarPonto()</li>
    
    Testa a Edição de um Ponto. Para que o teste retorne OK é necessário setar um ID 
    que de fato esteja cadatrado na base de dados. Funcionalidade não é utilizada pelo 
    portal mas está preparada caso necessário
  
  <li>listarTodosPontos()</li>
    
    Verifica se existem pontos cadastrados no sistema. Se existirem retorna-os.
  
  <li>listarPorProximidade()</li>
    
    Lista os pontos encontrados segundo pontos X, Y e Distância máxima fornecidos. 
    Para que o teste retorne OK, nenhum dos parâmetros citados anteriormente podem estar vazios
</ol>

### Testes de Sistema:

Para acessar a página Inicial do Sistema, utilizar a URL: http://localhost:8080/xy-inc/faces/pages/main.xhtml
A partir desta, as demais funcionalidades poderão ser acessadas e testadas!
________________________________________________________________________________________________________________________________________

### Desenvolvido por:

![download](https://user-images.githubusercontent.com/25165426/55494076-7b52cc00-5610-11e9-9db7-d0b877f9f92e.png) Jéssica Cristina Santos Luz, Bacharela em Engenharia da Computação pelo Instituto Nacional de Telecomunicações - INATEL

________________________________________________________________________________________________________________________________________
![logo](https://user-images.githubusercontent.com/25165426/55489625-a46f5e80-5608-11e9-8c13-ad81ea68cc9d.jpg)
