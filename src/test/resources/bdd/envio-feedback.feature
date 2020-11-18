@tag
Feature: Envio feedback
  Como usuario do sistema necessito de uma area para envio de feedback que possam ser avaliados posteriormente

  Scenario Outline: Envio feedback
    Given Que estou na pagina de envio de mensagem
    When Preencher o campo primeiro nome <primeironome>
    And Preencher o campo ultimo nome <ultimonome>
    And Preencher o campo email <email>
    And Preencher o campo mensagem <mensagem> 
    Then Clicar no botao submit sistema deve validar os dados a apresentar mensagem <resultado> 

    Examples: 
 		  |primeironome 				| ultimonome 		 | email 								| mensagem 			   | resultado |
      | 'Fulano'  					|  'Da Silva'  	 | 'ivo.mrqs@gmail.com' | 'mensagem 1'		 | 'sucesso' |
   		| 'Ciclano'   				|  'Da Silva'  	 | 'ivo.mrqs' 					| 'mensagem 2'		 | 'erro'    |