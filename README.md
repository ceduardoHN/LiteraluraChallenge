# LiteraluraChallenge

## Índice

- [Descripción del Challenge](#descripción-del-challenge)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Demostración del sistema](#demostración-del-sistema)
- [Datos Relevantes](#datos-relevantes)

## Descripción del Challenge
Biblioteca de libros con ayuda de la API [Gutendex](https://gutendex.com/). En este proyecto se utilizan algunas funcionalidades como solicitudes HTTP, manejo y manipulación de objetos de tipo json, modelado y persistencia de datos por medio de [Java Persistence API (JPA)](https://spring.io/projects/spring-data-jpa); y por último la esencia del programa, el filtrado y muestra de los libros y sus respectivos autores a traves de diferentes técnicas como [Derived Queries](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html) o Java Persistence Query Language (JPQL).

## Requisitos del Sistema
Como requisito para este proyecto se necesitarón las siguientes herramientas:
- IntelliJ IDEA Community Edition
    - Como entorno de desarrollo.
    - [Jetbrains](https://www.jetbrains.com/idea/)
- Postman API Platform
    - Para probar las rutas proporcionadas por la API Gutendex.
    - [Postman](https://www.postman.com/)
- PostgreSQL
    - Como servicio y gestor de base de datos (pgAmdin 4).
    - [PostgreSQL](https://www.postgresql.org/)

## Demostración del Sistema
Se recomienda ver el siguiente video para comprender mejor la explicación posterior.<br>
[![Enlace del video](https://img.youtube.com/vi/0lsB96Zlwv4/maxresdefault.jpg)](https://youtu.be/0lsB96Zlwv4)

### 1. Se despliega el Menú Principal del sistema. 
   - Muestra las siguientes opciones:
     - Buscar/Agregar libro por título.
     - Obtener libros registrados/buscados.
     - Buscar autores vivos en un determinado año.
     - Buscar libros por idioma.
     - SALIR
### 2. El sistema proporciona alertas, al momento de ingreso de datos por parte del usuario, cuando es requerido. <br> 
- Al momento de buscar datos en la base, el sistema alerta segun corresponda el caso si no existen datos o no hay coincidencias segun los parametros especificados por el usuario.
- Cuando el usuario ingresa un código de idioma que la API [Gutendex](https://gutendex.com/) no reconoce o no soporta. 

## Datos Relevantes
[Alura Badge](https://drive.google.com/file/d/1KNz-YaPmHDY0Jqg0TqB3Kx7U1i4qrYzV/view?usp=sharing)
<br>
<b>Autor: Eduardo Soriano</b>. <br>
Perfil de Github: [ceduardoHN](https://github.com/ceduardoHN/) <br>

<b>Fecha de Lanzamiento: 11 de julio de 2024</b>
