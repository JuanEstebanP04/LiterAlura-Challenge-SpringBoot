# LiterAlura SpringBoot
Este repositorio contiene el código del proyecto desarrollado para el Alura Challenge Latam de SpringBoot, donde se presenta una solución innovadora para construir un catálogo de libros propio: el LiterAlura. En este reto se ponen a prueba los conocimientos para realizar solicitudes a una API de libros, manipular datos JSON, guardarlos en una base de datos Postgresql y, finalmente, ofrecer una interacción textual (vía consola) a los usuarios.

## Listado de funcionalidades
![image](https://github.com/JuanEstebanP04/LiterAlura-Challenge-SpringBoot/assets/90432563/8e35efd6-a4d0-41a7-bcc4-8f56d09a960b)

## Utilizando nuestro LiterAlura
### Buscar libro
Para esta funcionalidad, realizamos las consultas con la api de gutendex https://gutendex.com/books/
Lo primero es que se valida si en nuestra base de datos ya existe el libro consultado, para no crear un nuevo registro, ejemplo:

![image](https://github.com/JuanEstebanP04/LiterAlura-Challenge-SpringBoot/assets/90432563/28d49607-e989-41aa-ac93-a26c0d0d664a)

De lo contrario, se tomara la información traida con la api y se guardara un nuevo registro en la base de datos.
### Libros registrados
Esta funcionalidad nos trae el listado de todos los libros que se hayan registrado en nuestra base de datos
![image](https://github.com/JuanEstebanP04/LiterAlura-Challenge-SpringBoot/assets/90432563/06d6b3dc-f9bd-4be8-9010-41dd3216c36e)

### Autores registrados
Al momento de registrar un nuevo libro, tambien registramos un autor en nuestra base de datos, con esta funcionalidad, podemos listar todos los autores y los libros que hayamos consultado.
![image](https://github.com/JuanEstebanP04/LiterAlura-Challenge-SpringBoot/assets/90432563/beb8b681-adce-4477-afd9-c991f4a82b70)

### Listar autores vivos en un determinado año
Podemos filtar la lista de autores de acuerdo a un año en especifico
![image](https://github.com/JuanEstebanP04/LiterAlura-Challenge-SpringBoot/assets/90432563/7b9b5f17-3dd7-44f2-8209-df8cc82bda17)

### Listar libros por idioma
Podemos filtar la lista de libros de acuerdo a un idioma en especifico

![image](https://github.com/JuanEstebanP04/LiterAlura-Challenge-SpringBoot/assets/90432563/07b8f153-810f-463f-a30a-4de8c3920ec4)
