/*Mostrar todos los registros de la tabla de movies.
Mostrar el nombre, apellido y rating de todos los actores.
Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
Mostrar los títulos de las primeras tres películas en la base de datos.
Mostrar el top 5 de las películas con mayor rating.
Listar los primeros 10 actores.
Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
Mostrar a todos los actores cuyos nombres empiezan con Sam.
Mostrar el título de las películas que salieron entre el 2004 y 2008.
Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
*/

SELECT * FROM movies m ;

select a.first_name, a.last_name, a.rating  from actors as a;

select s.title as titulos from series s;

SELECT first_name , last_name  from actors a 
WHERE rating > 7.5;

SELECT title , rating , awards  from movies m 
WHERE rating > 7.5 and awards > 2;

SELECT title , rating  from movies m
order by rating asc;

SELECT title  from movies m limit 3;

SELECT * from actors a limit 10;

SELECT title, rating from movies m where title = 'Toy Story'

SELECT * from actors a  WHERE a.first_name like 'SAM%'

SELECT title from movies m where m.release_date BETWEEN '2004-01-01' and '2008-01-01'

SELECT title  from movies m 
where rating > 3 and awards > 1 and release_date BETWEEN '1988-01-01' and '2009-01-01'
ORDER by rating ;

