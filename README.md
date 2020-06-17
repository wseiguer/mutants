#Ejercicio Mutantes - Mercadolibre

Examen entrevista para Mercado Libre - Junio 2020

Se puede ver una version estable del proyecto aqui:

- [servicio es mutante](http://ec2-13-58-238-161.us-east-2.compute.amazonaws.com:4567/mutants/).
- [servicio estadisticas](http://ec2-13-58-238-161.us-east-2.compute.amazonaws.com:4567/stats).

- [Ejercicio](#ejercicio)
  - [Especificaciones](#especificaciones)
  - [Implementación y tecnologias usadas](#implementaci%C3%B3n-y-tecnologias-usadas)
  - [Comentarios relevantes](#comentarios-relevantes)
- [Setup](#setup)
  - [Instrucciones](#instrucciones)
  - [Uso](#uso)
  - [API Url](#api)
  - [Servicios](#servicios)
    - [Es mutante](#es-mutante)
    - [Estadisticas](#estadisticas)
- [Test](#test)
  - [Automaticos](#automaticos)

## Ejercicio

### Especificaciones

Las especificaciones del proyecto se encuentran en la carpeta 'specs'.

### Implementacion y tecnologias usadas

- [SpringBoot](https://spring.io/projects/spring-boot)
- [MySql](https://dev.mysql.com/)
- [jUnit](http://junit.org/)
- [MAVEN](https://maven.apache.org/)

### Comentarios relevantes
Cuando comence a realizar el proyecto no estaba familiarizado con Spring Framework, ni con Spring boot, por lo que tuve la oportunidad de aprender
los conceptos basicos de este framework utilizando la [documentacion oficial de spring boot](https://spring.io/quickstart) y distintos tutoriales.

## Setup

### Instrucciones
Para compilar y ejecutar el proyecto es necesario contar con la version 11 de la JDK y Maven para la gestion de las dependencias.

Tambien es necesario contar con una instancia de Mysql en caso de querer ejecutarlo localmente, se utilizan los datos de conexion por default de Mysql o tambien se pueden utilizar las variables de sistema (MYSQL_HOST,MYSQL_PORT,MYSQL_USERNAME,MYSQL_PASSWORD) si la instacia contiene una configuración diferente.

Clonar este repositorio: https://github.com/Saibuerns/mutants

### Uso

Para iniciar la aplicación, asegúrese de cumplir con las instrucciones anteriores. 

Una vez listo, ejecutar la clase principal MutantApplication en su IDE preferido y espere hasta que se inicie la aplicación.

Tambien se puede iniciar la aplicacion con el siguiente comando en linea de comandos posicionandose en el directorio raiz
del proyecto:
```
mvn spring-boot:run
```

### API Url

URL local: http://localhost:8080

URL hosteada en Amazon: http://mutants-env.eba-9p3bcg9b.us-east-2.elasticbeanstalk.com/

### Servicios
#### Es mutante

Request: 
- POST http://mutants-env.eba-9p3bcg9b.us-east-2.elasticbeanstalk.com/mutant/

Request body (caso ADN mutante):

```
  {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}
```

Response:

```
  200 OK
```
Request body (caso ADN humano):

```
  {"dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "GGATCG", "TCACTG"]}
```

Response:

```
  403 Forbidden
```

#### Estadisticas

Request: 
- GET http://mutants-env.eba-9p3bcg9b.us-east-2.elasticbeanstalk.com/stats

Response: 200 (application/json)

```
{
    count_mutant_dna: 1,
    count_human_dna: 1,
    ratio: 0.5
}
```

### Test

#### Automaticos
Para la ejecucion de los test automaticos utilice jUnit.

