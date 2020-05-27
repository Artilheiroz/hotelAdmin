#HotelAdmin
WebApp utilizando Angular 9, Bootstrap 4, WebServices RESTful com Java SpringBoot

##Back-End
Desenvolvido em Java utilizando Spring Boot, serviços web RESTful, Hibernate para comunidade de bancod e dados PostgreSql
### Pré-Requisitos
- Java JDK 8+  [Download JDK](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html "Download JDK");
- Maven compativel com Java 8 [Download Maven](https://maven.apache.org/download.cgi "Download Maven").

### Executando
Alterar os dados de Conexão com o banco de dados no arquivo  src\main\resources\application.properties

Para Executar a parte back-end basta executar o código a partir do arquivo HtaApplication.java

ou executar a seguinte linha de comando no Prompt de comando na pasta raiz do projeto

```bash
mvn spring-boot:run
```

###End-Points
#### A aplicação possui os seguintes end-points para Hóspedes:
- **(GET)** /hotelAdmin/hospede/getHospedes : Retorna todos os Hospedes do banco de dados
- **(GET)** /hotelAdmin/hospede/getHospedeById/{hospedeId} : Retorna o Hóspede com aquele ID
- **(GET)** /hotelAdmin/hospede/getHospedesByNome/{nome} : Retorna todos os Hóspedes do que contenham parte do nome informado, é case insensitive
- **(GET)** /hotelAdmin/hospede/getHospedesByDocumento/{documento} :  Retorna todos os Hóspedes com documento aproximado ao informado
- **(GET)** /hotelAdmin/hospede/getHospedesByTelefone/{telefone}:  Retorna todos os Hóspedes com telefone aproximado ao informado
- **(GET)** /hotelAdmin/hospede/getHospedesAtivos: Retorna todos os Hóspedes que estão no Hotel
- **(GET)** /hotelAdmin/hospede/getHospedesAnteriores: Retorna todos os Hóspedes que já estiveram no Hotel mas não estão no momento
- **(POST)**/hotelAdmin/hospede/createHospede: Cadastra Hóspede, espera JSON no RequestBody como demonstrado abaixo
- **(PUT)** /hotelAdmin/hospede/updadeHospede/{hospedeId}: Atualiza Hóspede, espera JSON no RequestBody como demonstrado abaixo
- **(DELETE)** /hotelAdmin/hospede/deleteHospede/{hospedeId}: Remove Hóspede

##### Exemplo JSON Hóspede
```json
{
	"nome": "Teste",
	"documento": "123456789",
	"telefone": "123456789"
}
```

#### A aplicação possui os seguintes end-points para Estadias:
- **(GET)** /hotelAdmin/estadia/getEstadias: Retorna Todas as estadias do banco de dados
- **(GET)** /hotelAdmin/estadia/getEstadia/{estadiaId}: Retorna a estadia com o id especificado
- **(POST)** /hotelAdmin/estadia/createEstadia: Cadastra Estadia, espera JSON no RequestBody como demonstrado abaixo
- **(PUT)** /hotelAdmin/estadia/updadeEstadia/{estadiaId}: Atualiza Estadia, espera JSON no RequestBody como demonstrado abaixo
- **(DELETE)**/hotelAdmin/estadia/deleteEstadia/{estadiaId}: Remove Estadia

##### Exemplo JSON Estadia - datas padrão ISO-8601
```json
{
	"hospede": objPessoa,
	"dataEntada": "2018-03-14T08:00:00",
	"dataSaida": "2018-03-16T10:17:00",
	"adicionalVeiculo": false
}
```

##Front-End
### Pré-Requisitos
- Node.js  [Download Node.js](https://nodejs.org/en/download/ "Download Node.js")
- Gerênciador de pacotes NPM [Instal npm](https://www.npmjs.com/get-npm "Instal npm")
- Angular CLI [Instal Angular CLI](https://cli.angular.io/ "Instal Angular CLI")

### Executando
Para executar o projeto front end basta ir na pasta raiz do projeto angular **hotelAdmin\hta\src\main\webapp\hotelAdmin** e executar o seguinte código

```bash
ng serve --open
```

Caso alterar a porta em que está sendo executado o WebService Rest do padrão localhost:8080 alterar nos arquivos 
1. cadastro-hospede.component.ts 
2. check-in.component.ts
3. tabela-hospede.component.ts

[![](https://imgur.com/a/EcNsQ46)](https://imgur.com/a/EcNsQ46)
