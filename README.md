# Literalura - Aplicación de Consulta de Libros

## Descripción
Literalura es una aplicación desarrollada en Java utilizando Spring Boot para el programa de ONE(Oracle en alianza con Alura)desarrollada por David Castro Carvajal para uno de los retos del programa ONE, aplicando los conocimientos adquiridos en el programa

## Funcionalidades
1. **Consulta de libro (en API)**
    - Permite buscar y consultar información de libros desde la API de gutendex.

2. **Consulta de libros en base de datos**
    - Muestra el historial completo de libros almacenados en la base de datos local, con el fin de mostrar el historial del usuario.

3. **Consulta de libros por idioma en base de datos**
    - Permite buscar libros almacenados en la base de datos local filtrados por idioma.

4. **Consulta de autores en base de datos**
    - Permite buscar y consultar información de autores almacenados en la base de datos local.

5. **Autores vivos en determinado año en base de datos**
    - Permite buscar autores cuyas fechas de nacimiento y fallecimiento incluyan un año específico dentro de la base de datos.

## Componentes Principales
- **Logica.java**: Contiene la lógica de negocio para la gestión de libros y autores.
- **Principal.java**: Clase principal que maneja la interfaz de usuario mediante un menú interactivo.
- **ConsumoApi.java**: Clase para realizar solicitudes y consumir datos de una API externa.
- **Autor.java y Libro.java**: Entidades JPA que representan las tablas de autores y libros en la base de datos.

## Uso
- Ejecutar la aplicación `LiterAluraApplication.java`.
- Seguir las instrucciones del menú para realizar consultas de libros y autores.