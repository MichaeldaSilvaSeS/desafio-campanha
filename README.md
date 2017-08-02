# desafio-campanha
Design em Camadas
------------------------
-  Platform   : Camada transversal que cuida de configuracoes das ferramentas e framework
-  Controller : Camada responsavel pela exposicao dos servicos de dominio e recebimento das requisicoes
-  Service    : Camada responsavel pelas interfaces dos servicos/logicas do dominio
-  Model      : Camada responsavel pelos objetos do dominio, incluindo as entidades do dominio e regras de negocio
-  Repository : Camada responsavel pela persistencia de dados

Tecnologias utilizadas
------------------------
- Java 7 						: Plataforma Java
- Spring Boot 			: Segmento do framework Spring voltado para microservicos
- Spring Data-JPA 	: Segmento do framework Spring voltado para persistência de dados
- Spring Web 				: Segmento do framework Spring voltado ao desenvolvimento de servicos
- Tomcat embedded 	: Servidor embarcado que executara a aplicacao
- HSQLDB embedded 	: Servidor de banco de dados relacional 
- Lombok 						: Facilitador para auto gerar Getter and Setter
- ModelMapper 			: Facilitador para o mapeamento entro modelo e a representacao
- Swagger 					: Facilitador para disponibilizacao e construcao de documentacao dos servicos
- Maven 						: Gerenciador de dependencia
- JUNIT/RestTemplate: Ferramenta para construacao dos teste de integracao

Execucao
------------------------
- Tomcat	: portas (8080 ou 8181), verificar application.properties do projeto
- Maven		: $ mvn clean package spring-boot:run
- Swagger	: http://localhost:8082/swagger-ui.html
- Restlet (opcional): instale o pluggin https://chrome.google.com/webstore/detail/restlet-client-rest-api-t/aejoelaoggembcahagimdiliamlcdmfm e importe o arquivo dhc.json 
